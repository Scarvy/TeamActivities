import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapPractice {

    public static void main(String[] args) {
        Map<String, Double> map = new HashMap<>();

        map.put("Apple", 3.5);
        map.put("Banana", 2.0);
        map.put("Cherry", 4.0);

        System.out.println(map); // print out map

        // what happens if we add a duplicate key?
        // your code here
        map.put("Apple", 1.99);
        map.putIfAbsent("Cherry", 10.0);

        System.out.println(map); // print out map


        // Streams with maps practice
        Map<String, Double> food = new HashMap<>();

        food.put("Apple", 3.5);
        food.put("Banana", 2.0);
        food.put("Cherry", 4.0);


        food.entrySet().stream().map(x -> x.getKey() + " costs " + x.getValue())
            .forEach(System.out::println);
        System.out.println("Food that costs more than 3.0");
        food.entrySet().stream().filter(x -> x.getValue() > 3.0)
                .map(x -> x.getKey() + " costs " + x.getValue())
                .forEach(System.out::println);

        // With loops
        System.out.println("For each loop example");
        for(Map.Entry<String, Double> entry : food.entrySet()) {
            System.out.println(entry.getKey() + " costs " + entry.getValue());
        }
        
        // or
        
        System.out.println("For each loop example");
        for(String key : food.keySet()) {
            System.out.println(key + " costs " + food.get(key));
        }


        // now try it with Person/Student. We will
        // use the person or student as a key and the
        // value will be a set of classes they are taking

        Map<Person, Set<String>> classes = new HashMap<>();

        // create Person objects
        Person p5 = new Person("Abby");
        Person p6 = new Student("Jenny", 302);
        Person p7 = new Student("Maricarmen", 102);
        Person p8 = new Student("Scott", 901);
        Person p9 = new Student("Tracy", 892);

        // add to 'classes' HashMap
        classes.put(p5, Set.of("CS5001", "CS5002"));
        classes.put(p6, Set.of("CS5001"));
        classes.put(p7, Set.of("CS5002", "CS5008"));
        classes.put(p8, Set.of("CS5001", "CS5008"));
        classes.put(p9, Set.of("CS5008"));

        System.out.println(classes); // display HashMap

        classes.put(p7, Set.of("CS5004", "CS5002")); // add duplicated key of p7, with different value
        // classes.put(p7, Set.of("CS5004", "CS5002", "CS5800")); // one way of extending

        System.out.println(classes.get(p7));

        // classes.put(p7, classes.get(p7).add("CS5800"));
        
        System.out.println(classes); // check changes

    }

}
