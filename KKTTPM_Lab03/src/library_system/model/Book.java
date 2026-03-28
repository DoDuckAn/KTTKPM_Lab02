package library_system.model;

public class Book {
    private final String id;
    private final String title;
    private final String author;
    private boolean available;

    private Book(String id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.available = true;
    }

    public static Book create(String id, String title, String author) {
        return new Book(id, title, author);
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return id + " | " + title + " | " + author + " | " + (available ? "San sang" : "Dang muon");
    }
}