/**
 * QUESTION :
 * StringUtilis.concat(String[] strings) sert à joindre des chaînes de caractères bout à bout.
 *
 * Par exemple, à partir d'un tableau contenant "f","o","o","bar", concat devrait
 * retourner "foobar".
 *
 * Données :strings contient toujours au moins un élément.
 *
 * Implémentez StringUtils.concat(String[] strings).
 *
 * class StringUtils{
 *
 *  /**
 *   * Concatenates the givern array strings.
 *    static String concat(String[] strings) {
 *
 *    }
 * }
 */
class StringUtils {
    /**
     * Concatenates the given array of strings.
     */
    static String concat(String[] strings) {
        // Vérifiez si le tableau est vide
        if (strings.length == 0) {
            return "";
        }

        // Créez une instance de StringBuilder pour construire la chaîne concaténée
        StringBuilder result = new StringBuilder();

        // Parcourez le tableau et ajoutez chaque élément à StringBuilder
        for (String str : strings) {
            result.append(str);
        }

        // Convertissez StringBuilder en une chaîne de caractères
        return result.toString();
    }
}

//Java 8 :
import java.util.Arrays;
import java.util.stream.Collectors;

class StringUtils {
    /**
     * Concatenates the given array of strings using Java 8.
     */
    static String concat(String[] strings) {
        // Use Java 8 streams to join the strings
        return Arrays.stream(strings)
                .collect(Collectors.joining());
    }
}