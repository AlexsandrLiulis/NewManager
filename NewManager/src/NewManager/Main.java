package NewManager;

public class Main {
    public static void main(String[] args) {
        LibraryManager manager = new LibraryManager();
        Helper helper = new Helper(manager);
        helper.start();
        manager.addThing(new Book("Толстой Л.Н.", "Декабристы"))
                .addThing(new Magnet("Belarus"))
                .addThing(new Magnet("Ukraine"))
                .addThing(new Book("Пушкин А.С.", "Руслан и Людмила"))
                .addThing(new Clothes(42, "штаны"))
                .addThing(new Clothes(56, "рубашка"));
        helper.chooseMenu();
    }
}
