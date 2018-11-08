package Lesson_6.NetworkChat.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class Server {
    private Vector<ClientHendler> clients;
    public Server() {
        clients=new Vector<>();
        ServerSocket server=null;
        Socket socket=null;

        try {
            server=new ServerSocket(8189);
            System.out.println("Сервер запущен!");

            while (true){
                socket=server.accept();
                System.out.println("Клиент подключился!");
                ClientHendler client=new ClientHendler(this,socket);
                clients.add(client);
                int clientIndex=clients.size()-1;
                client.setIndexInVector(clientIndex);
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
        }
    }

    public void broadcastMsg(String msg){
        for (ClientHendler o:clients) {
            o.sendMsg(msg);
        }
    }

    public void removeClient(int index){
        clients.remove(index);
    }

}
