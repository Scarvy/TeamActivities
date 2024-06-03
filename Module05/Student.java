/** feel free to use this template as a starting point. */
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Student extends Person {
    private int id;

    public Student(String theName, int id) {
        super(theName);
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    //implementing .equals
    @Override
    public boolean equals(Object other) {
        if (this == other) { // short circuit: is "other" the same as "this"?
            return true;
        }
        // if (other.getClass() != Student.getClass()) { // another way to check if "other" object is a Student
        if (!(other instanceof Student)) {
            return false; // return false if "other" is not a Student object
        }
        Student otherStudent = (Student) other; // cast other to the correct type of object
        return (this.id == otherStudent.id); // determining equality: ID must be the same
        
    }

    // implementing .hash
    @Override
    public int hashCode() {
        return Objects.hash(name, id); //made changes to Person, private -> protected 
    }

    @Override
    public String toString() {
        return "StudentSolution{" + "name='" + this.getName() + '\'' + ", id=" + this.getId() + '}';
    }

    public static void main(String[] args) {
        int value = 10;
        Person e1 = new Student("Alice", 1);
        Person e2 = new Student("Bob", 2);
        Person e3 = new Student("Carol", 3);
        Person e5 = new Person("Alice");
        Person arrayOfPeople[] = {e1, e2, e3};

        Person e4 = new Student("Alice", 1); // same as e1?

        System.out.println(e1 == arrayOfPeople[0]); // what is printed here?
        System.out.println(e1 == e4); // what is printed here?

        System.out.println(e1.equals(e4)); // and here?
        System.out.println(e1.equals(e5)); // and here?

        Set<Person> streamPeople = new HashSet<>();

        Person p1 = new Person("Alice");
        Person p2 = new Student("Alice", 1);
        Person p3 = new Student("Alice", 2);

        streamPeople.add(p1);
        streamPeople.add(p2);
        streamPeople.add(p3);
        streamPeople.add(new Person("Bob"));
        streamPeople.add(new Person("Carol"));

        streamPeople.stream().filter(p -> p.getName().equals("Alice")).forEach(System.out::println);
    }
}
