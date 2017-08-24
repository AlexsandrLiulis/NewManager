package NewManager;

public class Main {
    public static void main(String[] args) {
        LibraryManager manager = new LibraryManager();
        Helper helper = new Helper(manager); // Создаю экземпляр класса Helper и передаю переменную ссылку manager для использования в классе Helper
        helper.start();
        // использую подход chein для создания экземпляров класса Book
        manager.addThing(new Book("Толстой Л.Н.", "Декабристы"))
                .addThing(new Magnet("Belarus"))
                .addThing(new Magnet("Ukraine"))
                .addThing(new Book("Пушкин А.С.", "Руслан и Людмила"))
                .addThing(new Clothes(42, "штаны"));

        helper.chooseMenu();
    }


}
