package home_work_3_3;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

        public Client() {
        }

        public static void main(String[] args) throws InterruptedException {
            try {
                Socket socket = new Socket("localhost", 3345);
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                DataOutputStream oos = new DataOutputStream(socket.getOutputStream());
                DataInputStream ois = new DataInputStream(socket.getInputStream());
                System.out.println("Client connected to socket.");
                while (true) {
                    String clientCommand = br.readLine();
                    oos.writeUTF(clientCommand);
                    oos.flush();

                    if (clientCommand.equalsIgnoreCase("quit")) {
                        System.out.println("Client kill connections");
                        break;
                    }

                    String in = ois.readUTF();
                    System.out.print(in);
                    oos.writeUTF("");
                    oos.flush();

                }
            } catch (UnknownHostException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }