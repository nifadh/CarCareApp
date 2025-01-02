package DatabaseLayer;

import java.sql.*;

public class DatabaseConnection {
    private final String URL="jdbc:mysql://localhost:3306/carcaredb";
    private final String UName="root";
    private final String Password="";
    private static DatabaseConnection instance;
    private Connection con;

    private DatabaseConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con= DriverManager.getConnection(URL,UName,Password);
            System.out.println("Database Connection Sucess");
        }catch (ClassNotFoundException ex)
        {
            System.out.println("Driver Class Error "+ex.getMessage());
        }catch (SQLException ex)
        {
            System.out.println("Database Connection Error "+ex.getMessage());
        }
    }
    public static DatabaseConnection getSingleInstance() {
        try {
            if (instance == null) {
                instance = new DatabaseConnection();
            } else if (instance.con.isClosed()) {
                instance = new DatabaseConnection();
            }else{
                return instance;
            }
            return instance;
        }catch (SQLException ex)
        {
            System.out.println("Database Connection Error "+ex.getMessage());
            return null;
        }
    }

    public boolean ExecuteQuery(String sqlQ, Object... params) {
        try (PreparedStatement pstmt = con.prepareStatement(sqlQ)) {
            for (int i = 0; i < params.length; i++) {
                pstmt.setObject(i + 1, params[i]);
            }
            int result = pstmt.executeUpdate();
            return result > 0;
        } catch (SQLException ex) {
            System.out.println("SQL Error " + ex.getMessage());
            return false;
        }
    }

    public ResultSet ExecuteSelectQuery(String sqlQ) {
        try {
            Statement st=con.createStatement();
            ResultSet result=st.executeQuery(sqlQ);
            return result;
        } catch (SQLException ex) {
            System.out.println("SQL Error "+ex.getMessage());
            return null;
        }
    }

    public ResultSet ExecuteSelectQuery(String sqlQ, Object... params) {
        try {
            PreparedStatement pstmt = con.prepareStatement(sqlQ);
            for (int i = 0; i < params.length; i++) {
                pstmt.setObject(i + 1, params[i]);
            }
            return pstmt.executeQuery();
        } catch (SQLException ex) {
            System.out.println("SQL Error " + ex.getMessage());
            return null;
        }
    }



}
