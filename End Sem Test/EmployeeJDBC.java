import java.sql.*;

public class EmployeeJDBC {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/est   ";
        String user = "root";
        String password = "Letmedie@69";

        try {
            // Step 1: Connect to the database
            Connection conn = DriverManager.getConnection(url, user, password);

            // Step 2: Insert employee records
            String insertQuery = "INSERT INTO employees (id, name, department) VALUES (?, ?, ?)";
            PreparedStatement insertStmt = conn.prepareStatement(insertQuery);
            insertStmt.setInt(1, 101);
            insertStmt.setString(2, "Alice");
            insertStmt.setString(3, "HR");
            insertStmt.executeUpdate();

            insertStmt.setInt(1, 102);
            insertStmt.setString(2, "Bob");
            insertStmt.setString(3, "Finance");
            insertStmt.executeUpdate();

            // Step 3: Display employee records
            String selectQuery = "SELECT * FROM employees";
            Statement selectStmt = conn.createStatement();
            ResultSet rs = selectStmt.executeQuery(selectQuery);

            System.out.println("Employee Records:");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String dept = rs.getString("department");
                System.out.println(id + " | " + name + " | " + dept);
            }

            // Step 4: Close connections
            rs.close();
            insertStmt.close();
            selectStmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
