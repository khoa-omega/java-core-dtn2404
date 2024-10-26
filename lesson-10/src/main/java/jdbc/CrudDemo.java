package jdbc;

import util.JdbcUtil;

import java.sql.*;

public class CrudDemo {
    public static void main(String[] args) {
        JdbcUtil.checkConnection();

        Department department = new Department();
        department.setName("VTI Education");

        System.out.println("---- DEMO CREATE ----");
        create(department);

        System.out.println("---- DEMO UPDATE ----");
        update(11, "VTI Academy");

        System.out.println("---- DEMO SELECT ----");
        select();

        System.out.println("---- DEMO PROCEDURE ----");
        procedure(5);

        System.out.println("---- DEMO TRANSACTION ----");
        transaction(1, 2);
    }

    public static void transaction(int id1, int id2) {
        String sql = "DELETE FROM department WHERE department_id = ?";
        try (Connection connection = JdbcUtil.getConnection()) {
            connection.setAutoCommit(false);
            try {
                // Xóa phòng ban có id = id1
                try (PreparedStatement pStmt = connection.prepareStatement(sql)) {
                    pStmt.setInt(1, id1);
                    pStmt.executeUpdate();
                }
                // Xóa phòng ban có id = id2
                try (PreparedStatement pStmt = connection.prepareStatement(sql)) {
                    if (true) {
                        // Giả lập xảy ra lỗi khi xóa id2
                        throw new RuntimeException();
                    }
                    pStmt.setInt(1, id2);
                    pStmt.executeUpdate();
                }
                connection.commit();
            } catch (Exception exception) {
                connection.rollback();
            } finally {
                connection.setAutoCommit(true);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void procedure(int id) {
        String sql = "CALL find_by_id(?)";
        try (
                Connection connection = JdbcUtil.getConnection();
                CallableStatement cStmt = connection.prepareCall(sql)
        ) {
            cStmt.setInt(1, id);
            try (ResultSet rs = cStmt.executeQuery()) {
                System.out.println("+----+--------------------+");
                System.out.println("| ID |        NAME        |");
                System.out.println("+----+--------------------+");
                while (rs.next()) {
                    // rs.getInt(2)
                    String name = rs.getString("department_name");

                    System.out.printf("| %-2d | %-18s |%n", id, name);
                    System.out.println("+----+--------------------+");
                }
            }
        } catch (SQLException exception) {
            System.err.println("Gọi thủ tục thất bại: " + exception.getMessage());
        }
    }

    public static void select() {
        String sql = "SELECT * FROM department";
        try (
                Connection connection = JdbcUtil.getConnection();
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(sql)
        ) {
            System.out.println("+----+--------------------+");
            System.out.println("| ID |        NAME        |");
            System.out.println("+----+--------------------+");
            while (rs.next()) {
                // rs.getInt(1)
                int id = rs.getInt("department_id");
                // rs.getInt(2)
                String name = rs.getString("department_name");

                System.out.printf("| %-2d | %-18s |%n", id, name);
                System.out.println("+----+--------------------+");
            }
        } catch (SQLException exception) {
            System.err.println("Truy vấn phòng ban thất bại: " + exception.getMessage());
        }
    }

    public static void update(int id, String newName) {
        String sql = "UPDATE department SET department_name = ? WHERE department_id = ?";
        try (
                Connection connection = JdbcUtil.getConnection();
                PreparedStatement pStmt = connection.prepareStatement(sql)
        ) {
            pStmt.setString(1, newName);
            pStmt.setInt(2, id);
            int result = pStmt.executeUpdate();
            System.out.println("Cập nhật thành công " + result + " phòng ban");
        } catch (SQLException exception) {
            System.err.println("Cập nhật phòng ban thất bại: " + exception.getMessage());
        }
    }

    public static void create(Department department) {
        String sql = "INSERT INTO department(department_name) VALUES (?)";
        try (
                Connection connection = JdbcUtil.getConnection();
                PreparedStatement pStmt = connection.prepareStatement(sql)
        ) {
            pStmt.setString(1, department.getName());
            int result = pStmt.executeUpdate();
            System.out.println("Tạo thành công " + result + " phòng ban");
        } catch (SQLException exception) {
            System.err.println("Tạo phòng ban thất bại: " + exception.getMessage());
        }
    }
}
