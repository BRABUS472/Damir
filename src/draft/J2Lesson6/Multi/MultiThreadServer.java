package draft.J2Lesson6.Multi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreadServer {

    //класс ExecutorService - ограничивает количество потоков
    static ExecutorService executeIt = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {

        //стартуем сервер на порту 3345 и инициализируем переменнуб для обработки
        try {
            ServerSocket server = new ServerSocket(3345);
            // BufferedReader-читает с консоли
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Server socket created, command console reader for listen to server commands");

            //Стартуем цикл при условии что серверный сокет не закрыт
            while (!server.isClosed()) {
                //проверяем поступившие комманды из консоли сервера
                if (br.ready()) {
                    System.out.println("Main Server found any messages in channel, let's look at them.");
                    //если комманда quit то инициализируем закрытие сервера и выход из цикла раздачи моонопоточных серверов
                    String serverCommand = br.readLine();
                    if (serverCommand.equalsIgnoreCase("quit")) {
                        System.out.println("Main Server initiate exiting...");
                        server.close();
                        break;
                    }
                }
                //если команды от сервера нет, то становимся в режим ожидания подключения к сокету общения под
                // именем - "clientDialog" на серверной стороне
                Socket client = server.accept();

                //после получения запроса на подключение сервер создает сокет для общения с клиентом и отправляет его в отдельную
                // нить в Runnable(При необходимости можно создать Callable)
                // монопоточную нить = сервер - MnoTreadClientHandler и тот продолжает общение от первого лица
                executeIt.execute(new MonoThreadClientHandler(client));
                System.out.print("Connection accepted.");
            }

            //закрытие пула нитий после завершения всех нитей
            executeIt.shutdown();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
