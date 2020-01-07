// Made by Bastiaan van der Plaat (0983259) uit TINPRO02-2

package ml.bastiaan.list;

// The linked list class inherents most off the functionality from the List class
public class LinkedList extends List {
    // A method to add a muppet on the list at a certain position
    public void push(Muppet muppet, int position) {
        if (start == null) {
            muppet.setNext(null);
            start = muppet;
        } else {
            if (position == 0) {
                muppet.setNext(start);
                start = muppet;
            } else {
                Muppet current = start;
                for (int i = 0; i != position - 1 && current.getNext() != null; i++) {
                    current = current.getNext();
                }
                muppet.setNext(current.getNext());
                current.setNext(muppet);
            }
        }
        size++;
    }

    // A method to remove a muppet on the list at a certain position and return it
    public Muppet pop(int position) {
        if (start != null && position == 0) {
            Muppet first = start;
            start = first.getNext();
            size--;
            return first;
        } else {
            Muppet previous = start;
            int previous_position = 0;
            while (previous != null) {
                if (previous_position + 1 == position) {
                    Muppet current = previous.getNext();
                    Muppet next = current.getNext();
                    previous.setNext(next);
                    size--;
                    return current;
                }
                previous = previous.getNext();
                previous_position++;
            }
            return null;
        }
    }

    // A method to remove a muppet on the list at with certain name and return it
    public Muppet pop(String name) {
        if (start != null && start.getName().equals(name)) {
            Muppet first = start;
            start = first.getNext();
            size--;
            return first;
        } else {
            Muppet previous = start;
            while (previous != null) {
                Muppet current = previous.getNext();
                if (current != null && current.getName().equals(name)) {
                    Muppet next = current.getNext();
                    previous.setNext(next);
                    size--;
                    return current;
                }
                previous = previous.getNext();
            }
            return null;
        }
    }
}
