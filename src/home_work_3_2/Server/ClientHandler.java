package home_work_3_2.Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.sql.SQLException;

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

            new Thread(()-> {

              try
                {
                    while(true)
                    {
                        String str = this.in.readUTF();
                        String[] tokens = str.split("\\s");

                        if (tokens[0].equals("/auth")) {
                            String nickFromDB = SQLHandler1.getNickByLogPass(tokens[1], tokens[2]);
                            if (nickFromDB != null) {
                                this.sendMsg("/authok");
                                server.add_client(this);
                                try {
                                    SQLArchive.connect();
                                    SQLArchive.createTableEx();
                                    //SQLArchive.dropTableEx();
                                    sendMsg(SQLArchive.readEx());
                                   //System.out.println(SQLArchive.readEx());

                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }

                                while (true) {
                                    str = this.in.readUTF();
                                    System.out.println("A message from a client: " + str);
                                    //String[] token = str.split("\\s");
                                    try {
                                        SQLArchive.insertEx(str);
                                    }  catch (SQLException e) {
                                        e.printStackTrace();
                                    }
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
            }).start();
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

//    public static void archiveDownland() throws SQLException {
//        SQLArchive.readEx();
//
//    }

}
