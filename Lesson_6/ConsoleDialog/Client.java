package Lesson_6.ConsoleDialog;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.io.PrintWriter;

public class Client {
    public static void main(String[] args) {
        final String SERVER_ADDR = "localhost";
        final int SERVER_PORT = 8189;
        Socket sock;
        Scanner in;
        PrintWriter out;
        Scanner console;
        try {
            sock = new Socket(SERVER_ADDR, SERVER_PORT);
            in = new Scanner(sock.getInputStream());
            out = new PrintWriter(sock.getOutputStream(),true);
            console=new Scanner(System.in);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        String strS = in.nextLine();
                        if (strS.equals("end")) break;
                        System.out.println("Сервер: " + strS);
                    }
                }
                }).start();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while (true) {
                            String str = console.nextLine();
                            out.println(str);
                            if (str.equals("end")) break;
                        }
                    }
                }).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
