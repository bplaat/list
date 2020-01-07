// Made by Bastiaan van der Plaat (0983259) from TINPRO02-2

package ml.bastiaan.list;

// The Muppet data class
public class Muppet {
    // The muppets name
    private String name;

    // The muppets age
    private int age;

    // The next muppet
    private Muppet next;

    // A muppet constructor with only a name
    public Muppet(String name) {
        this.name = name;
        age = 0;
        next = null;
    }

    // A muppet constructor for a name and a age
    public Muppet(String name, int age) {
        this.name = name;
        this.age = age;
        next = null;
    }

    // A method to get the muppets name
    public String getName() {
        return name;
    }

    // A method to set the muppets name
    public void setName(String name) {
        this.name = name;
    }

    // A method to get the muppets age
    public int getAge() {
        return age;
    }

    // A method to set the muppets name
    public void setAge(int age) {
        this.age = age;
    }

    // A method to get the next muppet
    public Muppet getNext() {
        return next;
    }

    // A method to set the next muppet
    public void setNext(Muppet next) {
        this.next = next;
    }

    // A method to print the muppets information
    public void print() {
        System.out.println("Muppet name: " + name + " and age: " + age);
    }
}
