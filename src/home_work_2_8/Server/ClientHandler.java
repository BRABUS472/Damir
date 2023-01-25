package home_work_2_8.Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Timer;
import java.util.TimerTask;

public class ClientHandler {
    private MServer server;
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private String nickname;

    public ClientHandler(MServer server, Socket socket) {
        try {
            this.server = server;
            this.socket = socket;
            this.in = new DataInputStream(socket.getInputStream());
            this.out = new DataOutputStream(socket.getOutputStream());
            long time = System.currentTimeMillis();
            (new Thread(() -> {
                try {
                    while (true) {
                        System.out.println("------" + System.currentTimeMillis());

                        TimerTask task = new TimerTask() {
                            public void run() {
                                System.out.println("Время вышло");
                                sendMsg("/TimeOver");
                                try {
                                    socket.close();
                                } catch (IOException var19) {
                                    var19.printStackTrace();
                                }
                                return;
                            }
                        };
                        Timer timer = new Timer("Timer");
                        long delay = 120000L;
                        timer.schedule(task, delay);

                        String str = this.in.readUTF();
                        String[] tokens = str.split("\\s");

                        if (tokens[0].equals("/auth")) {
                            String nickFromDB = SQLHandler1.getNickByLogPass(tokens[1], tokens[2]);
                            if (nickFromDB != null) {
                                timer.cancel();
                                this.sendMsg("/authok");
                                server.add_client(this);

                                while (true) {
                                    str = this.in.readUTF();
                                    System.out.println("A message from a client: " + str);
                                    if (str.equalsIgnoreCase("/end")) {
                                        return;
                                    }
                                    server.broadcastMsg(str);
                                    this.out.flush();
                                }
                            }
                        }
                    }
                } catch (IOException var22) {
                    var22.printStackTrace();
                } finally {
                    try {
                        this.in.close();
                    } catch (IOException var21) {
                        var21.printStackTrace();
                    }
                    try {
                        this.out.close();
                    } catch (IOException var20) {
                        var20.printStackTrace();
                    }
                    try {
                        socket.close();
                    } catch (IOException var19) {
                        var19.printStackTrace();
                    }
                    server.remove_client(this);
                }
            })).start();
        } catch (IOException var4) {
            var4.printStackTrace();
        }
    }

    public void sendMsg(String msg) {
        try {
            this.out.writeUTF(msg);
        } catch (IOException var3) {
            var3.printStackTrace();
        }
    }


}
