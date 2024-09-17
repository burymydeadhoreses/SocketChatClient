package io.github.burymydeadhoreses;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Scanner;

public class Main {
    static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        var address = new InetSocketAddress("127.0.0.1",25565);

        var client = new Client(address);

        new Thread(() -> {
            while (true) {
                try {
                    String message = client.readLine();
                    if (message != null && !message.isEmpty()) {
                        System.out.println(message);
                    }
                } catch (IOException e) {
                    e.fillInStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            while (true) {
                var input = scanner.nextLine();
                client.writeLine(input);
            }
        }).start();
    }
}