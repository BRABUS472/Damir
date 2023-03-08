package draft.J3Lesson3;

import java.io.*;

public class File_work {
    public static void main(String[] args) throws IOException {


        // создание файла
        File file = new File("src/draft/J3Lesson3/123");// выбор пути
       // file.mkdir();//создание файла в выбранной директории
        // file.mkdirs();//создание файла полностью с путью




        String[] str = file.list();// весь список файлов, которые находяться в src/draft/J3Lesson3/123
        for (String o : str){
            System.out.println(o);//вывод списка

            System.out.println();
            System.out.println();
        }



            //набор данных с определеннм фильтром

        String[] str1= file.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.startsWith("1");//начинается с цифры 1
            }
        });

        for (String o : str1){
            System.out.println(o);//вывод списка
        }



        //переименовывание файла или типо того
//        File file1 = new File("src/draft/J3Lesson3/123/1.txt");
//        File file2 = new File("src/draft/J3Lesson3/123/2.txt");
//
//        if(file2.exists()) {
//            throw new java.io.IOException("file exists");
//        }
//
//        boolean b = file1.renameTo(file2);
//        System.out.println(b);



        //проверка на скрыт ли файл
        System.out.println(file.isHidden());


        //обращение к родительской папке
        System.out.println(file.getParent());


        //вывод полного пути
        System.out.println(file.getPath());



        }
}
