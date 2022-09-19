import java.io.*;
import java.net.Socket;

public class CLient {
    public static void main(String[] args) throws IOException {
        Socket clientSocket = new Socket("192.168.0.107", 8000);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter( clientSocket.getOutputStream()));
        BufferedReader reader = new BufferedReader( new InputStreamReader(clientSocket.getInputStream()));

        writer.write("Сколько градусов на улице?");
        System.out.println();
        writer.newLine();
        writer.flush();
        String response = reader.readLine();
        System.out.println(response);

        writer.close();
        reader.close();
        clientSocket.close();
    }
}
