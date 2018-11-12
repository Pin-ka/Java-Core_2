package Lesson_7.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.Vector;

public class Server {
    private Vector<ClientHendler> clients;
    public Server() throws SQLException {
        clients=new Vector<>();
        ServerSocket server=null;
        Socket socket=null;

        try {
            AuthService.connect();
            server=new ServerSocket(8189);
            System.out.println("Сервер запущен!");

            while (true){
                socket=server.accept();
                System.out.println("Клиент подключился!");
                new ClientHendler(this,socket);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            AuthService.disconnect();
        }
    }

    public synchronized void subscribe(ClientHendler client){//добавление элемента в вектор
        clients.add(client);
    }

    public synchronized void unsubscribe(ClientHendler client){//удаление элемента из вектора
        clients.remove(client);
    }

    public synchronized void broadcastMsg(String msg){
        for (ClientHendler o:clients) {
            o.sendMsg(msg);
        }
    }
    public synchronized boolean isNickBusy(String nick) {
        for (ClientHendler o : clients) {
            if (o.getNick().equals(nick)) return true;
        }
        return false;
    }
    public synchronized void sendWhisper(String nickWriter, String nickReader,String msg){
        for (ClientHendler o : clients) {
            if (o.getNick().equals(nickReader) || o.getNick().equals(nickWriter)) {
                o.sendMsg(nickWriter+" (whisper to "+nickReader+"): "+msg);
            }
        }
    }
}
