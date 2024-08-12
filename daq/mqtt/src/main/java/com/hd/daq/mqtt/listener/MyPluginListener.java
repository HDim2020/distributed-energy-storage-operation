package com.hd.daq.mqtt.listener;

import com.gitee.starblues.core.PluginInfo;
import com.gitee.starblues.integration.listener.PluginListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.nio.file.Path;

/**
 * @author starBlues
 * @version 1.0
 */
@Component
public class MyPluginListener implements PluginListener {

    private static final Logger log = LoggerFactory.getLogger(MyPluginListener.class);

    @Override
    public void loadSuccess(PluginInfo pluginInfo) {
        log.info("插件[{}]加载成功.", pluginInfo.getPluginId());
    }

    @Override
    public void loadFailure(Path path, Throwable throwable) {
        log.info("插件[{}]加载失败. {}", path, throwable.getMessage());
    }

    @Override
    public void unLoadSuccess(PluginInfo pluginInfo) {
        log.info("插件[{}]卸载成功", pluginInfo.getPluginId());
    }

    @Override
    public void unLoadFailure(PluginInfo pluginInfo, Throwable throwable) {
        log.info("插件[{}]卸载失败. {}", pluginInfo.getPluginId(), throwable.getMessage());
    }

    @Override
    public void startSuccess(PluginInfo pluginInfo) {
        log.info("插件[{}]启动成功", pluginInfo.getPluginId());
    }

    @Override
    public void startFailure(PluginInfo pluginInfo, Throwable throwable) {
        log.info("插件[{}]启动失败. {}", pluginInfo.getPluginId(), throwable.getMessage());
    }

    @Override
    public void stopSuccess(PluginInfo pluginInfo) {
        log.info("插件[{}]停止成功", pluginInfo.getPluginId());
    }

    @Override
    public void stopFailure(PluginInfo pluginInfo, Throwable throwable) {
        log.info("插件[{}]停止失败. {}", pluginInfo.getPluginId(), throwable.getMessage());
    }
}
