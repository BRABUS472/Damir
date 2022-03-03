import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriteRead {
    public static void main (String[] args){

        try (FileWriter file = new FileWriter("text.txt")){
            file.write("Hello\nSuka");
        }catch (IOException ex){
            ex.printStackTrace();
        }
        try (FileReader file=new FileReader("text.txt")){
            int b;
            while ((b= file.read()) !=-1)
                System.out.print((char) b);
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }
}
