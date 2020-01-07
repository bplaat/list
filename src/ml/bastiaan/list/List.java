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
        // Because the muppet is going to be the last reset the muppets next value
        muppet.setNext(null);

        // If there is no start item set the start to the muppet
        if (start == null) {
            start = muppet;
        } else {
            // Else loop over all the muppets to get to the last muppet and set next to the muppet
            Muppet current = start;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(muppet);
        }

        // Increment the size of the list
        size++;
    }

    // A method to remove the last muppet on the list and return it
    public Muppet pop() {
        // Check if there is a first item and if the second item is null
        if (start != null && start.getNext() == null) {
            // When there is one pop it and set the start to the next Muppet, decrement the size and return
            Muppet first = start;
            start = first.getNext();
            size--;
            return first;
        } else {
            // Else loop trough all the muppets
            Muppet previous = start;
            while (previous != null) {
                // If we reach the second last item remove the last and set that last item to null
                Muppet current = previous.getNext();
                if (current != null && current.getNext() == null) {
                    previous.setNext(null);
                    size--;
                    return current;
                } else {
                    previous = previous.getNext();
                }
            }

            // If the list is empty return null
            return null;
        }
    }

    // A method to read a muppet from the list by a position
    public Muppet peek(int position) {
        // Loop trough all the muppets
        Muppet current = start;
        int current_position = 0;
        while (current != null) {
            // When the position is right return
            if (current_position == position) {
                return current.copy();
            }
            current = current.getNext();
            current_position++;
        }

        // When nothing found return null
        return null;
    }

    // A method to read a muppet from the list by muppet name
    public Muppet peek(String name) {
        // Loop trough all the muppets
        Muppet current = start;
        while (current != null) {
            // When the name is equal return
            if (current.getName().equals(name)) {
                return current.copy();
            }
            current = current.getNext();
        }

        // When nothing found return null
        return null;
    }

    // A method to get the list size
    public int size() {
        return size;
    }

    // A method that prints the whole list
    public void print() {
        // If there is no start item the list is empty and prints that
        if (start == null) {
            System.out.println("The list is empty");
        } else {
            // Loop trough all the muppets and print the information
            Muppet current = start;
            while (current != null) {
                System.out.print("- ");
                current.print();
                current = current.getNext();
            }
        }
    }
}
