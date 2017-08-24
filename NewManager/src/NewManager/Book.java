package NewManager;

public class Book extends Thing{
    private String author;
    private String title;

    public Book(String author, String title) {
        super("Книга");
        this.author = author;
        this.title = title;
    }

    @Override
    public String showMe(){
        String mess = ("Id номер " + super.getId() + ", " + super.getType() + ", " + author + " - " + title);
        return mess;
    }
}


