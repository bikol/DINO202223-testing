/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.edu.amu.wmi.ino.dodawanie;

import java.util.Arrays;
import java.util.StringTokenizer;
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

    public static boolean isLong(String s) {
        try {
            Long.parseLong(s);
        } catch(NumberFormatException e) {
            return false;
        } catch(NullPointerException e) {
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

    //private static
    public static boolean isFrac(String s)
    {
        if (s.chars().filter(c -> c == '/').count() != 1)
            return false;

        String[] frac = s.split("/");

        return isInteger(frac[0]) && isInteger(frac[1]);
    }

    public static float parseFrac(String s)
    {
        float den, num;

        String[] frac = s.split("/");
        num = Float.parseFloat(frac[0]);
        den = Float.parseFloat(frac[1]);

        return num/den;
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

    public static boolean hasPower(String s) {
        StringTokenizer st = new StringTokenizer(s, "^");
        if(st.countTokens() == 2){
            return true;
        }
        return false;
    }

    public static double parsePower(String s) {
        StringTokenizer st = new StringTokenizer(s, "^");
        Double num = Double.parseDouble(st.nextToken());
        Double pow = Double.parseDouble(st.nextToken());
        Double returnValue = Math.pow(num, pow);
        return returnValue;
    }

    public static String dodaj(String a, String b) {
        if (a == null || b == null) {
            return null;
        }

        if(hasPower(a)){
            a = String.valueOf(parsePower(a));
        }
        if(hasPower(b)){
            b = String.valueOf(parsePower(b));
        }


        if (isInteger(a) && isInteger(b)){
            Integer x = Integer.parseInt(a);
            Integer y = Integer.parseInt(b);
            Integer ans = x + y;
            return ans.toString();
        }
        if(isLong(a) && isLong(b)){
            Long x = Long.parseLong(a);
            Long y = Long.parseLong(b);
            Long ans = x + y;
            return ans.toString();
        }
        if (isFloat(a) && isFloat(b)) {
            Float x = Float.parseFloat(a);
            Float y = Float.parseFloat(b);
            Float ans = x + y;
            return ans.toString();
        }

        float x = isFrac(a) ? parseFrac(a) : 0;
        float y = isFrac(b) ? parseFrac(b) : 0;
        if (x != 0 || y != 0) return String.valueOf(x + y);

        if (isArrayOfUint(a) && isArrayOfUint(b)) {
            int[] intArray1 = stringToArray(a);
            int[] intArray2 = stringToArray(b);
            int[] ans = concatArray(intArray1, intArray2);
            return Arrays.toString(ans);
        }
        return a + b;
    }
}
