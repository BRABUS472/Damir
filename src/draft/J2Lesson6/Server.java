package draft.J2Lesson6;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {

     try{
         //создать socket 12345
         ServerSocket serv_socket = new ServerSocket(12345);//создание точки соединения, что бы клиент мог соединиться
         System.out.println("Waiting for a new Client!");

         //открывание сервера для доступа(ПРИНЯТЬ соединие)
         Socket socket =serv_socket.accept();//Блокирует исполнение программы пока клиент не будет соединен

         System.out.println("A new client connected");

         Scanner input = new Scanner(socket.getInputStream());//будет получать с socket входной поток
         PrintWriter out = new PrintWriter(socket.getOutputStream()); //отправление в socket

         while (true){

             String str = input.nextLine();//получение строки

             System.out.println("A message from a Client: "+str);

             out.println("ECHO "+str);//сервер отправляет клиенту сообщение ЭХО

             out.flush();//опустошает буффер с данными (емкость буфера 8192 байта)

             if(str.equalsIgnoreCase("/end")){//завершение потока
                 break;
             }
         }
     }catch (IOException ex){
         System.out.println(ex.getStackTrace());
     }

    }
}
