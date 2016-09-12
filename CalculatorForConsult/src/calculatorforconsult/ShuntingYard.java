/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculatorforconsult;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Алексей Светлов
 */
public class ShuntingYard {//Класс, выполняющий алгоритм сортировочной станции Дейкстры
    private String inputStr=null;//входная строка. Она должна быть с разделителями ' '
    private List<String> outputList=null;//выходной список
    private Stack<String> stack=null;//стек с операциями
    public ShuntingYard(String inputStr){
        this.inputStr=inputStr;
        this.outputList=new ArrayList<>();
        this.stack=new Stack<>();
    }
    
    public List<String> makeReversePolishNotation(){
        BracketCounter bracketCounter=new BracketCounter(inputStr);//проверка на равенство правых и левых скобок
        if(!bracketCounter.bracketsEqual())
            return null;
        String[] splittedString = inputStr.split("\\s+");//разделитель у токенов - пробел
        for(String currentStr:splittedString){
            if(currentStr.matches("\\d*\\.?\\d+")){//если - число, то сразу в выходной список
                outputList.add(currentStr);
            }else if(isOperator(currentStr)){//если это оператор
                if(!stack.empty()){
                    String stackHead=stack.peek();
                    if(getPriority(currentStr)<=getPriority(stackHead))
                        outputList.add(stack.pop());//если у оператора в стеке выше приоритет, то записать его в вых.список
                }
                stack.push(currentStr);   //записать оператор в стек             
            }else if(currentStr.equals("(")){
                stack.push(currentStr);//если встретилась левая скобка, то её - в стек
            }else if(currentStr.equals(")")){//если - правая, то ищем в стеке левую и записываем всё, что попадается в вых.список
                String stHead=stack.peek();
                for(;!stHead.equals("(") && !stack.empty();){
                    stHead=stack.pop();
                    if(!stHead.equals("("))
                        outputList.add(stHead);                    
                }
            }
        }        
        for(String str;!stack.empty();){//дописываем всё, что осталось в стеке в выходной список
            str=stack.pop();
            outputList.add(str);
        }
        return outputList;
    }
    private int getPriority(String operatorStr){//Получить приоритет оператора
        switch(operatorStr){
            case "*":
            case "/":return 10;
            case "+":
            case "-":return 1;
            default:return -1;
        }
    }
    private boolean isOperator(String str){//Проверить оператор ли это
        switch(str){
            case "+":
            case "-":
            case "*":
            case "/":return true;
            default:return false;
        }
    }
    public void printOutputList(){//печать списка операций и операндов
        if(outputList==null)
            System.out.println("null");
        else{
            System.out.print("Shunting Yard OutputList: ");
            for(String str:outputList){
                System.out.print(str);
            }
            System.out.println();
        }
            
    }
    public String toString(){//преобразование выходного списка токенов в строку
        if(outputList==null)
            return null;
        String result="";
        for(String str:outputList){
            result+=str;
        }
        return result;
    }
}
