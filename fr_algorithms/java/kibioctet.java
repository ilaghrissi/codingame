/**
 * QUESTION : Objectif
 *
 * Pour éviter la confusion entre les multiples de 1000 octets et les multiples de 1024
 * octets, les termes "kibioctet", "mébioctet", etc. ont été inventés.
 * 	* Un kibioctet (abrégé KiB) correspond à 1024 octets.
 * 	* Un mébioctet (abrégé MiB) correspond à (1024 * 1024  = 1048576) octets
 *
 * Etant donne une quantité d'octets :
 * 	* Si elle est inférieurs à un KiB, renvoyez-la sous forme d'une châine de caractère.
 * 	* Si elle est comprise entre un KiB (inclus) et un MiB (exclu), convertissez-la en
 * 	  KiB, arrondissez à l'unité inférieurs est renvoyez-la suivie d'un espace et du texte
 * 	  "KiB".
 * 	* Si elle est supérieure ou égale à un MiB, convertissez-la en MiB, arrondissez à
 * 	l'unité inferieure et renvoyez-la suivie d'un espace et du texte "MiB".
 * Vous n'aurez jamaise de valeurs supérieures à 10 puissance 9 octets, donc vous n'atteindrez
 * jamais le gibibyte".
 *
 * Voir l'exemple ci-dessous.
 *
 * import java.util.*;
 * import com.google.gson.Gson;
 * import com.google.gson.GsonBuilder;
 * import com.google.gson.reflect.TypeToken;
 *
 * class Solution {
 *
 * 	public static String compute(int bytesQuantity){
 * 		return "foo";
 * 	    }
 * }
 */
class Solution {

    public static String compute(int bytesQuantity) {
        if (bytesQuantity < 1024) {
            return String.valueOf(bytesQuantity);
        } else if (bytesQuantity < 1048576) { // Entre 1 KiB inclus et 1 MiB exclu
            int kibibytes = bytesQuantity / 1024;
            return kibibytes + " KiB";
        } else { // Supérieur ou égal à 1 MiB
            int mebibytes = bytesQuantity / 1048576;
            return mebibytes + " MiB";
        }
    }

    public static void main(String[] args) {
        int[] testValues = {500, 2048, 1500000}; // Exemples de valeurs

        for (int value : testValues) {
            System.out.println(compute(value));
        }
    }
}
/*
Test Simple :
-500000     ==> 488 KiB
-Un octet de moins qu'un KiB
-Exactement un KiB
-Un octet de moins qu'un MiB
 */