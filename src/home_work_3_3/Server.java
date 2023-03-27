package home_work_3_3;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    public static void main(String[] args) {

        ServerSocket server = null;
        Socket socket = null;


        try {
            server = new ServerSocket(1234);
            System.out.println("Сервер запущен!");

            socket = server.accept();

            Scanner sc = new Scanner(socket.getInputStream());
            PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
            Scanner console = new Scanner(System.in);

            //принятие сервер
            Thread t1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        String str = sc.nextLine();
                        if (str.equals("/end")) break;
                        if (str.equals("/ser")) {
                            SerServer();
                            try {
                                System.out.println(" Сериализованный файл "+ReadSerFile());
                                out.println(ReadSerFile());
                                System.out.println("отправка сериализованного файла");
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.println("Client " + str);
                        out.println("echo " + str);
                    }
                }
            });
            t1.start();

            //отправка сервер
            Thread t2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        System.out.println("Введите сообщение");
                        String str = console.nextLine();
//                        if (str.equals("/ser")) {
//                            SerServer();
//                            try {
//                                System.out.println(" Сериализованный файл "+ReadSerFile());
//                                out.println(ReadSerFile());
//                                System.out.println("отправка сериализованного файла");
//                            } catch (IOException e) {
//                                e.printStackTrace();
//                            }
//                            System.out.println("сериализация");
//                        }
                        System.out.println("Сообщение отправлено");
                        out.println("/ser"+str);
                    }
                }
            });

            t2.setDaemon(true);
            t2.start();


            try {
                t1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


        public static void SerServer () {
            Students students = new Students(1, "Bob");
            ObjectOutputStream oos = null;
            try {
                oos = new ObjectOutputStream(new FileOutputStream("Damir/src/home_work_3_3/stud.ser"));
                oos.writeObject(students);
                oos.close();
            } catch (IOException e) {
                System.out.println("не удалось сериализовать");
                ;
            }
        }

        public static String ReadSerFile () throws IOException {

            String FILENAME = "Damir/src/home_work_3_3/stud.ser";

            BufferedReader br = null;
            FileReader fr = null;

            fr = new FileReader(FILENAME);
            br = new BufferedReader(fr);
            String currentLine;

            while ((currentLine = br.readLine()) != null) {
                return currentLine;
            }  return FILENAME;


//    public void sendMsg(String msg){
//        try {
//            this.out.writeUTF(msg);
//        } catch (IOException var3) {
//            var3.printStackTrace();
//        }
//    }
        }
}



