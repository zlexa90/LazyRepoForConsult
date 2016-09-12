/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculatorforconsult;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Алексей Светлов
 */
public class BracketCounterTest {
    
    public BracketCounterTest() {
    }

    @Test
    public void testBracketsEqual() {
        String bracketsEqual="( 1 + 2 ) * 4 + ( 3 - ( 1 / 9 ) )";
        System.out.println(bracketsEqual);
        BracketCounter bracketCounter=new BracketCounter(bracketsEqual);
        boolean result=bracketCounter.bracketsEqual();
        System.out.println("equal: "+result);
        assertTrue(result);
    }
    @Test
    public void testBracketsNotEqual() {
        String bracketsNotEqual="( 1 + 2  * 4 + ( 3 - ( 1 / 9 ) )";
        System.out.println(bracketsNotEqual);
        BracketCounter bracketCounter=new BracketCounter(bracketsNotEqual);
        boolean result=bracketCounter.bracketsEqual();
        System.out.println("equal: "+result);
        assertFalse(result);
    }
    
}
