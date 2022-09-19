import java.net.*;
import java.io.*;


public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8000);
        System.out.println("Сервер запущен.");
        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Клиент подключился.");
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter( clientSocket.getOutputStream()));
            BufferedReader reader = new BufferedReader( new InputStreamReader(clientSocket.getInputStream()));
            String request = reader.readLine();
            System.out.println(request);
            String response = "16'";
            writer.write(response);
            writer.newLine();
            writer.flush();

            writer.close();
            reader.close();

            clientSocket.close();
        }
        //serverSocket.close();
    }
}
