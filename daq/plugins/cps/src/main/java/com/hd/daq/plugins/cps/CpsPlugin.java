package com.hd.daq.plugins.cps;

import com.gitee.starblues.bootstrap.SpringPluginBootstrap;
import com.hd.daq.mqtt.MqttApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CpsPlugin extends SpringPluginBootstrap {

    public static void main(String[] args) {
        new CpsPlugin().run(MqttApplication.class, args);
    }

}
