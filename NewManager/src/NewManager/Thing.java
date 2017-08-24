package NewManager;

public abstract class Thing {
    private String type;
    private int id;

    public Thing() {
    }

    public Thing(String type) {
        this.type = type;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String showId() {
        String mess = ("Id номер " + id + ", тип " + type);
        return mess;
    }

    public String showMe() {
        String mess = ("Id номер " + id + ", тип " + type);
        return mess;
    }

    @Override
    public String toString() {
        return type;
    }
}
