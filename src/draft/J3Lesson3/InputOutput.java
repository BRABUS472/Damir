package draft.J3Lesson3;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class InputOutput {
    public static void main(String[] args) throws IOException {

        //чтение с файла потоком
        try (FileInputStream in = new FileInputStream("src/draft/J3Lesson3/123/2.txt")) {
            byte[] arr = new byte[512];//чтение с файла потокомб с помощью определенного размер байта длоя экономии времени
            int x;
            while ((x = in.read(arr)) != -1) {//заканчивает чтение файла при -1
                System.out.println(new String(arr, 0, x, "UTF-8"));
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        System.out.println();
        System.out.println();


//считывает байты с потока и автоматически представляет в виде символов
        try(InputStreamReader isr = new InputStreamReader(new FileInputStream("src/draft/J3Lesson3/123/2.txt"))) {

            int x;
            while ((x = isr.read()) != -1) {
                System.out.print((char) x);
           }
        } catch (IOException e) {
           e.printStackTrace();
        }



        //при работе с большими файлами необходимо использовать BufferedReader
        String FILENAME = "src/draft/J3Lesson3/123/2.txt";

        BufferedReader br = null;
      FileReader fr= null;

      fr = new FileReader(FILENAME);
      br = new BufferedReader(fr);
        String currentLine;

       while ((currentLine = br.readLine()) != null) {
                System.out.println(currentLine);
        }
       System.out.println(currentLine);



       //вывод определенной строки


//            int count = 1;
//        while ((currentLine = br.readLine()) != null) {
//            if(count == 15) {
//                System.out.println(currentLine);
//            }
//            count++;
//        }



        // Piped потоким считывания и вывода
//        System.out.println();
//        System.out.println();
//        System.out.println("Piped");
//       PipedInputStream in1 = null;
//       PipedOutputStream out1 = null;
//
//       in1 = new PipedInputStream();
//       out1 = new PipedOutputStream();
//
//       out1.connect(in1);
//
//       for(int i=0; i<100; i++){
//           out1.write(i);
//       }
//
//        int x;
//
//        while ((x = in1.read())!=-1){
//            System.out.println(x+" ");
//        }
//

        //SequenceInputStream-обьединение не скольких фалов в поток

        System.out.println();
        System.out.println();
        System.out.println("SequenceInputStream");
        ArrayList<InputStream> ali = new ArrayList<>();
        ali.add(new FileInputStream("src/draft/J3Lesson3/123/1.txt"));
        ali.add(new FileInputStream("src/draft/J3Lesson3/123/2.txt"));
        SequenceInputStream in = new SequenceInputStream(Collections.enumeration(ali));

        int x1;
        while ((x1 = in.read()) != -1) {
            System.out.print((char) x1);
        }

        in.close();



        //RandomAccessFile-работа с потоком с определенного байта

        System.out.println();
        System.out.println();
        System.out.println("RandomAccessFile");

            try(RandomAccessFile raf = new RandomAccessFile("src/draft/J3Lesson3/123/1.txt", "r")) {//r -чтение, rw -чтение и запись
                raf.seek(10);
                System.out.println((char) raf.read());
              raf.seek(4);
              System.out.println((char) raf.read());
            }

    }
}