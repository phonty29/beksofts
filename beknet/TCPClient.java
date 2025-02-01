import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TCPClient {
   public static void main(String ...args) {
        try (var socket = new Socket("127.0.0.1", 5374)) {
           System.out.println("Connection established..."); 
           var out = new PrintWriter(socket.getOutputStream(), true);
           out.println("SYN");

           var in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
           String msg = in.readLine();
           System.out.println(String.format("Response: %s", msg));
           if (msg != null && msg.contentEquals("SYN-ACK")) {
                System.out.println("TCP Server acknowledged");
           } else {
                System.out.println("TCP Server DID NOT acknowledged");
           }
        } catch (Exception e) {
            e.printStackTrace();
        }
   } 
}
