package com.hd.daq.transportapi;

import com.hd.daq.transportapi.data.thing.ServiceRequestMsg;
import com.hd.daq.transportapi.proto.TransportProtos;

public interface SessionMsgListener {

    void onRemoteSessionCloseCommand(TransportProtos.SessionCloseNotificationProto sessionCloseNotification);

    void onServiceRequest(ServiceRequestMsg serviceMsg);
}
