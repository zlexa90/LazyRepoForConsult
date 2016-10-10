package duplicatesforconsult;

import java.io.*;

import java.util.*;

/**
 *
 * @author Алексей Светлов
 */
public class DuplicatesForConsult {
    
    //static HashMap<String,Integer> treeMap = new HashMap<>();//вроде получается и с treeMap
    public static void main(String[] args) {       
        //пример работы требуемого метода:
        Duplicates duplicates=new Duplicates();
        duplicates.handleFile(new File("test.txt"), new File("test4.txt"));
    }    
    
}
