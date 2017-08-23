package NewManager;

import java.util.ArrayList;

public class LibraryManager {
    private int countThings; // убрал статическую переменную
    private int thingId = 0; //  присвоение уникального id номера для каждой созданной вещи

    ArrayList<Thing> library = new ArrayList<>();

    public LibraryManager addThing(Thing thing) {
        this.library.add(thing);
        this.countThings++;
        thing.setIsbn(++thingId);
        return this; // Вернул ссылку на экзэмпляр текущего класса для использования chein при добавлении книги
    }

    // Поиск книги по номеру в списке
    public void removeAllBook() {
        for (int i = 0; i < countThings; ) {
            library.remove(i);
            countThings--;
        }
    }

    public ArrayList<Thing> getLibrary() {
        return library;
    }

    public void removeOfListNumber(int number) {
        library.remove(library.get(number));
        countThings--;
    }

    // Переделал вывод библиотеки по списку
    public void showAllLibrary() {
        for (int i = 0; i < library.size(); i++) {
            Thing thing = library.get(i);
            System.out.println(i + 1 + " " + thing.getType());
        }
    }

    // Вывод всех Id номеров книг
    public void showAllIdBooks() {
        for (int i = 0; i < library.size(); i++) {
           Thing thing = library.get(i);
            System.out.println("Id номер " + thing.getIsbn() + ": " + thing.getType());
        }
    }

    public Thing searchOfId(int id) {
        for (Thing thing : library) {
            if (thing.getIsbn() == id) {
                return thing;
            }
        }
        return null;
    }

    public int getCountThings() {
        return countThings;
    }
}
