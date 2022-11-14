package home_work2_6;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    public Client() {
    }

    public static void main(String[] args) throws InterruptedException {
        try {
            Socket socket = new Socket("localhost", 12345);
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            DataOutputStream oos = new DataOutputStream(socket.getOutputStream());
            DataInputStream ois = new DataInputStream(socket.getInputStream());

                            System.out.println("Client connected to socket.");
                            System.out.println();
                            System.out.println("Client writing channel = oos & reading channel = ois initialized.");

                            while(true) {
                                while(!br.ready()) {
                                }

                                System.out.println("Client start writing in channel...");
                                Thread.sleep(1000L);
                                String clientCommand = br.readLine();
                                oos.writeUTF(clientCommand);
                                oos.flush();
                                System.out.println("Client sent message " + clientCommand + " to server.");
                                Thread.sleep(1000L);
                                if (clientCommand.equalsIgnoreCase("quit")) {
                                    System.out.println("Client kill connections");
                                    System.out.println("Closing connections & channels on clentSide - DONE.");
                                    break;
                                }

                                System.out.println("Client sent message & start waiting for data from server...");
                                Thread.sleep(2000L);
                                System.out.println("reading...");
                                String in = ois.readUTF();
                                System.out.println(in);
                            }
                        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
