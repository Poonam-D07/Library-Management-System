package services;

import java.util.Scanner;

import dao.AuthorDao;
import dao.BookDao;
import model.Author;
import model.Book;
import utils.ScannerUtil;

public class BookServices {
    private BookDao bookDao;

    public BookServices(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public void getBookByNameService(String bookName) {
        Book retrived = bookDao.getBookByName(bookName);
        System.out.println("Book in library " + retrived);
    }

    public void deleteBookByName(String bookName) {

        Scanner sc = ScannerUtil.getScanner();
        System.out.println("Enter book name ");
        bookName = sc.nextLine();
        if (bookName.length() == 0) {
            return;
        }
        bookDao.deleteBookByName(bookName);
    }

    public void getAllBookService() {

    }

    public void addBookService() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter book name : ");
        String name = sc.nextLine();

        System.out.println("Enter book edition : ");
        String edition = sc.nextLine();

        System.out.println("Enter book price : ");
        double price = sc.nextDouble();
        sc.nextLine();

        System.out.println("Enter book author name : ");
        String authorName = sc.nextLine();
        Author author = AuthorDao.getAuthorByName(authorName);

        Book newBook = new Book(name, edition, price, author);
        bookDao.addBook(newBook);
    }

    public void updateBookService() {
        String bookPrice, bookEdition;
        double booPrice;
    }

    public void allBookServices() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'allBookServices'");
    }
}