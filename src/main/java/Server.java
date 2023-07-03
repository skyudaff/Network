import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        int port = 8082;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server started");

            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))
                ) {
                    System.out.printf("New connection accepted. Port: %d %n", clientSocket.getPort());
                    out.println(String.format("Hi, your port is %d", clientSocket.getPort()));
                    out.println("Please, write your name: ");
                    String username = in.readLine();
                    out.println("Are you child? (yes/no)");
                    String answ = in.readLine();
                    if ("yes".equals(answ)) {
                    out.println(String.format("Welcome to the kids area, %s! Let's play!", username));
                    } else if ("no".equals(answ)) {
                        out.println(String.format("Welcome to the adult zone, %s! Have a good rest, or a good working day!", username));
                    } else out.println("Incorrect answer. Bye!");
                }
                System.out.println("Connection ended");
            }
        }
    }
}