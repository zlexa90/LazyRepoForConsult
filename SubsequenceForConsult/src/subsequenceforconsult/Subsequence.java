/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subsequenceforconsult;

import java.util.List;

/**
 *
 * @author Алексей Светлов
 */
public class Subsequence {
    //метод, требуемый в задании(пытается привести Yi к Xi вычеркиванием элементов)
    public boolean smartCompare(List<Object> Xi,List<Object> Yi){
        if(Xi==null)//если список Xi пуст, то к такому состоянию всегда можно привести Yi вычёркиванием
            return true;
        if(Yi==null)//если Yi пуст, то привести его к Xi вычеркиванием не получится
            return false;        
        printObjList(Xi,"Xi");//печатаю оба списка
        printObjList(Yi,"Yi");
        for(int i=0;i<Xi.size();){
            if(Yi.size()<Xi.size())//Если слишком много навычеркивали и Yi стал меньше, то его не пр. к Xi
                return false;
            if(Yi.get(i).equals(Xi.get(i))){//если элементы равны, то идём к следующему Xi
                i++;
            }
            else{                
                Yi.remove(i);//если не равны, то вычекнем из Yi элемент
            }           
        }
        return true;//если после приведения ещё остались элементы в Yi, то это всё равно правильно,
                    //ведь их можно вычеркнуть, и получится полное соответствие Xi
    }
    public void printObjList(List<Object> list,String name){//вывод списка в консоль
        System.out.print(name+": ");
        for(Object obj:list){
            System.out.print(obj+";");
        }
    }
}
