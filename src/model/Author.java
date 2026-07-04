package model;

public class Author {
    private String name;
    private int id;

    @Override
    public String toString() {
        return "Author [id = " + id + ", name = " + name + " ]";
    }

    public Author(String name) {
        this.name = name;
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
}
// done properly 07/05/26