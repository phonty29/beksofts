import java.io.*;
import java.net.*;

public class TCPServer {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(5374)) {
            System.out.println("TCPServer started on port 5374...");

            while (true) {
                var socket = serverSocket.accept(); 
                System.out.println(String.format("Connected: %s", socket.getInetAddress()));

                var in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                var out = new PrintWriter(socket.getOutputStream(), true);

                String msg = in.readLine(); 
                System.out.println(String.format("client message: %s",  msg));

                if (msg.contentEquals("SYN")) {
                    out.println("SYN-ACK"); 
                } else {
                    out.println("Unknown command");
                }
                socket.close(); 
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}