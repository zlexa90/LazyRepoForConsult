/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculatorforconsult;

/**
 *
 * @author Алексей Светлов
 */
public class BracketCounter {//этот класс возможно не понадобится...
    private String strWithBrackets=null;
    private int leftBrackets=-1;//'('
    private int rightBrackets=-1;//')'
    public BracketCounter(String strWithBrackets){
        this.strWithBrackets=strWithBrackets;
    }
    public boolean bracketsEqual(){
        if(strWithBrackets==null)
            return true;
        leftBrackets=0;
        rightBrackets=0;
        for(char current:strWithBrackets.toCharArray()){
            if(current=='(')
                leftBrackets++;
            else if(current==')')
                rightBrackets++;
        }
        if(leftBrackets==rightBrackets)
            return true;
        else
            return false;
            
    }
}
