package home_work_3_3;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {


        public Server() {
        }

        public static void main(String[] args) throws InterruptedException {
            try {
                ServerSocket server = new ServerSocket(3345);
                System.out.print("Waiting Client");
                System.out.println();
                Socket client = server.accept();
                System.out.println("Connection accepted.");
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                DataOutputStream out = new DataOutputStream(client.getOutputStream());
                DataInputStream in = new DataInputStream(client.getInputStream());
                while(true) {
                    String entry = in.readUTF();
                    System.out.println(entry);
                    out.writeUTF("");
                    String clientCommand = br.readLine();
                    out.writeUTF(clientCommand);
                    out.flush();
                    // String exit = br.readLine();
                    if (entry.equalsIgnoreCase("quit")) {
                        out.flush();
                        System.out.println("Client disconnected");
                        in.close();
                        out.close();
                        client.close();
                        System.out.println("Closing connections & channels - DONE.");
                        break;
                    }
                    out.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

