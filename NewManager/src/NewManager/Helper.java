package NewManager;

import java.util.Scanner;

public class Helper {
    private Scanner scanner = new Scanner(System.in);
    private LibraryManager libraryManager;

    public Helper(LibraryManager libraryManager) {
        this.libraryManager = libraryManager;
    }

    public void start() {
        System.out.println("Выбирете что нужно сделать:");
        System.out.println("1 - для просмотра количества вещей на полке");
        System.out.println("2 - для просмотра всего содержимого полки");
        System.out.println("3 - для удаления всего содержимого полки");
        System.out.println("4 - для добавления вещей на полку");
        System.out.println("5 - для удаления вещи");
        System.out.println("6 - для поиска вещи");
        System.out.println("7 - для просмотра ID номеров вещей");
        System.out.println("8 - для поиска по ID номеру вещи");
        System.out.println("9 - для удаления по ID номеру вещи");
        System.out.println("0 - для выхода");
    }

    public int setScanner() {
        while (true) {
            if (scanner.hasNextInt()) {
                int x = scanner.nextInt();
                scanner.nextLine();
                if (x >= 0 && x < 10) {
                    int choose = x;
                    return choose;
                } else {
                    System.out.println("Введите число 1-9");
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

    public String setSearchThind() {
        String str = scanner.nextLine();
        return str;
    }

    public int removeThingOfListNumber() {
        System.out.println("Введите номер вещи для удаления");
        while (true) {
            if (scanner.hasNextInt()) {
                int x = scanner.nextInt();
                if (x >= 1 && x <= libraryManager.getLibrary().size()) {
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

    public void addThing() {
        System.out.println("Введите тип добавляемой вещи");
        String type = setSearchThind();
        if (type.toUpperCase().equals("КНИГА")){
            System.out.println("Введите Ф.И.О. писателя");
            String fio = setSearchThind();
            System.out.println("Введите произведение");
            String title = setSearchThind();
            libraryManager.addThing(new Book(fio, title));
            System.out.println("Книга добавлена");
        }else {if (type.toUpperCase().equals("МАГНИТ")){
            System.out.println("Введите место приобретения");
            String place = setSearchThind();
            libraryManager.addThing(new Magnet(place));
            System.out.println("Магнит добавлен");
        }else {
            if (type.toUpperCase().equals("ОДЕЖДА")){
                System.out.println("Введите тип одежды");
                String clothesType = setSearchThind();
                System.out.println("Введите размер одежды");
                int size = Integer.parseInt(setSearchThind());
                libraryManager.addThing(new Clothes(size, clothesType));
                System.out.println("Одежда добавлена");
            }else {
                System.out.println("Неизвестный тип");
            }

        }

        }


    }

    public void finishMessage() {
        System.out.println("Для выхода - 0");
    }

    public Thing searchThing(String searchThing) {
        String s = searchThing;
        for (int i = 0; i < libraryManager.getLibrary().size(); i++) {
            String str = libraryManager.getLibrary().get(i).getType();
            if (s.toUpperCase().equals(str.toUpperCase())) {
                System.out.println("Такая вещь найдена");
                Thing searh = libraryManager.getLibrary().get(i);
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
                    libraryManager.showAllThings();
                    finishMessage();
                    break;
                case 3:
                    libraryManager.removeAllThings();
                    System.out.println("Все вещи удалены");
                    finishMessage();
                    break;
                case 4:
                    addThing();
                    finishMessage();
                    break;
                case 5:
                    libraryManager.removeOfListNumber(removeThingOfListNumber());
                    System.out.println("Вещь удалена");
                    finishMessage();
                    break;
                case 6:
                    System.out.println("Введите тип вещи для поиска");
                    Thing search = searchThing(setSearchThind());
                    if (search != null) {
                        for (Thing thing:libraryManager.getLibrary()) {
                            if (thing.getType().equals(search.getType())){
                                System.out.println(thing.showMe());
                            }
                        }
                    } else {
                        System.out.println("Вещи с таким типом не найдено");
                    }
                    finishMessage();
                    break;
                case 7:
                    libraryManager.showAllIdThings();
                    finishMessage();
                    break;
                case 8:
                    System.out.println("Введите Id номер вещи");
                    Thing thing = libraryManager.searchOfId(setId());
                    if (thing != null) {
                        System.out.println("Вещь с таким Id номером найдена");
                        System.out.println(thing.showMe());
                    } else {
                        System.out.println("Вещи с таким Id номером не найдено");
                        finishMessage();
                        break;
                    }
                case 9:
                    System.out.println("Введите Id номер удаляемой вещи");
                    if (libraryManager.removeOfId(setId()) == 1) {
                        System.out.println("Вещь с таким Id номером удалена");
                    } else {
                        System.out.println("Вещи с таким Id номером не найдено");
                        finishMessage();
                        break;
                    }
            }
        }
    }
}
