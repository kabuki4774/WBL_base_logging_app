package edu.uri.egr.wiot468template;

public class UartEvent {
    public byte type;
    public float[] data;


    public UartEvent(byte type, float[] data) {
        this.type = type;
        this.data = data;
    }
}
