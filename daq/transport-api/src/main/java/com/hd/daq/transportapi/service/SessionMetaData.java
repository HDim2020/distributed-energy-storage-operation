package com.hd.daq.transportapi.service;

import com.hd.daq.transportapi.SessionMsgListener;
import com.hd.daq.transportapi.proto.TransportProtos;
import lombok.Data;

import java.util.concurrent.ScheduledFuture;

@Data
public class SessionMetaData {

    private volatile TransportProtos.SessionInfoProto sessionInfo;
    private final TransportProtos.SessionType sessionType;
    private final SessionMsgListener listener;

    private volatile ScheduledFuture scheduledFuture;
    private volatile long lastActivityTime;
    private volatile long lastReportedActivityTime;
    private volatile boolean overwriteActivityTime;

    SessionMetaData(TransportProtos.SessionInfoProto sessionInfo, TransportProtos.SessionType sessionType, SessionMsgListener listener) {
        this.sessionInfo = sessionInfo;
        this.sessionType = sessionType;
        this.listener = listener;
        this.lastActivityTime = System.currentTimeMillis();
        this.scheduledFuture = null;
    }

    void updateLastActivityTime() {
        this.lastActivityTime = System.currentTimeMillis();
    }

    void setScheduledFuture(ScheduledFuture scheduledFuture) {
        this.scheduledFuture = scheduledFuture;
    }

    public ScheduledFuture getScheduledFuture() {
        return scheduledFuture;
    }

    public boolean hasScheduledFuture() {
        return null != this.scheduledFuture;
    }
}
