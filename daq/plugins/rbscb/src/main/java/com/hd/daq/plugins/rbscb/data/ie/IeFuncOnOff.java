package com.hd.daq.plugins.rbscb.data.ie;

import io.netty.buffer.ByteBuf;
import lombok.Getter;

import java.io.InputStream;

/**
 * 断路器功能投退设定
 * @author ymm
 */
public class IeFuncOnOff extends RbIotInformationElement {
    @Getter
    private boolean overVoltageProtection;
    @Getter
    private boolean lowVoltageProtection;
    @Getter
    private boolean timeSwitch1;
    @Getter
    private boolean timeSwitch2;
    @Getter
    private boolean timeSwitch3;
    @Getter
    private boolean timeSwitch4;
    @Getter
    private boolean timeSwitch5;
    @Getter
    private boolean overloadAlarm;
    @Getter
    private boolean overCurrentAction;
    @Getter
    private boolean tempAlarm;
    @Getter
    private boolean tempAction;
    @Getter
    private boolean timeSwitch6;
    @Getter
    private boolean timeSwitch7;
    @Getter
    private boolean timeSwitch8;
    @Getter
    private boolean leakCurrentAlarm;
    @Getter
    private boolean leakCurrentAction;
    @Getter
    private boolean arcProtectAlarm;
    @Getter
    private boolean arcProtectAction;
    @Getter
    private boolean malignantLoadAlarm;
    @Getter
    private boolean malignantLoadAction;
    @Getter
    private boolean offUnlockMode;
    @Getter
    private boolean offWhenPowerOn;
    @Getter
    private boolean quickLeakCurrentAction;
    @Getter
    private boolean threePhaseUnbalanceAlarm;
    @Getter
    private boolean phaseLossAlarm;
    @Getter
    private boolean remoteLock;


    private IeFuncOnOff() {

    }
    public IeFuncOnOff(InputStream in) {
        decode(in);
    }

    public static IeFuncOnOff createInstance(Object params) {
        IeFuncOnOff ieFuncOnOff = new IeFuncOnOff();
        return ieFuncOnOff;
    }

    private void decode(InputStream in) {

    }

    @Override
    public int encode(ByteBuf buffer) {
        return 0;
    }

    @Override
    public String toString() {
        return null;
    }
}
