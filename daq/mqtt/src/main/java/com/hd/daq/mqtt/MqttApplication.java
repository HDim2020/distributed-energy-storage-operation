package com.hd.daq.mqtt;

import com.gitee.starblues.loader.DevelopmentMode;
import com.gitee.starblues.loader.launcher.SpringBootstrap;
import com.gitee.starblues.loader.launcher.SpringMainBootstrap;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ymm
 */
@SpringBootApplication(scanBasePackages={"com.hd.daq"})
public class MqttApplication implements SpringBootstrap {

    public static void main(String[] args) {
        SpringMainBootstrap.launch(MqttApplication.class, args);
    }

    @Override
    public void run(String[] strings) throws Exception {
        SpringApplication.run(MqttApplication.class, strings);
    }

    @Override
    public String developmentMode() {
        return DevelopmentMode.ISOLATION;
    }
}
