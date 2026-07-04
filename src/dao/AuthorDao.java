package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Author;
import utils.DbConnection;

public class AuthorDao {

    public void updateAuthor(String prevName, String updateName) {
        String updateQuery = "update from author_tb where name = (?) set name = (?)";

        try (
                Connection connection = DbConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(updateQuery);) {
            ps.setString(1, prevName);
            ps.setString(2, updateName);

            int rowUpdate = ps.executeUpdate();
            System.out.println("Row update " + rowUpdate);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getAllAuthor() {
        try (
                Connection con = DbConnection.getConnection();
                Statement st = con.createStatement();) {
            String query = "select name from author_tb";

            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                System.out.println(rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addAuthor(Connection connection, String author_name) {
        String sql = "insert into author_tb(name) values(?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, author_name);
            int row = preparedStatement.executeUpdate();

            System.out.println("Row updated" + row);

        } catch (Exception e) {
            System.out.println("Exception occured in addAuthor Block");
            e.printStackTrace();
        }
    }

    public static Author getAuthorByName(String authorName) {
        String sql = "SELECT * FROM author_tb WHERE (name) = (?)";

        Author retriveAuthor = null;
        String nameRetrived = null;

        try (
                Connection connection = DbConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, authorName);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                nameRetrived = resultSet.getString("name");
                System.out.println(nameRetrived);
            }

            retriveAuthor = new Author(nameRetrived);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return retriveAuthor;

    }

    public void delAuthor(String authorName) {
        String query = "delete from author_tb where (name) = (?)";

        try (Connection con = DbConnection.getConnection();
                PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setString(1, authorName);
            int rowUpdate = preparedStatement.executeUpdate();
            System.out.println("row updated" + rowUpdate);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
