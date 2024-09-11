package util;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class FileWrite {

    public static void writeFile(String fileName,String message){

        try {
            FileWriter fileWriter = new FileWriter(fileName,true);
            BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
            bufferedWriter.write(message);
            bufferedWriter.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }

    }


}
