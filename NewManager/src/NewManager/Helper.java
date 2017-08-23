package NewManager;

import java.util.Scanner;

public class Helper {
    private Scanner scanner = new Scanner(System.in);
    private LibraryManager libraryManager;  // Присвоил ссылочной переменной libraryManager созданный экземпляр класса для использования в методах без передачи параметра.

    public Helper(LibraryManager libraryManager) {
        this.libraryManager = libraryManager;
    }

    public void start() {
        System.out.println("Выбирете что нужно сделать:");
        System.out.println("1 - для просмотра количества вещей на полке");
        System.out.println("2 - для просмотра всего содержимого");
        System.out.println("3 - для удаления всего содержимого");
        System.out.println("4 - для добавления вещей");
        System.out.println("5 - для удаления вещи");
        System.out.println("6 - для поиска вещи");
        System.out.println("7 - для просмотра ID номеров вещей"); // добавил просмотр Id номеров
        System.out.println("8 - для поиска по ID номеру вещи"); // добавил поиск по Id номеру
        System.out.println("0 - для выхода");
    }

    public int setScanner() {
        while (true) {
            if (scanner.hasNextInt()) {
                int x = scanner.nextInt();
                scanner.nextLine(); // После использования сканера очистил перевод строки
                if (x >= 0 && x < 9) {
                    int choose = x;
                    return choose;
                } else {
                    System.out.println("Введите число 1-8");
                }
            } else {
                String s = scanner.nextLine();
                System.out.println("Введите число");
            }
        }
    }

    public int setId() {
        while (true) {
            if (scanner.hasNextInt()) {
                int x = scanner.nextInt();
                scanner.nextLine();
                return x;

            } else {
                String s = scanner.nextLine();
                System.out.println("Введите число");
            }
        }
    }

    public String setAtrib() {
        String str = scanner.nextLine();
        return str;
    }

    //Удаление книг по номеру
    public int removeBookOfListNumber() {
        System.out.println("Введите номер вещи для удаления");
        while (true) {
            if (scanner.hasNextInt()) {
                int x = scanner.nextInt();
                if (x >= 1 && x < libraryManager.getLibrary().size() + 1) {
                    int number = x - 1;
                    return number;
                } else {
                    System.out.println("Введите число 1-" + libraryManager.getLibrary().size());
                }
            } else {
                String s = scanner.nextLine();
                System.out.println("Введите число");
            }
        }
    }

    public void writeBooks() {
        System.out.println("Введите Ф.И.О. писателя");
        String fio = setAtrib();
        System.out.println("Введите произведение");
        String title = setAtrib();
        libraryManager.addThing(new Book(fio, title));
        System.out.println("Книга добавлена");
    }

    public void finishMessage() {
        System.out.println("Для выхода - 0");
    }

    public Thing searchBook(String atribut) {
        String s = atribut;
        for (int i = 0; i < libraryManager.getLibrary().size(); i++) {
            Thing thing = libraryManager.getLibrary().get(i);
            if (s.getClass().equals(thing.getClass())) {
                System.out.println("Такая вещь найдена");
                Thing searh = thing;
                return searh;
            }
        }
        return null;
    }

    public void chooseMenu() {
        boolean finish = true;
        while (finish) {
            switch (setScanner()) {
                case 0:
                    System.out.println("выход");
                    finish = false;
                    break;
                case 1:
                    System.out.println("Колличество вещей " + libraryManager.getCountThings());
                    finishMessage();
                    break;
                case 2:
                    if (libraryManager.getCountThings() == 0) {
                        System.out.println("на полке нет вещей");
                    }
                    libraryManager.showAllLibrary();
                    finishMessage();
                    break;
                case 3:
                    libraryManager.removeAllBook();
                    System.out.println("Все вещи удалены");
                    finishMessage();
                    break;
                case 4:
                    writeBooks();
                    finishMessage();
                    break;
                case 5:
                    libraryManager.removeOfListNumber(removeBookOfListNumber());
                    System.out.println("Вещь удалена");
                    finishMessage();
                    break;
                case 6:
                    System.out.println("Введите название книги");
                    Thing search = searchBook(setAtrib());
                    if (search != null) {
                        System.out.println("Id номер " + search.getIsbn() + ": " + search.getClass());
                    } else {
                        System.out.println("Нет такой книги в библиотеке");
                    }
                    finishMessage();
                    break;
                case 7:
                    libraryManager.showAllIdBooks();
                    finishMessage();
                    break;
                case 8:
                    System.out.println("Введите Id номер вещи");
                    Thing thing = libraryManager.searchOfId(setId());
                    if (thing != null) {
                        System.out.println("Вещь с таким Id номером найдена");
                        System.out.println("Id номер " + thing.getIsbn() + ": " + thing.getClass());
                    } else {
                        System.out.println("Вещи с таким Id номером в библиотеке нет");
                        finishMessage();
                        break;
                    }
            }
        }
    }
}
