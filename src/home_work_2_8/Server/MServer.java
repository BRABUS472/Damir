package home_work_2_8.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Iterator;
import java.util.Vector;

public class MServer {
    private Vector<ClientHandler> clients;

    public MServer() {
        try {
            ServerSocket serv_socket = new ServerSocket(12345);
            this.clients = new Vector();
            SQLHandler1.connect();

            while (true) {
                System.out.println("Waiting for a new client!");
                Socket socket = serv_socket.accept();
                new ClientHandler(this, socket);
            }
        } catch (IOException var4) {
            var4.printStackTrace();
        }
    }

    public void add_client(ClientHandler client) {
        this.clients.add(client);
        System.out.println("add client");
    }

    public void remove_client(ClientHandler client) {
        this.clients.remove(client);
    }

    public void broadcastMsg(String msg) {
        Iterator var2 = this.clients.iterator();

        while (var2.hasNext()) {
            ClientHandler client = (ClientHandler) var2.next();
            client.sendMsg(msg);
        }

    }
}
