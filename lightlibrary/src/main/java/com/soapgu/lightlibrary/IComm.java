package com.soapgu.lightlibrary;

/**
 * 通信接口
 */
public interface IComm {
    void open();
    void close();
    void send(byte[] body);
}
