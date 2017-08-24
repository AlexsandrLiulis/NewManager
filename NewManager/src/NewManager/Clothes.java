package NewManager;

public class Clothes extends Thing {
    private int size;
    private String clothesType;

    public Clothes(int size, String clothesType) {
        super("Одежда");
        this.size = size;
        this.clothesType = clothesType;
    }

    @Override
    public String showMe() {
        String mess = ("Id номер " + super.getId() + ", " + super.getType() + ", " + clothesType + ", размер " + size);
        return mess;
    }
}
