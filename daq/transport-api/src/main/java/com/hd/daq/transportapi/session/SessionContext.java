package com.hd.daq.transportapi.session;

import java.util.UUID;

public interface SessionContext {

    UUID getSessionId();

    int nextMsgId();
}
