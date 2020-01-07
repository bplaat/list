// Made by Bastiaan van der Plaat (0983259) from TINPRO02-2

package ml.bastiaan.list;

// The main app class with all the tests
public class App {
    // The list classes used in the tests
    private LinkedList linkedList;
    private Stack stack;
    private Queue queue;

    // The app constructor
    public App() {
        linkedList = new LinkedList();
        stack = new Stack();
        queue = new Queue();
    }

    // A method the prints all the lists
    private void printLists() {
        System.out.println("Linked list:");
        linkedList.print();

        System.out.println("\nStack:");
        stack.print();

        System.out.println("\nQueue:");
        queue.print();
    }

    // A method that runs the linked list tests
    private void runLinkedListTests() {
        Muppet animal = new Muppet("Animal", 9);
        Muppet beaker = new Muppet("Beaker", 4);
        Muppet gonzo = new Muppet("Gonzo", 21);
        Muppet kermit = new Muppet("Kermit", 1);
        Muppet missPiggy = new Muppet("Miss Piggy", 16);
        Muppet swedishChef = new Muppet("Swedish Chef", 7);

        System.out.println("### LinkedList Test 1 ###");
        System.out.println(linkedList.pop(0));
        printLists();

        System.out.println("\n### LinkedList Test 2 ###");
        linkedList.push(animal);
        linkedList.push(beaker);
        linkedList.push(gonzo);
        linkedList.push(kermit, -1);
        linkedList.push(missPiggy, -1);
        linkedList.push(swedishChef, -1);
        printLists();

        // Good answer:
        // Linked List: Animal, Beaker, Gonzo, Kermit, Miss Piggy, Swedish Chef

        System.out.println("\n### LinkedList Test 3 ###");
        linkedList.push(linkedList.pop("Swedish Chef"), 0);
        printLists();

        // Good answer:
        // Linked List: Swedish Chef, Animal, Beaker, Gonzo, Kermit, Miss Piggy
    }

    // A method that runs the stack tests
    private void runStackTests() {
        System.out.println("\n### Stack Test 1 ###");
        System.out.println(stack.pop());
        printLists();

        System.out.println("\n### Stack Test 2 ###");
        stack.push(linkedList.pop("Kermit"));
        stack.push(linkedList.pop("Beaker"));
        stack.push(linkedList.pop("Swedish Chef"));
        printLists();

        // Good answer:
        // Linked List: Animal, Gonzo, Miss Piggy
        // Stack: Kermit, Beaker, Swedish Chef
    }

    // A method that runs the queue tests
    private void runQueueTests() {
        System.out.println("\n### Queue Test 1 ###");
        System.out.println(queue.pop());
        printLists();

        System.out.println("\n### Queue Test 2 ###");
        queue.push(linkedList.pop("Gonzo"));
        queue.push(linkedList.pop("Miss Piggy"));
        queue.push(linkedList.pop("Animal"));
        printLists();

        // Good answer:
        // Linked List: -
        // Stack: Kermit, Beaker, Swedish Chef
        // Queue: Gonzo, Miss Piggy, Animal

        System.out.println("\n### Queue Test 3 ###");
        linkedList.push(queue.pop(), 1);
        linkedList.push(queue.pop(), 1);
        linkedList.push(queue.pop(), 1);
        linkedList.push(stack.pop(), 1);
        linkedList.push(stack.pop(), 1);
        linkedList.push(stack.pop(), 1);
        printLists();

        // Good answer:
        // Linked List: Gonzo, Kermit, Beaker, Swedish Chef, Animal, Miss Piggy
        // Stack: -
        // Queue: -
    }

    // A method that runs all the tests
    private void runAllTests() {
        runLinkedListTests();
        runStackTests();
        runQueueTests();
    }

    // The main method which creates an App object and runs all the tests
    public static void main(String[] args) {
        App app = new App();
        app.runAllTests();
    }
}
