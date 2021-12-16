package net.wire.bootstrap;

import net.wire.module.DosModule;

/**
 * Created by GenericDNS on 16.12.2021.
 */
public class BootstrapExecutor {

    public static void main(String[] args) {

        BootstrapComponent component = new DosModule();
        component.enable(args);

    }

}
