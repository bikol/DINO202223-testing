package pl.edu.amu.wmi.ino.dodawanie;

import java.util.Random;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author bikol
 */
public class SuperDodawanieTest {

    public SuperDodawanieTest() {
    }

    @Test
    public void testDodaj1() {
        System.out.println("dodaj");
        String a = "1";
        String b = "1";
        String expResult = "2";
        String result = SuperDodawanie.dodaj(a, b);
        assertEquals(expResult, result);
    }

    @Test
    public void testDodaj2() {
        System.out.println("dodaj");
        String a = "0";
        String b = "0";
        String expResult = "0";
        String result = SuperDodawanie.dodaj(a, b);
        assertEquals(expResult, result);
    }

    @Test
    public void testDodaj3() {
        System.out.println("dodaj");
        Random r = new Random();
        int aa = r.nextInt(10);
        int bb = r.nextInt(10);
        String a = new Integer(aa).toString();
        String b = new Integer(bb).toString();
        String expResult = new Integer(aa + bb).toString();
        String result = SuperDodawanie.dodaj(a, b);
        assertEquals(expResult, result);
    }

    @Test
    public void testDodaj4() { // float + float
        System.out.println("dodaj");
        Random r = new Random();
        float aa = r.nextFloat();
        float bb = r.nextInt();
        String a = new Float(aa).toString();
        String b = new Float(bb).toString();
        String expResult = new Float(aa + bb).toString();
        String result = SuperDodawanie.dodaj(a, b);
        assertEquals(expResult, result);
    }

    @Test
    public void testDodaj5() { // string + string
        System.out.println("dodaj");
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        Random r = new Random();
        StringBuilder a = new StringBuilder();
        StringBuilder b = new StringBuilder();
        int length = 5;
        for (int i = 0; i < length; i++) {
            int index = r.nextInt(alphabet.length());
            char rChar = alphabet.charAt(index);
            a.append(rChar);
        }
        for (int i = 0; i < length; i++) {
            int index = r.nextInt(alphabet.length());
            char rChar = alphabet.charAt(index);
            b.append(rChar);
        }
        String expResult = a.toString() + b.toString();
        String result = SuperDodawanie.dodaj(a.toString(), b.toString());
        assertEquals(expResult, result);
    }

}
