package ChatApp;

import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer {

    private static final int PORT = 12345;
    private static Set<PrintWriter> clientWriters = Collections.synchronizedSet(new HashSet<>());

    public static void main(String[] args) {
        System.out.println("🔌 Chat Server started on port " + PORT);
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                Socket client = serverSocket.accept();
                System.out.println("✅ New client connected: " + client.getInetAddress());
                new ClientHandler(client).start();
            }
        } catch (IOException e) {
            System.out.println("Server Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    static class ClientHandler extends Thread {
        private Socket socket;
        private PrintWriter out;
        private BufferedReader in;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
                clientWriters.add(out);

                out.println("🎉 Welcome to the Chat Server!");
                String msg;
                while ((msg = in.readLine()) != null) {
                    System.out.println("📩 " + msg);
                    broadcast(msg);
                }

            } catch (IOException e) {
                System.out.println("Client disconnected: " + socket.getInetAddress());
            } finally {
                try {
                    if (out != null) clientWriters.remove(out);
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        private void broadcast(String message) {
            for (PrintWriter writer : clientWriters) {
                writer.println(message);
            }
        }
    }
}