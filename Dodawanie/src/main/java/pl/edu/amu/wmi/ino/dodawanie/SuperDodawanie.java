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

    public static String dodaj(String a, String b) {
        Integer x = Integer.parseInt(a);
        Integer y = Integer.parseInt(b);
        Integer ans = x + y;
        return ans.toString();
    }
    
}
