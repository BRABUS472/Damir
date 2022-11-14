package draft.J2Lesson6;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serv_socket = new ServerSocket(12345);
            System.out.println("Waiting for a new Client.");

            Socket socket = serv_socket.accept();//.accept()-принять соединение, ставит на паузу

            System.out.println("A new Client connected.");

            Scanner input = new Scanner(socket.getInputStream());
            PrintWriter out = new PrintWriter(socket.getOutputStream());

            while (true){

                String str = input.nextLine();//получить строку из сканнера

                System.out.println("A message from a client"+str);

                out.println("ECHO"+str);//сервер отправляет клиенту эхо

                out.flush();

                if(str.equalsIgnoreCase("end")){
                    break;


                }
            }

        }catch (IOException ex){
            System.out.println(ex.getStackTrace());
        }
    }
}
