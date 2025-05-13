import java.util.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

/**
 * QUESTION :
 * Écrivez le corps de la méthode searchValue(numbers, value) .
 * La méthode doit renvoyer une liste de 4 entiers, tous égaux à 0 ou 1 :
 * Le premier entier est 1 si value peut être trouvé dans la liste numbers à n'importe quel indice pair (les
 * indices sont comptés à partir de 0). Le deuxième entier est 1 si value peut être trouvé dans numbers
 * à n'importe quel indice impair. Le troisième entier est 1 si value peut être trouvé dans la première
 * moitié de numbers . Le quatrième entier est 1 si value peut être trouvé dans la seconde moitié de
 * numbers .
 * value peut être présent à plusieurs indices, vous devez tous les prendre en compte.
 * La taille de numbers est toujours un multiple de 2, de sorte qu'il n'y a pas d'ambiguïté lors de la
 * détermination de la première et la seconde moitié.
 * numbers est toujours défini (pas de « null », « None » ou l'une de ces valeurs), mais il peut être vide.
 */
class Solution {

    /**
     * @param numbers [[anArray]] d'entiers
     * @param value La valeur à chercher
     * @return Un tableau de 4 entiers 0/1, indiquant les zones où se trouve la valeur
     */
    public static List<Integer> searchValue(List<Integer> numbers, int value) {
        boolean foundEvenIndex = false;
        boolean foundOddIndex = false;
        boolean foundFirstHalf = false;
        boolean foundSecondHalf = false;

        int size = numbers.size();
        int mid = size / 2;

        for (int i = 0; i < size; i++) {
            if (numbers.get(i) == value) {
                if (i % 2 == 0) foundEvenIndex = true;
                else foundOddIndex = true;

                if (i < mid) foundFirstHalf = true;
                else foundSecondHalf = true;
            }
        }

        return Arrays.asList(
                foundEvenIndex ? 1 : 0,
                foundOddIndex ? 1 : 0,
                foundFirstHalf ? 1 : 0,
                foundSecondHalf ? 1 : 0
        );
    }

    /* Ignore and do not change the code below */
    private static final Gson gson = new GsonBuilder().disableHtmlEscaping().create();

    /**
     * Try a solution
     * @param valuePositions Un tableau de 4 entiers 0/1, indiquant les zones où se trouve la valeur
     */
    public static void trySolution(List<Integer> valuePositions) {
        System.out.println("" + gson.toJson(valuePositions));
    }

    public static void main(String args[]) {
        try (Scanner in = new Scanner(System.in)) {
            trySolution(searchValue(
                    gson.fromJson(in.nextLine(), new TypeToken<List<Integer>>(){}.getType()),
                    gson.fromJson(in.nextLine(), new TypeToken<Integer>(){}.getType())
            ));
        }
    }
    /* Ignore and do not change the code above */
}
