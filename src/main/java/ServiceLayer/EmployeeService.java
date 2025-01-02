package ServiceLayer;

import DatabaseLayer.DatabaseConnection;
import Models.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeService {
    private DatabaseConnection connection;

    public EmployeeService() {
        connection = DatabaseConnection.getSingleInstance();
    }

    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        try {
            String query = "SELECT * FROM employees";
            ResultSet rs = connection.ExecuteSelectQuery(query);
            while (rs.next()) {
                Employee employee = new Employee(
                        rs.getInt("empID"),
                        rs.getString("empName"),
                        rs.getString("empPosition"),
                        rs.getString("empNIC"),
                        rs.getString("empPhone"),
                        rs.getString("empAddress"),
                        rs.getString("empEmail"),
                        rs.getString("empSalary")
                );
                employees.add(employee);
            }
        } catch (SQLException ex) {
            System.out.println("Cannot fetch employees: " + ex.getMessage());
        }
        return employees;
    }


    public Employee getEmployeeById(int empID) {
        Employee employee = null;
        try {
            String query = "SELECT * FROM employees WHERE empID='" + empID + "'";
            ResultSet rs = connection.ExecuteSelectQuery(query);
            while (rs.next()) {
                employee = new Employee(
                        rs.getInt("empID"),
                        rs.getString("empName"),
                        rs.getString("empPosition"),
                        rs.getString("empNIC"),
                        rs.getString("empPhone"),
                        rs.getString("empAddress"),
                        rs.getString("empEmail"),
                        rs.getString("empSalary")
                );
            }
            rs.close();
        } catch (SQLException ex) {
            System.out.println("Cannot fetch employees: " + ex.getMessage());
        }
        return employee;
    }


    public List<Employee> getEmployeeByName(String empName) {
        List<Employee> employees = new ArrayList<>();
        try {
            String query = "SELECT * FROM employees WHERE empName LIKE '%" + empName + "%'";
            ResultSet rs = connection.ExecuteSelectQuery(query);
            while (rs.next()) {
                Employee employee = new Employee(
                        rs.getInt("empID"),
                        rs.getString("empName"),
                        rs.getString("empPosition"),
                        rs.getString("empNIC"),
                        rs.getString("empPhone"),
                        rs.getString("empAddress"),
                        rs.getString("empEmail"),
                        rs.getString("empSalary")
                );
                employees.add(employee);
            }
            rs.close();
        } catch (SQLException ex) {
            System.out.println("Cannot fetch employees: " + ex.getMessage());
        }
        return employees;
    }



    public boolean addEmployee(Employee employee) {
        String query = "INSERT INTO employees (empName, empPosition, empNIC, empPhone, empAddress, empEmail, empSalary) VALUES (?, ?, ?, ?, ?, ?, ?)";
        return connection.ExecuteQuery(query,
                employee.getEmpName(),
                employee.getPosition(),
                employee.getNic(),
                employee.getPhone(),
                employee.getAddress(),
                employee.getEmail(),
                employee.getSalary());
    }

    public boolean updateEmployee(Employee employee) {
        String query = "UPDATE employees SET empName = ?, empPosition = ?, empNIC = ?, empPhone = ?, empAddress = ?, empEmail = ?, empSalary = ? WHERE empID = ?";
        return connection.ExecuteQuery(query,
                employee.getEmpName(),
                employee.getPosition(),
                employee.getNic(),
                employee.getPhone(),
                employee.getAddress(),
                employee.getEmail(),
                employee.getSalary(),
                employee.getEmpID());
    }

    public boolean deleteEmployee(int empID) {
        String query = "DELETE FROM employees WHERE empID = ?";
        return connection.ExecuteQuery(query, empID);
    }
}
