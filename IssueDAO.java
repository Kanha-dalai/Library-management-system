import java.sql.*;

public class IssueDAO {

    public void issueBook(int bookId) {

        String checkSql = "SELECT quantity FROM books WHERE id=?";
        String updateSql = "UPDATE books SET quantity = quantity - 1 WHERE id=?";
        String insertSql = "INSERT INTO issue(book_id, issue_date) VALUES(?, CURDATE())";

        try (Connection con = DBConnection.getConnection()) {

            con.setAutoCommit(false);

            try (PreparedStatement checkPs = con.prepareStatement(checkSql);
                 PreparedStatement updatePs = con.prepareStatement(updateSql);
                 PreparedStatement insertPs = con.prepareStatement(insertSql)) {

                checkPs.setInt(1, bookId);
                ResultSet rs = checkPs.executeQuery();

                if (rs.next() && rs.getInt("quantity") > 0) {

                    updatePs.setInt(1, bookId);
                    updatePs.executeUpdate();

                    insertPs.setInt(1, bookId);
                    insertPs.executeUpdate();

                    con.commit();
                    System.out.println("Book issued successfully!");

                } else {
                    System.out.println("Book not available.");
                }

            } catch (SQLException e) {
                con.rollback();
                System.out.println("Issue failed. Rolled back.");
            }

        } catch (SQLException e) {
            System.out.println("Database error.");
        }
    }

    public void returnBook(int issueId) {

        String getSql = "SELECT book_id FROM issue WHERE issue_id=?";
        String updateBookSql = "UPDATE books SET quantity = quantity + 1 WHERE id=?";
        String returnSql = "UPDATE issue SET return_date = CURDATE() WHERE issue_id=?";

        try (Connection con = DBConnection.getConnection()) {

            con.setAutoCommit(false);

            try (PreparedStatement getPs = con.prepareStatement(getSql);
                 PreparedStatement updatePs = con.prepareStatement(updateBookSql);
                 PreparedStatement returnPs = con.prepareStatement(returnSql)) {

                getPs.setInt(1, issueId);
                ResultSet rs = getPs.executeQuery();

                if (rs.next()) {

                    int bookId = rs.getInt("book_id");

                    updatePs.setInt(1, bookId);
                    updatePs.executeUpdate();

                    returnPs.setInt(1, issueId);
                    returnPs.executeUpdate();

                    con.commit();
                    System.out.println("Book returned successfully!");

                } else {
                    System.out.println("Invalid issue ID.");
                }

            } catch (SQLException e) {
                con.rollback();
                System.out.println("Return failed. Rolled back.");
            }

        } catch (SQLException e) {
            System.out.println("Database error.");
        }
    }
}