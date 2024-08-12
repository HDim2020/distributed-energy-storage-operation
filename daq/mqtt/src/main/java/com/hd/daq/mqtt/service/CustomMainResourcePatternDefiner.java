package com.hd.daq.mqtt.service;

import com.gitee.starblues.core.classloader.MainResourcePatternDefiner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * 设置主程序中的第三方依赖包与插件共享
 * @author ymm
 */
@Component
public class CustomMainResourcePatternDefiner implements MainResourcePatternDefiner {
    @Override
    public Set<String> getIncludePatterns() {
        // 包含包匹配
        Set<String> includePatterns = new HashSet<>();
        includePatterns.add("io/netty/**");
        return includePatterns;
    }

    @Override
    public Set<String> getExcludePatterns() {
        return null;
    }
}
