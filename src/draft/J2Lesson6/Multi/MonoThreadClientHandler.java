package draft.J2Lesson6.Multi;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class MonoThreadClientHandler implements Runnable {

    private static Socket clientDialog;

    public MonoThreadClientHandler(Socket client) {
        MonoThreadClientHandler.clientDialog = client;
    }

    @Override
    public void run() {

        try {
            //Инициируем каналы общения в сокете, для сервера

            //Канал записи в сокет следует инициалиизировать сначала канал чтения
            DataOutputStream out = new DataOutputStream(clientDialog.getOutputStream());

            //канал чтения из слкета
            DataInputStream in = new DataInputStream(clientDialog.getInputStream());
            System.out.println("DataInputStream created");

            System.out.println("DataOutStream created");

            //Начинаем диалог с подключением клиента в цикле, пока сокет не закрыт клиентом
            while (!clientDialog.isClosed()) {
                System.out.println("Server reading from channel");

                //серверная нить ждет в канале чтения (inputstream) получения данных клиента, после получения считывает их
                String entry = in.readUTF();

                // и выводит в консоль
                System.out.println("Read from clientDialog message - " + entry);

                //Инициализация проверкаи условия продолжения работы с клиентом
                // по этому сокету по кодовому слову -quit в любом регистре
                if (entry.equalsIgnoreCase("quit")) {

                    //усли слово получени, то инициализируем закрытия серверной нити
                    System.out.println("Client initialize connections suicide...");
                    out.writeUTF("Server reply -" + entry + "-OK");
                    Thread.sleep(3000);
                    break;
                }

                //если условие окончания работы не верно- продолжаем работу, отправляем эхо клиенту

                System.out.println("Server try writing to channel");
                out.writeUTF("Server reply - " + entry + "- OK");
                System.out.println("Server Wrote message to clientDialog");

                //Освобождаме буфер сетевых сообщений
                out.flush();

                //возвращаем в начало для считывания нового сообщения
            }

            //если условие выхода - верно выключаем соединения
            System.out.println("Client disconnected");
            System.out.println("Closing connections and channels");

            //Закрываем каналы сокета(Освобождаем ресурсы)
            in.close();
            out.close();

            //потом закрываем сокет общения с клиентом в нити моносервера
            clientDialog.close();
            System.out.println("Closing connections and channels - Done");

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
