package calculatorforconsult;

import java.util.*;

/**
 *
 * @author Алексей Светлов
 */
public class CalculatorForConsult {
    public static void main(String[] args) {
        //примеры выполнения
        computeMethod("( 1 + 2 ) * 4 - 1");//11
        computeMethod("( 1 + 2  * 4 - 1");//null
        computeMethod("1.0 + 2 * 2");//5
        computeMethod("( 1 + 2 ) * 4 + ( 3 - ( 1 / 9 ) )");//14,8889

    }
    //Требуемый метод
    //выражения нужно писать отделяя числа, скобки и знаки операций пробелами
    public static void computeMethod(String expression){
        System.out.println(expression);
        ShuntingYard shuntingYard=new ShuntingYard(expression);
        //создать список токенов для вычисления по обратной польской записи
        List<String> revPolExpression2=shuntingYard.makeReversePolishNotation();
        //его печать
        shuntingYard.printOutputList();        
        //создание объекта обратной польской записи для вычисления
        ReversePolishNotation reversePolishNotation2=new ReversePolishNotation(revPolExpression2);
        //вычисление по обратной польской записи
        Double result=reversePolishNotation2.compute();
        //вывод результата по формату
        System.out.println(String.format("Result= %(.4f", result));//конечный результат под округлением
    }
}
