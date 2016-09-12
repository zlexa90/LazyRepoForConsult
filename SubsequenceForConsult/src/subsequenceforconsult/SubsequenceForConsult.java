/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subsequenceforconsult;

import java.util.*;

/**
 *
 * @author Алексей Светлов
 */
public class SubsequenceForConsult {
    public static void main(String[] args) {
        Integer i=1;
        String s="abv";
        String s2="abv";
        Object obj1=s;
        Object obj2=s2;
        Object obj3=i;
        
        SubsequenceForConsult instance=new SubsequenceForConsult();
        //пример 1: Xi: abv;abv;1; 
        //          Yi: abv;abv;1;
        List<Object> Xi=new ArrayList<>();
        List<Object> Yi=new ArrayList<>();  
        
        Xi.add(obj1);
        Xi.add(obj2);
        Xi.add(obj3);
        Yi.add(obj1);
        Yi.add(obj2);
        Yi.add(obj3);
        System.out.println("Xi и Yi="+instance.smartCompare(Xi, Yi));

        //пример 2: Xi: abv;1; 
        //          Yi: abv;abv;1;
        List<Object> Xi2=new ArrayList<>();
        List<Object> Yi2=new ArrayList<>();
        
        Xi2.add(obj1);
        Xi2.add(obj3);
        Yi2.add(obj1);
        Yi2.add(obj2);
        Yi2.add(obj3);
        System.out.println("Xi2 и Yi2="+instance.smartCompare(Xi2, Yi2));
                
        //пример 3: Xi: abv;abv;1; 
        //          Yi: abv;abv;abv;abv;
        List<Object> Xi3=new ArrayList<>();
        List<Object> Yi3=new ArrayList<>();
        
        Xi3.add(obj1);
        Xi3.add(obj2);
        Xi3.add(obj3);
        Yi3.add(obj1);
        Yi3.add(obj2);
        Yi3.add(obj1);
        Yi3.add(obj1);
        System.out.println("Xi3 и Yi3="+instance.smartCompare(Xi3, Yi3));
    }
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
