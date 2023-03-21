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
            PrintWriter out = new PrintWriter(socket.getOutputStream());


            Scanner console = new Scanner(System.in);

            Thread t1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        String str = sc.nextLine();
                        if (str.equals("/end")) break;
                        if (str.equals("/ser")) {
                            SerServer();
                            System.out.println("сериализация");
                        }
                        System.out.println("Client " + str);
                        out.println("echo " + str);
                    }

                }
                public void SerServer() {
                    Students students = new Students(1, "Bob");
                    ObjectOutputStream oos = null;
                    try {
                        oos = new ObjectOutputStream(new FileOutputStream("Damir/src/home_work_3_3/stud.ser"));
                        oos.writeObject(students);
                        oos.close();
                    } catch (IOException e) {
                        System.out.println("не удалось сериализовать");;
                    }
                }

            });

            t1.start();
//
//            Thread t2 = new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    while (true) {
//                        System.out.println("Введите сообщение");
//                        String str = console.nextLine();
//                        System.out.println("Сообщение отправлено");
//                        out.println(str);
//                    }
//
//                }
//            });
//
//            t2.setDaemon(true);
//            t2.start();


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
}



