package com.hd.daq.plugins.hdlink;

import com.gitee.starblues.bootstrap.SpringPluginBootstrap;
import com.hd.daq.mqtt.MqttApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ymm
 */
@SpringBootApplication
public class HdLinkPlugin extends SpringPluginBootstrap {

    public static void main(String[] args) {
        new HdLinkPlugin().run(MqttApplication.class, args);
    }
}
