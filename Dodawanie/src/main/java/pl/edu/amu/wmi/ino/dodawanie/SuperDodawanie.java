/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.edu.amu.wmi.ino.dodawanie;

/**
 *
 * @author bikol
 */
public class SuperDodawanie {


    public static boolean isFloat(String s) {
        try {
            Float.parseFloat(s);
        } catch(NumberFormatException e) {
            return false;
        } catch(NullPointerException e) {
            return false;
        }
        return true;
    }

    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch(NumberFormatException e) {
            return false;
        } catch(NullPointerException e) {
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

    public static String dodaj(String a, String b){
        if (a == null || b == null){
            return null;
        }

        if(isInteger(a) && isInteger(b)){
            Integer x = Integer.parseInt(a);
            Integer y = Integer.parseInt(b);
            Integer ans = x + y;
            return ans.toString();
        }
        if(isFloat(a) && isFloat(b)){
            Float x = Float.parseFloat(a);
            Float y = Float.parseFloat(b);
            Float ans = x + y;
            return ans.toString();
        }

        float x = isFrac(a) ? parseFrac(a) : 0;
        float y = isFrac(b) ? parseFrac(b) : 0;
        if (x != 0 || y != 0) return String.valueOf(x + y);

        return a + b;
    }
}
