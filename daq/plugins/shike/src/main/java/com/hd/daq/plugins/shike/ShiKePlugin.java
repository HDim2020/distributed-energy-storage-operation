package com.hd.daq.plugins.shike;

import com.gitee.starblues.bootstrap.SpringPluginBootstrap;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ymm
 */
@SpringBootApplication
public class ShiKePlugin extends SpringPluginBootstrap {

    public static void main(String[] args) {
        new ShiKePlugin().run(ShiKePlugin.class, args);
    }
}
