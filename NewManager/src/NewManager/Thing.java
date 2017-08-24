package NewManager;

public abstract class Thing {
    private String type;
    private int isbn;

    public Thing(){
    }

    public Thing(String type){
        this.type = type;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public int getIsbn() {
        return isbn;
    }

    public String getType() {
        return type;
    }

    public String showMe(){
        String mess = ("Id номер " + isbn + ", тип " + type);
        return mess;
    }

    public String showId(){
        String mess = ("Id номер " + isbn + ", тип " + type);
        return mess;
    }
}
