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
        String b = new Integer(bb).toString();;
        String expResult = new Integer(aa+bb).toString();
        String result = SuperDodawanie.dodaj(a, b);
        assertEquals(expResult, result);
    }

    @Test
    public void testDodaj4(){ // float + float
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
    public void testDodaj5(){ // string + string
        System.out.println("dodaj");
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        Random r = new Random();
        StringBuilder a = new StringBuilder();
        StringBuilder b = new StringBuilder();
        int length = 5;
        for(int i = 0; i < length; i++){
            int index = r.nextInt(alphabet.length());
            char rChar = alphabet.charAt(index);
            a.append(rChar);
        }
        for(int i = 0; i < length; i++){
            int index = r.nextInt(alphabet.length());
            char rChar = alphabet.charAt(index);
            b.append(rChar);
        }
        String expResult = a.toString() + b.toString();
        String result = SuperDodawanie.dodaj(a.toString(), b.toString());
        assertEquals(expResult, result);
    }

    @Test
    public void testDodaj9()
    {
        System.out.println("Testing fractions...");

        String a = "1/2";
        String b = "-1/2";

        String exp = "0.0";
        assertEquals(exp, SuperDodawanie.dodaj(a, b));
    }

    @Test
    public void testDodaj10()
    {
        System.out.println("Testing fractions...");

        int n1, n2;
        int d1, d2;
        int bound = 50;

        Random r = new Random();

        n1 = r.nextInt(bound);
        n2 = r.nextInt(bound);

        d1 = r.nextInt(bound);
        d2 = r.nextInt(bound);

        String a = String.format("%d/%d", n1, d1);
        String b = String.format("%d/%d", n2, d2);
        float x = (float)n1 / (float)d1;
        float y = (float)n2 / (float)d2;
        assertEquals(String.valueOf(x+y), SuperDodawanie.dodaj(a, b));
    }
}
