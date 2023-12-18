import java.util.List;

public class Streams {
    public static void main(String[] args) {

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // 1. Find below a list of integers. Iterate over it and print the square of each number
        numbers.stream().map(n -> n*n).forEach(System.out::println);

        // 2. Find below a list of integers. Iterate over it and print every even number.
        numbers.stream().forEach( n -> {if(n%2 == 0) System.out.println(n);});

        // 3. For the list of integers, find all the even numbers. Then, iterate over the even numbers and print each number.
        numbers.stream().filter(n->n%2==0).forEach(System.out::println);

        // 4. For a list of integers, return a list of the squares of each number.
        List<Integer> squares = numbers.stream().map(n -> n*n).toList();
        System.out.println(squares);

        List<String> names = List.of("Tantia Tope", "Rani Lakshmibai", "Mangal Pandey", "Nana Sahib");
        // 5. For a list of strings, return a list of the length of each string.
        List<Integer> lengths = names.stream().map(name -> name.length()).toList();
        System.out.println(lengths);

        // 6. For a list of strings, filter out the strings which do not start with the letter T and then uppercase the remaining strings.
        List<String> filteredNames = names.stream().filter(name -> !name.startsWith("T")).map(String::toUpperCase).toList();
        System.out.println(filteredNames);

        // 7. For a list of strings, filter out the strings which do not start with the letter T, then uppercase the remaining strings and then sort them.
        List<String> filteredSortedNames = names.stream().filter(name -> !name.startsWith("T")).map(String::toUpperCase).sorted().toList();
        System.out.println(filteredSortedNames);

        // 8. For a list of integers, find the sum of all the numbers.
        Integer sum = numbers.stream().reduce(0,(currNum, currSum)->currSum+currNum);
        System.out.println(sum);

        // 9. For a list of integers, find the sum of the squares of all the numbers.
        Integer squareSum = numbers.stream().map(n -> n*n).reduce(0, (c,s)->c+s);
        System.out.println(squareSum);

        // 10. For a list of integers, find the sum of the squares of all the even numbers.
        Integer squareEvenSum = numbers.stream().filter(n -> n%2==0).map(n -> n*n).reduce(0, (c,s)->c+s);
        System.out.println(squareEvenSum);

        // 11. Given a list of numbers, find the maximum number in the list.
        Integer findMax = numbers.stream().reduce(Integer.MIN_VALUE, (c,r)->Integer.max(c,r));
        System.out.println(findMax);

        // 12. Given a list of numbers with duplicates, find the distinct numbers in the list.
        List<Integer> numbersDuplicates = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 2, 3, 4, 5);
        System.out.println(numbersDuplicates.stream().distinct().toList());

        // 13. Given a list of numbers, find the average of all the numbers.
        List<Double> doubleNums = List.of(1.0,2.0,3.0,4.0,5.0);
        Double average = doubleNums.stream().reduce(0.0,(currElement , currSum) -> currElement + currSum)/doubleNums.size();
        System.out.println(average);

        // 14. Give a list of strings, find the average length of all the strings.
        System.out.println(names.stream().map(name -> Double.valueOf(name.length())).reduce(0.0, (c,s)->c+s)/names.size());
        System.out.println(names.stream().mapToInt(String::length).average().getAsDouble());

        // 15. Given a list of strings, find the first string that is longer than 10 characters.
        System.out.println(names.stream().filter(name -> name.length() > 10).toList().get(0));

    }
}
