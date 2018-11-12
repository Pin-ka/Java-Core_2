package Lesson_7.Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHendler {
    Socket socket=null;
    DataInputStream in;
    DataOutputStream out;
    Server server;
    String nick;

    public ClientHendler(Server server, Socket socket) {
        try {
            this.server=server;
            this.socket = socket;
            this.in = new DataInputStream(socket.getInputStream());
            this.out = new DataOutputStream(socket.getOutputStream());

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true){//Цикл для авторизации
                            String str = in.readUTF();
                            if (str.startsWith("/auth")){
                                String [] tokens=str.split(" ");
                                String newNick=AuthService.getNickByLoginAndPass(tokens[1],tokens[2]);
                                if (newNick!=null){
                                    if(!server.isNickBusy(newNick)){
                                        sendMsg("/authok");
                                        nick=newNick;
                                        server.subscribe(ClientHendler.this);
                                        break;
                                    }else sendMsg("Учетная запись уже используется");
                                } else {
                                    sendMsg("Неверный логин/пароль!");
                                }
                            }
                        }

                        while (true) {//Цикл для работы
                            String str = in.readUTF();
                            if (str.equals("/end")) {
                                out.writeUTF("/serverClosed");
                                break;
                            }
                            if (str.startsWith("/w")) {
                                String[] whisper = str.split(" ");
                                String strMsg=str.replace(whisper[0]+" "+whisper[1],"");
                                server.sendWhisper(nick, whisper[1],strMsg);

                            }else {
                                server.broadcastMsg(nick + ": " + str);
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {


                        try {
                            in.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        try {
                            out.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        try {
                            socket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        server.unsubscribe(ClientHendler.this);
                    }
                }
            }).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMsg(String msg){
        try {
            out.writeUTF(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getNick() {
        return nick;
    }
}
