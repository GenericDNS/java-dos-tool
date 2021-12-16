package net.wire.module;

import net.utils.InputStreamScanner;
import net.utils.NetworkService;
import net.wire.bootstrap.BootstrapComponent;

/**
 * Created by GenericDNS on 16.12.2021.
 */
public class DosModule implements BootstrapComponent {

    private static DosModule instance;

    private InputStreamScanner inputStreamScanner;

    public void enable(String[] args) {

        instance = this;

        this.inputStreamScanner = new InputStreamScanner(args);
        new NetworkService(this.inputStreamScanner);

    }

    public static DosModule getInstance() {
        return instance;
    }

    public String getPrefix() {
        return "» wire-dos ┃ ";
    }

    public InputStreamScanner getInputStreamScanner() {
        return inputStreamScanner;
    }
}
