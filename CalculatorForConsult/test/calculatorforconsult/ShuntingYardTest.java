/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculatorforconsult;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Алексей Светлов
 */
public class ShuntingYardTest {
    
    public ShuntingYardTest() {
    }

    @Test
    public void testMakeReversePolishNotation() {//тест преобразования выражения в форма обратной польской записи
        String expression="1 + 2";
        System.out.println("ShuntingYard testing: "+expression);
        ShuntingYard shuntingYard=new ShuntingYard(expression);
        shuntingYard.makeReversePolishNotation();
        String result=shuntingYard.toString();
        System.out.println("ShuntingYard result: "+result);
        assertTrue(result.equals("12+"));
    }
    
}
