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
        return a + b;
    }
}
