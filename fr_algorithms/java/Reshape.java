import java.util.*;
import java.io.*;
import java.nio.*;
import java.math.*;

/**
 * QUESTION : La méthode reshape(n, str) retourne la chaine str sans les espaces et formatée en lignes de n
 * caractères maximum.
 * Exemples :
 * Appel Valeur retour
 * reshape(3, "abc de fghij")
 * abc
 * def
 * ghi
 * j
 * reshape(2, "1 23 456")
 * 12
 * 34
 * 56
 *
 * Écrivez le corps de la méthode reshape(n, str) .
 * Note : n'ajoutez pas de caractère \n final.
 */
class Solution {
    public static String reshape(int n, String str) {
        str = str.replaceAll(" ", "");
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            if (i > 0 && i % n == 0) {
                sb.append("\n");
            }
            sb.append(str.charAt(i));
        }

        return sb.toString();
    }
}
