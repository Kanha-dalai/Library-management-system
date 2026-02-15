import java.sql.*;
import java.util.*;

public class BookDAO {

    public void addBooks(List<Book> books) {

        String sql = "INSERT INTO books(title, author, quantity) VALUES(?,?,?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            for (Book book : books) {

                ps.setString(1, book.getTitle());
                ps.setString(2, book.getAuthor());
                ps.setInt(3, book.getQuantity());

                ps.addBatch();
            }

            ps.executeBatch();
            System.out.println("Books added successfully!");

        } catch (SQLException e) {
            System.out.println("Error adding books: " + e.getMessage());
        }
    }

    public void viewBooks() {

        String sql = "SELECT * FROM books";

        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                        rs.getString("title") + " | " +
                        rs.getString("author") + " | " +
                        rs.getInt("quantity")
                );
            }

        } catch (SQLException e) {
            System.out.println("Error viewing books.");
        }
    }
}
