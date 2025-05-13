/**
 * QUESTION :
 * Dans le pays enchanté d'Evenaria, une elfe nommé Codelia était à la recherche des
 * mystérieuses "Pierre paires", qui maintenaient l'équilibre et l'harmonie. Un jour, elle
 *
 * import java.util.*;
 * import com.google.gson.Gson;
 * import com.google.gson.GsonBuilder;
 * import com.google.gson.reflect.TypeToken;
 *
 * class Solution{
 *
 *  /**
 *  * @param numbers A list of integers
 *  * @return The reversed list with only even numbers
 *  public statis List<Integer> spell(List<Integer> numbers){
 *    // Write your code here
 *
 *    return Arrays.asList(189, 30, 20);
 * }
 *
 * Test
 * Pramaètre :
 * [4, 2, 28, 19, 44, 32, 18, 26, 2, 13]
 * Valeur de retour :
 * [2, 26, 18, 32, 44, 28, 2, 4]
 */


import java.util.ArrayList;
import java.util.List;

class Solution {
    public static List<Integer> spell(List<Integer> numbers) {
        List<Integer> reversedEvenNumbers = new ArrayList<>();

        for (int i = numbers.size() - 1; i >= 0; i--) {
            if (numbers.get(i) % 2 == 0) {
                reversedEvenNumbers.add(numbers.get(i));
            }
        }

        return reversedEvenNumbers;
    }

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(4, 2, 28, 19, 44, 32, 18, 26, 2, 13));
        List<Integer> result = spell(numbers);
        System.out.println(result);
    }
}

// en Java 8 :
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public static List<Integer> spell(List<Integer> numbers) {
        List<Integer> reversedEvenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        Collections.reverse(reversedEvenNumbers);
        return reversedEvenNumbers;
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(4, 2, 28, 19, 44, 32, 18, 26, 2, 13);
        List<Integer> result = spell(numbers);
        System.out.println(result);
    }
}