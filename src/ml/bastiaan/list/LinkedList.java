// Made by Bastiaan van der Plaat (0983259) uit TINPRO02-2

package ml.bastiaan.list;

// The linked list class inherents most off the functionality from the List class
public class LinkedList extends List {
    // A method to add a muppet on the list at a certain position
    public void push(Muppet muppet, int position) {
        // If the list is empty set start to the muppet
        if (start == null) {
            muppet.setNext(null);
            start = muppet;
        } else {
            // When the position is zero set start to the muppet
            if (position == 0) {
                muppet.setNext(start);
                start = muppet;
            } else {
                // Else loop trough the items to the right position of when on the end of the list
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
        // When there is a first item and we want it remove and return it
        if (start != null && position == 0) {
            Muppet first = start;
            start = first.getNext();
            size--;
            return first;
        } else {
            // Else loop torugh all items and whene the position is good return the item
            Muppet previous = start;
            int previous_position = 0;
            while (previous != null) {
                if (previous_position + 1 == position) {
                    Muppet current = previous.getNext();
                    previous.setNext(current.getNext());
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
        // Check if there is a first item and the name is the same
        if (start != null && start.getName().equals(name)) {
            // Set the first item to the next and return
            Muppet first = start;
            start = first.getNext();
            size--;
            return first;
        } else {
            // Loop trough all muppets
            Muppet previous = start;
            while (previous != null) {
                Muppet current = previous.getNext();
                // When the name is the same return the muppet
                if (current != null && current.getName().equals(name)) {
                    previous.setNext(current.getNext());
                    size--;
                    return current;
                }
                previous = previous.getNext();
            }
            return null;
        }
    }
}
