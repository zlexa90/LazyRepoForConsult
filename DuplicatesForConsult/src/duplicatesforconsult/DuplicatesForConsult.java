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
        DuplicatesForConsult duplicatesForConsult=new DuplicatesForConsult();
        duplicatesForConsult.handleFile(new File("test.txt"), new File("test4.txt"));
    }    
    //требуемый метод
    public boolean handleFile(File inputFile,File outputFile){
        if(inputFile==null || outputFile==null)
            return false;
        if(!inputFile.exists())//если нет входного файла, то метод заканчивается возвращением false
            return false;
        else{
            //записать в тримеп строки с повторениями из входного файла 
            Map<String,Integer> treeMap = new TreeMap<>();
            String inputFileName=inputFile.getName();
            FileReader fileReader = null;
            try{
                fileReader=new FileReader(inputFile);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String str = null;
                System.out.println("Reading data from file: " + inputFileName);
                Integer value=null;
                while((str=bufferedReader.readLine())!=null){
                    System.out.println(str);
                    value = treeMap.get(str);
                    if(value==null){
                        treeMap.put(str, 1);//если не нашлось строки в тримепе - создать новую 
                    }else{
                        treeMap.put(str, ++value);//если строка нашлась, то увеличить её значение
                    }
                }
                bufferedReader.close();
            }catch(Exception e){
                e.printStackTrace();
                return false;
            }
            if(!outputFile.exists()){//выходной файл не существует
                //создать выходной файл
                try{
                    File parentFile=outputFile.getParentFile();
                    if(parentFile!=null)
                        parentFile.mkdirs();
                    outputFile.createNewFile(); 
                }catch(Exception e){
                    e.printStackTrace();
                    return false;
                }
            }    
            //записать отсортированные строки в выходной файл             
            try{
                FileWriter fileWriter = new FileWriter(outputFile,true);//true - для дозаписи в файл            
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

                System.out.println("Data in treeMap:");
                for (Map.Entry entry : treeMap.entrySet()) {
                    String outString=entry.getKey() + "["+ entry.getValue()+"]";//строка на вывод и в файл и в консоль
                    System.out.println(outString);     
                    bufferedWriter.write(outString);               
                    bufferedWriter.newLine();
                }
                bufferedWriter.close();
                System.out.println("Written data to file: " + outputFile.getName());
            }catch(Exception e){
                e.printStackTrace();
                return false;
            }
            
            
        }
        return true;
    }
}
