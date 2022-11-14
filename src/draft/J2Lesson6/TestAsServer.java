package draft.J2Lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TestAsServer {
    public static void main(String[] args) throws InterruptedException {
        //Стартуем сервер на порте 3345
        try (ServerSocket server = new ServerSocket(12345)){
            //ожидаем подключение к сокету под именем "client"
            Socket client = server.accept();

            //после подключения сервер ассоциирует подлючающегося клиента
            System.out.println("Connection accepted.");
             //инициалимзируем каналы для общения в сокете, для сервера
            //канал  записи в сокете
            DataOutputStream out = new DataOutputStream(client.getOutputStream());
            System.out.println("DataOutputStream created");

            //канал чтения из сокета
            DataInputStream in = new DataInputStream(client.getInputStream());
            System.out.println("DataInputStream created");

            //Начинаем диалог с подклбчением клиента в цикле, пока сокет не закрыт
            while (true){

                System.out.println("Server reading from channel");

                //Сервер ждет в канале чтения (inputstream) получения данных клиента. readUTF-читает символы
                String entry = in.readUTF();

                //после получения данных считывает их
                System.out.println("Read from client message - "+entry);

                //и выводит в консоль
                System.out.println("Server try writing to channel");

                //инициализация проверки условия продолжения работы с клиентом по этому сокету по кодовому слову - quit
                if(entry.equalsIgnoreCase("quit")){
                    System.out.println("Client initialize connections suicide ...");
                    out.writeUTF("server reply - "+entry+" OK");
                    out.flush();
                    break;

                }

            //если условие окончания работы не верно- продолжаем работу-отправляем эхо ответ обратно клиенту
           out.writeUTF("server reply - "+entry+" OK");
           out.flush();
                System.out.println("Server Wrote message to client");

                //освобождаем буфер сетевых сообщений
                out.flush();
            }
            //если условия выхода верно, выключаем соединение
            System.out.println("Client disconnected");
            System.out.println("Closing connections & channels.");

            //закерваем сначала канал сокета!
            in.close();
            out.close();

            //потом закрываем сам сокет общения на стороне сервера
            client.close();

            System.out.println("Closing connections & channels - DONE.");

        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
