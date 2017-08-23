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
}
