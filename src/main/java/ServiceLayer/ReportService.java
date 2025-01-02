package ServiceLayer;

import DatabaseLayer.DatabaseConnection;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReportService {
    private DatabaseConnection databaseConnector;

    public ReportService() {
        this.databaseConnector = DatabaseConnection.getSingleInstance();
    }

    public double fetchTotalSales(String year, int month) throws SQLException {
        String sql = "SELECT SUM(OrderPrice) FROM customerorder WHERE YEAR(OrderDate) = ? AND MONTH(OrderDate) = ?";
        try (ResultSet resultSet = databaseConnector.ExecuteSelectQuery(sql, year, month)) {
            if (resultSet.next()) {
                return resultSet.getDouble(1);
            }
        }
        throw new SQLException("Unable to fetch total sales");
    }

    public double fetchTotalExpenses(String year, int month) throws SQLException {
        String sql = "SELECT SUM(ItemPrice) FROM Items WHERE YEAR(ItemDate) = ? AND MONTH(ItemDate) = ?";
        try (ResultSet resultSet = databaseConnector.ExecuteSelectQuery(sql, year, month)) {
            if (resultSet.next()) {
                return resultSet.getDouble(1);
            }
        }
        throw new SQLException("Unable to fetch total expenses");
    }
}