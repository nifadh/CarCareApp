package ServiceLayer;

import Controllers.SupplierController;
import DatabaseLayer.DatabaseConnection;
import Models.Supplier;

import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class SupplierService {
    private DatabaseConnection singleConn;

    public SupplierService() {
        singleConn = DatabaseConnection.getSingleInstance();
    }

    public int addSupplierToDatabase(Supplier supplier) throws SQLException {
        String insertQuery = "INSERT INTO Suppliers (SupplierName, SupplierAddress, SupplierPhone, SupplierCategory, SupplierCountry) VALUES (?, ?, ?, ?, ?)";
        boolean result = singleConn.ExecuteQuery(insertQuery,
                supplier.getSupplierName(),
                supplier.getSupplierAddress(),
                supplier.getSupplierPhone(),
                supplier.getSupplierCategory(),
                supplier.getSupplierCountry());

        if (result) {
            try (ResultSet generatedKeys = singleConn.ExecuteSelectQuery("SELECT LAST_INSERT_ID()")) {
                if (generatedKeys.next()) {
                    int generatedID = generatedKeys.getInt(1);
                    supplier.setSupplierID(generatedID);

                    SupplierController supplierController = supplier.getSupplierController();
                    if (supplierController != null) {
                        supplierController.addSupplier(supplier);
                    }
                    return generatedID;
                } else {
                    throw new SQLException("Failed to get generated keys after adding Supplier");
                }
            }
        } else {
            throw new SQLException("Failed to add Supplier");
        }
    }

    public void deleteSupplierFromDatabase(Supplier supplier) throws SQLException {
        if (supplier.getSupplierID() != 0) {
            String deleteQuery = "DELETE FROM Suppliers WHERE SupplierID = ?";
            boolean result = singleConn.ExecuteQuery(deleteQuery, supplier.getSupplierID());

            if (!result) {
                throw new SQLException("Failed to delete Supplier");
            }
        } else {
            throw new SQLException("Supplier ID is not set");
        }
    }

    public void updateDatabase(Supplier supplier) throws SQLException {
        String updateQuery = "UPDATE Suppliers SET SupplierName=?, SupplierAddress=?, SupplierPhone=?, SupplierCategory=?, SupplierCountry=? WHERE SupplierID=?";
        boolean result = singleConn.ExecuteQuery(updateQuery,
                supplier.getSupplierName(),
                supplier.getSupplierAddress(),
                supplier.getSupplierPhone(),
                supplier.getSupplierCategory(),
                supplier.getSupplierCountry(),
                supplier.getSupplierID());

        if (!result) {
            throw new SQLException("Failed to update Supplier");
        } else {
            System.out.println("Supplier updated successfully in the database");
        }
    }

    public DefaultTableModel getSupplierTableModel() {
        String selectQuery = "SELECT * FROM Suppliers";
        DefaultTableModel model = new DefaultTableModel();

        try (ResultSet rs = singleConn.ExecuteSelectQuery(selectQuery)) {
            ResultSetMetaData rsmd = rs.getMetaData();
            int cols = rsmd.getColumnCount();

            String[] col = new String[cols];
            for (int i = 0; i < cols; i++) {
                col[i] = rsmd.getColumnName(i + 1);
            }

            model.setColumnIdentifiers(col);

            while (rs.next()) {
                String supplierID = rs.getString(1);
                String supplierName = rs.getString(2);
                String supplierAddress = rs.getString(3);
                String supplierPhone = rs.getString(4);
                String supplierCategory = rs.getString(5);
                String supplierCountry = rs.getString(6);

                String[] row = {supplierID, supplierName, supplierAddress, supplierPhone, supplierCategory, supplierCountry};
                model.addRow(row);
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving supplier data: " + e.getMessage());
            return null;
        }

        return model;
    }
}