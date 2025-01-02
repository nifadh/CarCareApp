package ServiceLayer;

import DatabaseLayer.DatabaseConnection;
import Models.Customersdetails;
import Controllers.customerController;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class customerDb {
    private DatabaseConnection connection;

    public customerDb() {
        connection = DatabaseConnection.getSingleInstance();
    }

    public int addToDatabase(Customersdetails customersdetails) throws SQLException {
        String insertQuery = "INSERT INTO customerorder (CustomerName, CustomerEmail, CustomercontactNo, OrderDescription, OrderPrice, OrderStatus, OrderDate) VALUES (?, ?, ?, ?, ?, ?, CURRENT_TIMESTAMP)";
        boolean result = connection.ExecuteQuery(insertQuery,
                customersdetails.getCustomerName(),
                customersdetails.getCustomerEmail(),
                customersdetails.getCustomercontactNo(),
                customersdetails.getOrderDescription(),
                customersdetails.getOrderPrice(),
                customersdetails.getOrderStatus());

        if (result) {
            try (ResultSet generatedKeys = connection.ExecuteSelectQuery("SELECT LAST_INSERT_ID()")) {
                if (generatedKeys.next()) {
                    int generatedID = generatedKeys.getInt(1);
                    customersdetails.setCustomerID(generatedID);

                    customerController customercontroller = customersdetails.getCustomercontroller();
                    if (customercontroller != null) {
                        customercontroller.addCustomer(customersdetails);
                    }
                    return generatedID;
                } else {
                    throw new SQLException("Failed to get generated keys after adding Customer");
                }
            }
        } else {
            throw new SQLException("Failed to add Customer");
        }
    }

    public void deleteFromDatabase(Customersdetails customersdetails) throws SQLException {
        if (customersdetails.getCustomerID() != 0) {
            String deleteQuery = "DELETE FROM customerorder WHERE CustomerID = ?";
            boolean result = connection.ExecuteQuery(deleteQuery, customersdetails.getCustomerID());

            if (!result) {
                throw new SQLException("Failed to delete Customer");
            }
        } else {
            throw new SQLException("Customer ID is not set");
        }
    }

    public void updateDatabase(Customersdetails customersdetails) throws SQLException {
        String updateQuery = "UPDATE customerorder SET CustomerName=?, CustomerEmail=?, CustomercontactNo=?, OrderDescription=?, OrderStatus=?, OrderPrice=? WHERE CustomerID=?";
        boolean result = connection.ExecuteQuery(updateQuery,
                customersdetails.getCustomerName(),
                customersdetails.getCustomerEmail(),
                customersdetails.getCustomercontactNo(),
                customersdetails.getOrderDescription(),
                customersdetails.getOrderStatus(),
                customersdetails.getOrderPrice(),
                customersdetails.getCustomerID());

        if (!result) {
            throw new SQLException("Failed to update Customer Order");
        } else {
            System.out.println("Customer updated successfully in the database");
        }
    }

    public DefaultTableModel getCustomerTableModel() {
        String selectQuery = "SELECT * FROM customerorder";
        DefaultTableModel model = new DefaultTableModel();

        try (ResultSet rs = connection.ExecuteSelectQuery(selectQuery)) {
            ResultSetMetaData rsmd = rs.getMetaData();
            int cols = rsmd.getColumnCount();

            String[] col = new String[cols];
            for (int i = 0; i < cols; i++) {
                col[i] = rsmd.getColumnName(i + 1);
            }

            model.setColumnIdentifiers(col);

            while (rs.next()) {
                String CustomerID = rs.getString(1);
                String CustomerName = rs.getString(2);
                String CustomerEmail = rs.getString(3);
                String CustomercontactNo = rs.getString(4);
                String OrderDescription = rs.getString(5);
                String OrderStatus = rs.getString(6);
                String OrderPrice = rs.getString(7);
                String OrderDate = rs.getString(8);

                String[] row = {CustomerID, CustomerName, CustomerEmail, CustomercontactNo, OrderDescription, OrderStatus, OrderPrice, OrderDate};
                model.addRow(row);
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving customer Order data: " + e.getMessage());
        }

        return model;
    }
}