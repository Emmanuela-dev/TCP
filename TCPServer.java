import java.io.*;
import java.net.*;

public class TCPServer {
    public static void main(String[] args) throws IOException {
        //server socket object 
        //port number identifies application on network
        ServerSocket serverSocket = new ServerSocket(9090);
        System.out.println("Server is running and waiting for client connection...");
         //waits for client connection
        Socket clientSocket = serverSocket.accept();
        System.out.println("Client connected!");

         //reads the string the client has sent from the socket
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        double radius = Double.parseDouble(in.readLine());

        double area = Math.PI * radius * radius;
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        out.println("The area of the circle is: " + area);

        clientSocket.close();
        serverSocket.close();
    }
}