package NewManager;

public class Magnet  extends Thing{

    private String fromPlace;

    public Magnet(String fromPlace){
        super("Магнит");
        this.fromPlace = fromPlace;
    }

    public String showMe(){
        String mess = ("Id номер " + super.getIsbn() + ", " + super.getType() + ", место приобретения " + fromPlace);
        return mess;
    }
}
