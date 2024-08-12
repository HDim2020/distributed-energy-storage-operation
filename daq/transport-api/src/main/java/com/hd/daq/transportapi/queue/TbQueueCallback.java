package com.hd.daq.transportapi.queue;

/**
 * @author ymm
 */
public interface TbQueueCallback {

    void onSuccess(TbQueueMsgMetadata metadata);

    void onFailure(Throwable t);
}
