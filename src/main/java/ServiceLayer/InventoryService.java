package ServiceLayer;

import Controllers.InventoryController;
import DatabaseLayer.DatabaseConnection;
import Models.Inventory;

import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class InventoryService {
    private DatabaseConnection connection;

    public InventoryService() {
        connection = DatabaseConnection.getSingleInstance();
    }

    public int addItemToDatabase(Inventory Item) throws SQLException {
        String insertQuery = "INSERT INTO Items (ItemName, ItemCategory, ItemPrice, ItemQuantity, ItemDate) VALUES (?, ?, ?, ?, CURRENT_TIMESTAMP)";
        boolean result = connection.ExecuteQuery(insertQuery,
                Item.getItemName(),
                Item.getItemCategory(),
                Item.getItemPrice(),
                Item.getItemQuantity());

        if (result) {
            try (ResultSet generatedKeys = connection.ExecuteSelectQuery("SELECT LAST_INSERT_ID()")) {
                if (generatedKeys.next()) {
                    int generatedID = generatedKeys.getInt(1);
                    Item.setItemID(generatedID);

                    InventoryController inventoryController = Item.getInventoryController();
                    if (inventoryController != null) {
                        inventoryController.addItem(Item);
                    }
                    return generatedID;
                } else {
                    throw new SQLException("Failed to get generated keys after adding Item");
                }
            }
        } else {
            throw new SQLException("Failed to add Item");
        }
    }

    public void deleteItemFromDatabase(Inventory Item) throws SQLException {
        if (Item.getItemID() != 0) {
            String deleteQuery = "DELETE FROM Items WHERE ItemID = ?";
            boolean result = connection.ExecuteQuery(deleteQuery, Item.getItemID());

            if (!result) {
                throw new SQLException("Failed to delete Item");
            }
        } else {
            throw new SQLException("Item ID is not set");
        }
    }

    public void updateDatabase(Inventory Item) throws SQLException {
        String updateQuery = "UPDATE Items SET ItemName=?, ItemCategory=?, ItemPrice=?, ItemQuantity=? WHERE ItemID=?";
        boolean result = connection.ExecuteQuery(updateQuery,
                Item.getItemName(),
                Item.getItemCategory(),
                Item.getItemPrice(),
                Item.getItemQuantity(),
                Item.getItemID());

        if (!result) {
            throw new SQLException("Failed to update Item");
        } else {
            System.out.println("Item updated successfully in the database");
        }
    }

    public DefaultTableModel getInventoryTableModel() {
        String selectQuery = "SELECT * FROM Items";
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
                String ItemID = rs.getString(1);
                String ItemName = rs.getString(2);
                String ItemCategory = rs.getString(3);
                String ItemPrice = rs.getString(4);
                String ItemItemQuantity = rs.getString(5);

                String[] row = {ItemID, ItemName, ItemCategory, ItemPrice, ItemItemQuantity};
                model.addRow(row);
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving item data: " + e.getMessage());
            return null;
        }

        return model;
    }
}