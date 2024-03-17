import java.util.ArrayList;
import java.util.List;

class Memento {
    private final String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}

class Originator {
    private String state;

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public Memento save() {
        return new Memento(state);
    }

    public void get(Memento memento) {
        state = memento.getState();
    }
}

class Caretaker {
    private final List<Memento> mementoList = new ArrayList<>();

    public void add(Memento state) {
        mementoList.add(state);
    }

    public Memento get(int index) {
        return mementoList.get(index);
    }

    public static void main(String[] args) {
        Originator originator = new Originator();
        Caretaker caretaker = new Caretaker();

        originator.setState("Жираф");
        caretaker.add(originator.save());
        originator.setState("Миша");
        caretaker.add(originator.save());

        originator.setState("Крокодил");
        caretaker.add(originator.save());

        originator.get(caretaker.get(0));
        System.out.println("Поточний стан: " + originator.getState());

        originator.get(caretaker.get(1));
        System.out.println("Поточний стан: " + originator.getState());

        originator.get(caretaker.get(0));
        System.out.println("Поточний стан: " + originator.getState());

        originator.get(caretaker.get(2));
        System.out.println("Поточний стан: " + originator.getState());
    }
}
