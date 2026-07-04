package controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import dao.AuthorDao;
import dao.BookDao;
import model.Author;
import model.Book;
import services.BookServices;
import utils.DbConnection;

public class Main {
    public static void main(String[] args) {
        BookDao dao = new BookDao();
        BookServices bookServices = new BookServices(dao);
        // AuthorDao authorDao = new AuthorDao();
        // String URL = "jdbc:mysql://localhost:3306/library_db";
        // String USERNAME = "root";
        // String PassWord = "root";

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("Library Management Project ---------------------- ");
            System.out.println("1:Add author\n 2: Add Book \n 3: Exit Program ");

            int choice;
            choice = sc.nextInt();

            if (choice == 3)
                break;
            sc.nextLine();

            switch (choice) {

                case 1:
                    while (true) {
                        System.out.println(
                                "a-- Add author \nb-- Delete author\nc-- Update Author\nd--All author\ne--exist\n  ");
                        char options = sc.nextLine().charAt(0);

                        if (options == 'e') {
                            break;
                        }
                        authorCrud(options);
                    }
                    break;
                case 2:

                    System.out.println(
                            "1- Add Book \n 2- Delete Book \n 3- Update Book \n 4- All Book \n 5- PreviousMenu\n");
                    int options;
                    options = sc.nextInt();
                    switch (options) {
                        case 1:
                            bookServices.addBookService();
                            break;
                        case 2:
                            bookServices.deleteBookByName(null);
                            break;

                        case 3:
                            bookServices.updateBookService();
                            break;

                        case 4:
                            bookServices.allBookServices();
                            break;

                        case 5:
                            break;
                        default:
                            System.out.println("Invalid input");
                            break;
                    }

                    break;
                default:
                    System.out.println("galat input");
                    break;
            }

        }
    }

    public static Book bookInput() throws SQLException {
        Connection connection = DbConnection.getConnection();

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter book name ");
        String name = sc.nextLine();

        System.out.println("Enter book edition ");
        String edition = sc.nextLine();

        System.out.println("Enter book id ");
        int id = sc.nextInt();

        System.out.println("Enter book price ");
        double price = sc.nextDouble();
        sc.nextLine();

        System.out.println("Enter book author name ");
        String authorName = sc.nextLine();
        Author author = AuthorDao.getAuthorByName(authorName);

        Book newBook = new Book(name, edition, id, price, author);

        return newBook;

    }

    public static void authorCrud(char options) {
        AuthorDao authorDao = new AuthorDao();
        Scanner sc = new Scanner(System.in);
        switch (options) {
            case 'a':
                String input1;
                System.out.println("Enter author name !");
                input1 = sc.nextLine();

                try (Connection con = DbConnection.getConnection();) {
                    authorDao.addAuthor(con, input1);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;

            case 'b':
                String nameEntered;
                System.out.println("Enter author name to delete");
                nameEntered = sc.nextLine();
                authorDao.delAuthor(nameEntered);
                break;
            case 'c':
                System.out.println("Enter author Name You want to update");
                String prevName = sc.nextLine();

                System.out.println("Enter updated Name ");
                String updatedName = sc.nextLine();

                authorDao.updateAuthor(prevName, updatedName);
                break;
            case 'd':
                authorDao.getAllAuthor();
                break;
            case 'e':
                System.out.println(0);
            default:
                System.out.println("Invalid input!");
                break;
        }

    }
}
