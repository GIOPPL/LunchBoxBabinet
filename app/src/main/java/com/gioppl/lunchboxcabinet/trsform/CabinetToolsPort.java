package com.gioppl.lunchboxcabinet.trsform;

import com.jackiepenghe.serialportlibrary.OnSerialPortDataChangedListener;
import com.jackiepenghe.serialportlibrary.SerialPortManager;

public class CabinetToolsPort {
    private static CabinetToolsPort cabinetToolsPort;
    private CabinetToolsPort(){}
    public static CabinetToolsPort getInstance(){
        if (cabinetToolsPort==null)
            cabinetToolsPort=new CabinetToolsPort();
        return cabinetToolsPort;
    }
    //打开餐盒
    public static String OPEN_BOX_HEAD="open*id=";
    public PortCallback callback;

    public void init(String port, final PortCallback callback){
        SerialPortManager.openSerialPort(port,115200);
        this.callback=callback;
        SerialPortManager.setOnSerialPortDataChangedListener(new OnSerialPortDataChangedListener() {
            @Override
            public void serialPortDataReceived(byte[] data, int size) {
                String originalData=new String(data,0,size);
                callback.result(originalData);
            }
        });
    }
    public void init(final PortCallback callback){
        SerialPortManager.openSerialPort("/dev/ttyS1",115200);
        this.callback=callback;
        SerialPortManager.setOnSerialPortDataChangedListener(new OnSerialPortDataChangedListener() {
            @Override
            public void serialPortDataReceived(byte[] data, int size) {
                String originalData=new String(data,0,size);
                callback.result(originalData);
            }
        });
    }
    /**
     * 获取分配餐盒标志
     * 返回设备编号
     */
    public void openBox(String deviceId){//"open*id=001#"
        SerialPortManager.writeData(OPEN_BOX_HEAD+deviceId+"#");
    }

    public interface PortCallback{
        void result(String result);
    }
}
