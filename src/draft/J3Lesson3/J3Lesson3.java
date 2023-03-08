package draft.J3Lesson3;

import java.io.*;

public class J3Lesson3 {
    public static void main(String[] args) throws IOException {
//        File file = new File("src/draft/J3Lesson3/41");
//
//        String[] str = file.list();//получим полный список файлов указанной папке
//        for (String o : str) {
//            System.out.println(o);
//        }
//
//
//        //file.mkdirs();//полностью создает полный путь при необходимости
//        //file.mkdir(); // заточен на создание файла при указанном пути
//
//
//        String[] str1 = file.list(new FilenameFilter() {//файл фильтр
//            @Override
//            public boolean accept(File dir, String name) {
//                return name.startsWith("1");//фильтр начинает файл с 1
//            }
//        });
//        for (String o : str1) {
//            System.out.println(o);
//        }
//
//
//        System.out.println(file.isHidden());//скрыт ли файл
//        System.out.println(file.getParent());//родительская папка
//
//
//        try (FileInputStream in = new FileInputStream("src/draft/J3Lesson3/41/123.txt")) {//считывание файла
//            System.out.println("Считывание файла");
//            int x;
//            while ((x = in.read()) != -1) {//конец файла будет возвращать -1
//                System.out.print((char)x);
//            }
//            System.out.println();
//            System.out.println();
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//
//
//
//
//     //увеличение быстродействия при считывания файла
//        try (FileInputStream in = new FileInputStream("src/draft/J3Lesson3/41/123.txt")) {//считывание файла
//            System.out.println("увеличение быстродействия при считывания файла");
//            byte[] arr = new byte[512];
//            int x;
//            while ((x = in.read(arr)) != -1) {//конец файла будет возвращать -1
//                System.out.print(new String(arr,0,x, "UTF-8"));
//            }
//            System.out.println();
//            System.out.println();
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//
//
//
//
//        //InputStreamReader работа в обе стороны
//        try (InputStreamReader isr = new InputStreamReader(new FileInputStream("src/draft/J3Lesson3/41/123.txt"))) {//считывание файла
//            System.out.println("InputStreamReader");
//            int x;
//            while ((x = isr.read()) != -1) {//конец файла будет возвращать -1
//                System.out.print((char)x);
//            }
//            System.out.println();
//            System.out.println();
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//
//
//
//
//        //для работы с большим файлом лучше использовать BufferedReader
//
//        String FILENAME = "src/draft/J3Lesson3/41/123.txt";
//        System.out.println("BufferedReader");
//        BufferedReader br = null;
//        FileReader fr =null;
//
//            fr = new FileReader(FILENAME);
//            br = new BufferedReader(fr);
//
//        String currentLine;
//
//        while ((currentLine = br.readLine())!=null){//readLine читает уже по линиям
//            System.out.println(currentLine);
//        }
//
//
//
//
//        //потоки загрузки в себя и вывода
//
//        PipedInputStream in = null;
//        PipedOutputStream out = null;
//
//        in = new PipedInputStream();
//        out = new PipedOutputStream();
//
//        out.connect(in);
//
//        for (int i = 0; i<100; i++){
//            out.write(i);
//        }
//
//        int x;
//
//        while ((x= in.read())!=-1){
//            System.out.println(x+" ");
//        }
//
//
//
//
//
//
//        //все файлы поместить в один поток через коллекцию
//
//        ArrayList<InputStream> ali = new ArrayList<>();
//        ali.add(new FileInputStream("src/draft/J3Lesson3/41/123.txt"));
//        ali.add(new FileInputStream("src/draft/J3Lesson3/41/1.txt"));
//        ali.add(new FileInputStream("src/draft/J3Lesson3/41/456.txt"));
//        SequenceInputStream in2 = new SequenceInputStream(Collections.enumeration(ali));
//
//        int c;
//
//        while ((c=in2.read())!=-1){
//            System.out.print((char)c);
//
//        }
//        in2.close();
//




        //начинать чтения с определенного места

        try (RandomAccessFile raf = new RandomAccessFile("src/draft/J3Lesson3/41/123.txt",  "r")){//mode r-чтение, rw-чтение запись
            raf.seek(4);//указываем байты (позиция начинается с 0)
            System.out.println((char) raf.read());
            raf.seek(1);//указываем байты (позиция начинается с 0)
            System.out.println((char) raf.read());
            raf.seek(0);//указываем байты (позиция начинается с 0)
            System.out.println((char) raf.read());
        }
        }
    }
