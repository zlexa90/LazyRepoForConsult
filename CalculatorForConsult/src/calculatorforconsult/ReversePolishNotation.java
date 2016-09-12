/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculatorforconsult;

import java.util.*;
import java.util.regex.*;
import java.util.Stack;
/**
 *
 * @author Алексей Светлов
 */
public class ReversePolishNotation {//Класс, выполняющий алгоритм обратной польской записи
    private Stack<Double> stack=null;
    private List<String> revPolishTokens=null;//список операций и операндов в обратной польской записи
    
    public ReversePolishNotation(List<String> revPolishTokens){
        this.revPolishTokens=revPolishTokens;
        this.stack=new Stack<>();
    }
    public void printRevPolishTokens(){//печать списка операций и операндов
        if(revPolishTokens==null)
            System.out.println("null");
        else{
            System.out.print("ReversePolishNotation: revPolishTokens: ");
            for(String str:revPolishTokens){
                System.out.print(str);
            }
            System.out.println();
        }
            
    }
    public void printStack(){//на всякий случай распечатка стека
        for(;!stack.empty();){
            double dNumber=stack.pop();
            System.out.println("from stack:"+dNumber);
        }
    }
    public Double compute(){//вычисление по обратной польской записи
        if(revPolishTokens==null)//если пришёл null - вернуть null
            return null;
        for(int i=0;i<revPolishTokens.size();i++){//цикл по списку операндов и операций
            if(revPolishTokens.get(i).matches("\\d*\\.?\\d+"))//проверка на число
                stack.push(Double.valueOf(revPolishTokens.get(i)));//число должно быть записано в стек
            else {
                if(stack.empty())//на случай ошибки в списке
                    return null;
                Double secondOperand=stack.pop();//на вершине стека - второй операнд
                if(stack.empty())
                    return null;
                Double firstOperand=stack.pop();//теперь можно брать первый операнд
                if(revPolishTokens.get(i).equals("+")){//для сложения
                    stack.push(firstOperand+secondOperand);
                }else if(revPolishTokens.get(i).equals("-")){//для вычитания
                    stack.push(firstOperand-secondOperand);
                }else if(revPolishTokens.get(i).equals("*")){//для умножения
                    stack.push(firstOperand*secondOperand);
                }else if(revPolishTokens.get(i).equals("/")){//для деления
                    stack.push(firstOperand/secondOperand);
                }else
                    return null;//если очередной токен не число и не операция
            }
        }
        return stack.pop();//теперь в стеке должен быть результат
    }
}
