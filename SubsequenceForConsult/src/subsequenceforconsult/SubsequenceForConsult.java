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
        
        Subsequence instance=new Subsequence();
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
    
}
