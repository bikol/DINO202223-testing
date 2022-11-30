/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.edu.amu.wmi.ino.dodawanie;

import java.util.StringTokenizer;

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

    public static String dodaj(String a, String b){
        if(hasPower(a)){
            a = String.valueOf(parsePower(a));
        }
        if(hasPower(b)){
            b = String.valueOf(parsePower(b));
        }
        if(isInteger(a) && isInteger(b)){
            Integer x = Integer.parseInt(a);
            Integer y = Integer.parseInt(b);
            Integer ans = x + y;
            return ans.toString();
        }
        if(isInteger(a) && isInteger(b)){
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
        if(isFloat(a) && isFloat(b)){
            Float x = Float.parseFloat(a);
            Float y = Float.parseFloat(b);
            Float ans = x + y;
            return ans.toString();
        }
        return a + b;
    }
}
