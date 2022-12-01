/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.edu.amu.wmi.ino.dodawanie;

import java.util.Arrays;
import java.util.regex.Pattern;

/**
 *
 * @author bikol
 */
public class SuperDodawanie {

    public static boolean isFloat(String s) {
        try {
            Float.parseFloat(s);
        } catch (NumberFormatException e) {
            return false;
        } catch (NullPointerException e) {
            return false;
        }
        return true;
    }

    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        } catch (NullPointerException e) {
            return false;
        }
        return true;
    }

    public static boolean isArrayOfUint(String str) {
        if (Pattern.matches("\\[ *[0-9]+( *, *[0-9]+)* *\\]", str) == false) {
            return false;
        }
        return true;
    }

    public static int[] stringToArray(String str) {
        String[] string = str.replaceAll("\\[", "")
                .replaceAll("]", "")
                .replaceAll(" ", "")
                .split(",");
        int[] arr = new int[string.length];
        for (int i = 0; i < string.length; i++) {
            arr[i] = Integer.valueOf(string[i]);
        }
        return arr;
    }

    static <T> int[] concatArray(int[] intArray1, int[] intArray2) {
        int[] result = Arrays.copyOf(intArray1, intArray1.length + intArray2.length);
        System.arraycopy(intArray2, 0, result, intArray1.length, intArray2.length);
        return result;
    }

    public static String dodaj(String a, String b) {
        if (a == null || b == null) {
            return null;
        }
        if (isInteger(a) && isInteger(b)) {
            Integer x = Integer.parseInt(a);
            Integer y = Integer.parseInt(b);
            Integer ans = x + y;
            return ans.toString();
        }
        if (isFloat(a) && isFloat(b)) {
            Float x = Float.parseFloat(a);
            Float y = Float.parseFloat(b);
            Float ans = x + y;
            return ans.toString();
        }
        if (isArrayOfUint(a) && isArrayOfUint(b)) {
            int[] intArray1 = stringToArray(a);
            int[] intArray2 = stringToArray(b);
            int[] ans = concatArray(intArray1, intArray2);
            return Arrays.toString(ans);
        }
        return a + b;
    }
}
