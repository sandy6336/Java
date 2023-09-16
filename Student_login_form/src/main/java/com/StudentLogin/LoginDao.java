package com.StudentLogin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LoginDao {
    private static final String url = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String userName = "hr";
    private static final String password = "hr";

    public boolean insertUser(User user) {
        Connection con = null;
        PreparedStatement pst = null;
        boolean result = false;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(url, userName, password);

            String query = "INSERT INTO Login (UserName, Password) VALUES (?, ?)";
            pst = con.prepareStatement(query);

            pst.setString(1, user.getUsername());
            pst.setString(2, user.getPassword());

            int rowsAffected = pst.executeUpdate();

            if (rowsAffected > 0) {
                result = true;
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
