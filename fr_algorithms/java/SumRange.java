/**
 * QUESTION : La méthode sumRange devrait retourner la somme des entiers compris entre 10 et 1000 inclusifs
 * contenus dans le tableau passé en paramètres.
 *
 * Corrigez la méthode sumRange.
 *
 * Note : le paramètre ints n'est jamais null.
 */

import java.util.*;
import java.io.*;
import java.nio.*;
import java.math.*;

class Solution {

    static int sumRange(int[] ints){
        int sum = 0;

        for (int num : ints) {
            if (num >= 10 && num <= 1000) {
                sum += num;
            }
        }

        return sum;
    }
}

code de test :
int[] ints1 = { 1, 20, 3, 10, -2, 100};
int result1 = Solution.sumRange(ints1);
System.out.println("result: " + result1 + ", expected result: 130");
int[] ints2 = { 30, 4, 9, 12, 98, -10, 10 };
int result2 = Solution.sumRange(ints2);
System.out.println("result: " + result2 + ", expected result: 150");