package com.hd.daq.transportapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hd.daq.transportapi.scheduler.SchedulerComponent;
import lombok.Data;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
@Data
@Service
public abstract class TransportContext {

    protected final ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private TransportService transportService;
    @Autowired
    private SchedulerComponent scheduler;

    @Getter
    private ExecutorService executor;

    @PostConstruct
    public void init() {
        executor = Executors.newWorkStealingPool(50);
    }

    @PreDestroy
    public void stop() {
        if (executor != null) {
            executor.shutdownNow();
        }
    }
}
