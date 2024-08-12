package com.hd.daq.mqtt.listener;

import com.gitee.starblues.integration.listener.PluginInitializerListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author starBlues
 * @version 1.0
 */
@Component
@Slf4j
public class MyPluginInitializerListener implements PluginInitializerListener {

    public MyPluginInitializerListener() {
    }

    @Override
    public void before() {
        log.info("初始化之前");
    }

    @Override
    public void complete() {
        log.info("初始化完成");
    }

    @Override
    public void failure(Throwable throwable) {
        log.info("初始化失败:" + throwable.getMessage());
    }
}
