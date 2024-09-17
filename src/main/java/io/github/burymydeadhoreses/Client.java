package io.github.burymydeadhoreses;

import java.io.*;
import java.net.*;

public class Client {
    private final PrintWriter writer;
    private final BufferedReader reader;

    public Socket socket;

    public Client(InetSocketAddress address) throws IOException {

        socket = new Socket(address.getAddress(), address.getPort());

        InputStream stream = socket.getInputStream();
        reader = new BufferedReader(new InputStreamReader(stream));
        writer = new PrintWriter(socket.getOutputStream(), true);
    }

    public void writeLine(String message) {
        writer.println(message);
    }

    public String readLine() throws IOException {
        return reader.readLine();
    }
}

