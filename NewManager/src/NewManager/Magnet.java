package NewManager;

public class Magnet  extends Thing{

    private String fromPlace;

    public Magnet(String fromPlace){
        super("Магнит");
        this.fromPlace = fromPlace;
    }

    @Override
    public String showMe(){
        String mess = ("Id номер " + super.getId() + ", " + super.getType() + ", место приобретения " + fromPlace);
        return mess;
    }
}
