package Lesson_6.ConsoleDialog;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.io.PrintWriter;

public class Server {
    public static void main(String[] args) {
        ServerSocket serv = null;
        Socket sock;
        Scanner console;
        try {
            serv = new ServerSocket(8189);
            System.out.println("Сервер запущен, ожидаем подключения...");
            sock = serv.accept();
            System.out.println("Клиент подключился");
            Scanner sc = new Scanner(sock.getInputStream());
            PrintWriter pw = new PrintWriter(sock.getOutputStream(),true);
            console=new Scanner(System.in);

            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true){
                        String strK = sc.nextLine();
                        if (strK.equals("end")) break;
                        System.out.println("Клиент: " + strK);
                    }
                }
            }).start();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true){
                        String strS=console.nextLine();
                        pw.println(strS);
                        if (strS.equals("end")) break;
                    }
                }
            }).start();
        } catch (IOException e) {
            System.out.println("Ошибка инициализации сервера");
        } finally {
            try {
                serv.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
