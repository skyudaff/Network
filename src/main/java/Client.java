import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


public class Client {
    public static void main(String[] args) {
        String localhost = "netology.homework";
        int port = 8082;

        try (Scanner sc = new Scanner(System.in);
             Socket clientSocket = new Socket(localhost, port);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(
                     new InputStreamReader(clientSocket.getInputStream()))
        ) {
            System.out.println(in.readLine());
            System.out.println(in.readLine());
            out.println(sc.nextLine());
            System.out.println(in.readLine());
            out.println(sc.nextLine());
            System.out.println(in.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
