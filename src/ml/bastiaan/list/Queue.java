// Made by Bastiaan van der Plaat (0983259) from TINPRO02-2

package ml.bastiaan.list;

// The queue class inherents most off the functionality from the List class
public class Queue extends List {
    // We overide the pop method to be l.i.f.o instead of the standard f.i.f.o method
    @Override
    public Muppet pop() {
        // Check if there is a first Muppet
        if (start != null) {
            // When there is one pop it and set the start to the next Muppet, decrement the size and return
            Muppet first = start;
            start = first.getNext();
            size--;
            return first;
        }

        return null;
    }
}
