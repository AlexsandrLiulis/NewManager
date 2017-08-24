package NewManager;

import java.util.ArrayList;

public class LibraryManager {
    private int countThings;
    private int thingId = 0;

    ArrayList<Thing> library = new ArrayList<>();

    public LibraryManager addThing(Thing thing) {
        this.library.add(thing);
        this.countThings++;
        thing.setId(++thingId);
        return this;
    }

    public void removeAllThings() {
        for (int i = 0; i < countThings; ) {
            library.remove(i);
            countThings--;
        }
    }

    public void removeOfListNumber(int number) {
        library.remove(library.get(number));
        countThings--;
    }

    public void showAllThings() {
        for (int i = 0; i < library.size(); i++) {
            Thing thing = library.get(i);
            System.out.println(i + 1 + " " + thing.showMe());
        }
    }

    public void showAllIdThings() {
        for (int i = 0; i < library.size(); i++) {
            Thing thing = library.get(i);
            System.out.println(thing.showId());
        }
    }

    public Thing searchOfId(int id) {
        for (Thing thing : library) {
            if (thing.getId() == id) {
                return thing;
            }
        }
        return null;
    }

    public int removeOfId(int id) {
        for (Thing thing : library) {
            if (thing.getId() == id) {
                library.remove(thing);
                return 1;
            }
        }
        return 0;
    }

    public ArrayList<Thing> getLibrary() {
        return library;
    }

    public int getCountThings() {
        return countThings;
    }
}
