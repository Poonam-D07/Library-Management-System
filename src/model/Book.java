package model;

public class Book {
    private int id;
    private String name;
    private double price;
    private String edition;

    private Author author;

    @Override
    public String toString() {
        return "Book [id = " + id + ",name = " + name + ", edition = " + edition + ",price = " + price + " , author = "
                + author + " ]";
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Book(String name, String edition, int id, double price, Author author) {
        this.name = name;
        this.edition = edition;
        this.price = price;
        this.author = author;
    }

    public Book(String name2, String edition, double price, Author author2) {
        // TODO Auto-generated constructor stub
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

}