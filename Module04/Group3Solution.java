import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Group3Solution {
    // Old Solution Method using a loop
    // public static List<Integer> getEvens(List<Integer> numbers) {
    //     List<Integer> evens = new ArrayList<>();
    //     for(int i = 0; i < numbers.size(); i++){
    //         if(numbers.get(i) % 2 == 0){
    //             evens.add(numbers.get(i));
    //         }
    //     }
    //     return evens;
    // }

    /*
    TASK: MAP
    This method takes in a list of Integers and returns a list of its computed squares
    @param numbers list of numbers
    @return squares list containing squared numbers
    */
    public static List<Integer> squareList(List<Integer> numbers) {
        List<Integer> squares = new ArrayList<>();

        for (int number : numbers) { // Apply square function to each element using map
            int square = number * number;
            squares.add(square); // add to 'squares' list
        }

        return squares;
        }

    /* 
    @param a list of integers
    @return a sum of integers
    */ 
    // @Scarvy
    // public static Integer sumIntegers(List<Integer> numbers) {
    //     Integer sum = 0;
    //     for (int number : numbers) {
    //         sum += number;
    //     }
    //     return sum;
    // }

    public static List<Book> stringToBook(List<String> listOfBookStrings) {
        List<Book> bookList = new ArrayList<>();
        for (String bookString : listOfBookStrings) {
            bookList.add(Book.createFromString(bookString));
        }
        return bookList;
    }

    public static void main(String[] args) {
        // Old Solution: to filter list of numbers, for loop to go 
        // through list, then add the nums that met the criteria to the new list         

        // List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10); // this function is a quick way to build a list
        // List<Integer> evens = getEvens(numbers);
        // System.out.println(evens);

        // New Solution using streams
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10); // this function is a quick way to build a list
        List<Integer> evens2 = numbers.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
        System.out.println(evens2);

        // Reduce / Sum
        // List<Integer> numbers2 = Arrays.asList(1,2,3,4,5);
        // Integer sum = numbers2.stream().sum(); // or reduce(0, ()
        // System.out.println(sum);

        // Integer sum_with_method = sumIntegers(numbers2);
        // System.out.println(sum_with_method);

        // map examples using stream
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> squared = integers.stream().map(n -> n * n).collect(Collectors.toList());
        System.out.println(squared);

        // Book map example
        List<String> bookStrings = Arrays.asList("The Great Gatsby,F. Scott Fitzgerald,1925",
                "To Kill a Mockingbird,Harper Lee,1960",
                "1984,George Orwell,1949",
                "The Catcher in the Rye,J.D. Salinger,1951",
                "Beloved,Toni Morrison,1987");
        List<Book> books = stringToBook(bookStrings);
        for (Book book : books) {
            System.out.println(book.toString());
        }
    }
}
