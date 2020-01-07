// Made by Bastiaan van der Plaat (0983259) from TINPRO02-2

package ml.bastiaan.list;

// The abstract List core functionality class basicly a simple stack
public abstract class List {
    // The list size
    protected int size;

    // The first / start muppet
    protected Muppet start;

    // A simple constructor which sets some default nulls
    public List() {
        size = 0;
        start = null;
    }

    // A method to add a muppet to the end of the list
    public void push(Muppet muppet) {
        muppet.setNext(null);
        if (start == null) {
            start = muppet;
        } else {
            Muppet current = start;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(muppet);
        }
        size++;
    }

    // A method to remove the last muppet on the list and return it
    public Muppet pop() {
        if (start != null && start.getNext() == null) {
            Muppet first = start;
            start = first.getNext();
            size--;
            return first;
        } else {
            Muppet previous = start;
            while (previous != null) {
                Muppet current = previous.getNext();
                if (current != null && current.getNext() == null) {
                    previous.setNext(null);
                    size--;
                    return current;
                } else {
                    previous = previous.getNext();
                }
            }
            return null;
        }
    }

    // A method to read a muppet from the list by a position
    public Muppet peek(int position) {
        Muppet current = start;
        int current_position = 0;
        while (current != null) {
            if (current_position == position) {
                return current;
            }
            current = current.getNext();
            current_position++;
        }
        return null;
    }

    // A method to read a muppet from the list by muppet name
    public Muppet peek(String name) {
        Muppet current = start;
        while (current != null) {
            if (current.getName().equals(name)) {
                return current;
            }
            current = current.getNext();
        }
        return null;
    }

    // A method to get the list size
    public int size() {
        return size;
    }

    // A method that prints the whole list
    public void print() {
        if (start == null) {
            System.out.println("The list is empty");
        } else {
            Muppet current = start;
            while (current != null) {
                System.out.print("- ");
                current.print();
                current = current.getNext();
            }
        }
    }
}
