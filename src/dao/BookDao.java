package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Author;
import model.Book;
import utils.DbConnection;

public class BookDao {
    public void addBook(Book bookObject) {

        try {
            Connection con = DbConnection.getConnection();

            String insertQuery = "INSERT INTO book_tb (name, edition, price, author_id)VALUES (?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(insertQuery);

            ps.setString(1, bookObject.getName());
            ps.setString(2, bookObject.getEdition());
            ps.setDouble(3, bookObject.getPrice());
            ps.setInt(4, bookObject.getAuthor().getId());

            int rowUpdate = ps.executeUpdate();
            System.out.println("Row updated !" + rowUpdate);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Book getBookByName(String bookName) {
        String sql = "SELECT * FROM book_tb WHERE (name) = (?)";
        Book retriveBook = null;
        String bookNameRetrived = null;
        String bookEditionRetrived = null;
        double bookPriceRetrived = 0.0;
        Author authorRetrived = null;

        try (Connection connection = DbConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, bookName);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                bookNameRetrived = rs.getString("name");
                bookEditionRetrived = rs.getString("edition");

                bookPriceRetrived = rs.getDouble("price");
                authorRetrived = (Author) rs.getObject("author");
            }

            retriveBook = new Book(bookNameRetrived, bookEditionRetrived, bookPriceRetrived, authorRetrived);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return retriveBook;
    }

    public void deleteBookByName(String bookName) {
        String delQuery = "delete from book_tb where name = ?";
        try (Connection connection = DbConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(delQuery);) {

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getAllBook() {
        String query = "select * from book_tb";
        try (
                Connection connection = DbConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println("bookName : " + rs.getString("name") + "bookPrice " + rs.getDouble("price")
                        + "bookEdition" + rs.getSQLXML("query"));
                // remaining code for write
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateBookByEditionAndPrice(String bookName, String bookEdition, double price) {
        String query = "update book_tb set (edition = ?, price = ?)where = name";
    }// remaining for writing code

    public void testMethod(Connection con) {
        String query = "SELECT * FROM book_tb";
        try (Statement st = con.createStatement()) {

            System.out.println("Succesful Connected...");

            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                System.out.println(rs.getString("name") + " " + rs.getInt("price"));
            }

        } catch (Exception e) {
            System.out.println("Failed Connected...");
            e.printStackTrace();

        }
    }
}