package com.hd.daq.plugins.rbscb;

import com.gitee.starblues.bootstrap.SpringPluginBootstrap;
import com.hd.daq.mqtt.MqttApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ymm
 */
@SpringBootApplication
public class RbscbPlugin extends SpringPluginBootstrap {

    public static void main(String[] args) {
        new RbscbPlugin().run(MqttApplication.class, args);
    }

}
