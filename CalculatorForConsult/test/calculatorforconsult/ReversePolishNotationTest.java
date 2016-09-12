/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculatorforconsult;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Алексей Светлов
 */
public class ReversePolishNotationTest {
    
    public ReversePolishNotationTest() {
    }

    @Test
    public void testCompute() {//(1+2)*4-3 = 9.0
        System.out.println("testCompute starts");
        List<String> revPolExpression=new ArrayList();
        revPolExpression.add("1");
        revPolExpression.add("2");
        revPolExpression.add("+");
        revPolExpression.add("4");
        revPolExpression.add("*");
        revPolExpression.add("3");
        revPolExpression.add("-");
        ReversePolishNotation reversePolishNotation=new ReversePolishNotation(revPolExpression);
        
        System.out.println("(1+2)*4-3");
        Double result=reversePolishNotation.compute();
        System.out.println("result="+result);
        assertTrue(result.equals(9.0));
    }
    
}
