package net.utils;

import net.wire.module.DosModule;

/**
 * Created by GenericDNS on 16.12.2021.
 */
public class InputStreamScanner {

    final String[] commands;

    String server;

    String port;

    String threads;

    String threadBreakPoint = "1";

    public InputStreamScanner(String[] commands) {
        this.commands = commands;
        for (int i = 0; i <= 5; i++) {
            int remoteIndex = i+1;
            if (commands[i].equalsIgnoreCase("-s")) {
                this.server = commands[remoteIndex];
            } else if (commands[i].equals("-p")) {
                this.port = commands[remoteIndex];
            } else if (commands[i].equals("-t")) {
                this.threads = commands[remoteIndex];
            } else if (commands[i].equalsIgnoreCase("-tbp")) {
                this.threadBreakPoint = commands[remoteIndex];
            }
        }
        System.out.println(DosModule.getInstance().getPrefix() + "information | address: " + server + " | port: " + port + " | threads: " + threads + " | threadBreakPoint: " + threadBreakPoint);
    }
}
