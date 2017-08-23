package NewManager;

public class Book extends Thing{
    private String author;
    private String title;

    public Book(String author, String title) {
        super("Книга");
        this.author = author;
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }
}


