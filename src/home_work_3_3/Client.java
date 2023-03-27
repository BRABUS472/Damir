package home_work_3_3;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {


    public static void main(String[] args) {


        Socket socket = null;

        try {
            socket = new Socket("localhost", 1234);
            Scanner in = new Scanner(socket.getInputStream());
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            Scanner console = new Scanner(System.in);

            //принятие клиент

            Thread t1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        String str1 = in.nextLine();
                        String[] tokens = str1.split("\\s");
                        
                        if (tokens[0].equals("/ser")) {
                            try {
                                deSer(tokens [2]);
                            } catch (IOException e) {
                                e.printStackTrace();
                            } catch (ClassNotFoundException e) {
                                e.printStackTrace();
                            }
                            // String nickFromDB = SQLHandler1.getNickByLogPass(tokens[1], tokens[2]);
                            System.out.println("Server " + str1);
                        }
                    }
                }
            });
            t1.start();

            //отправка клиент
            Thread t2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        System.out.println("Введите сообщение");
                        String str = console.nextLine();
                        System.out.println("Сообщение отправлено");
                        out.println(str);
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
        }
    }
    public static void  deSer(String s2) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Damir/src/home_work_3_3/111/stud.ser"));
        Students s2 = (Students)ois.readObject();
        try {
            ois.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        s2.info();
    }
}