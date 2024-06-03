import java.util.HashSet;
import java.util.Set;


// Practice using sets in Java


public class SetPractice {


    public static void main(String[] args) {
        // EXAMPLE: HASH SET with String objects
        Set<String> set = new HashSet<>();

        set.add("alice");
        set.add("bob");
        set.add("carol");
        set.add("");
        set.add("Tracy");

        System.out.println(set);

        set.add("Alice"); // what will happen?

        System.out.println(set.contains("Alice"));

        // EXAMPLE: HASH SET with Person objects
        // TODO: add Set<Person>, and see
        // how it behaves with both students and person.
        // Make sure to have a duplicate student or person

        Set<Person> setPerson = new HashSet<>();

        Person p1 = new Person("Alice"); //added
        Person p2 = new Student("Alice", 1); //added
        Person p3 = new Student("Alice", 2); //added
        Person p4 = new Student("Alice", 1); // same as p2? NOT added, duplicate 

        setPerson.add(p1);
        setPerson.add(p2);
        setPerson.add(p3);
        setPerson.add(p4);

        System.out.println(setPerson); // print out 'setPerson' set
    }

}
