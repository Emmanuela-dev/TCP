import java.io.*;
import java.net.*;
import java.util.Scanner;

public class TCPClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 9090);
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the radius of the circle: ");
        double radius = scanner.nextDouble();

         //autoflash functionality enables it to send the data
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        out.println(radius);
         //reads a string from the keyboard
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        //method that waits for the user to enter a string
        String response = in.readLine();
        System.out.println("Response from server: " + response);

        socket.close();
    }
}