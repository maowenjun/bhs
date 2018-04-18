package com.bhs.app.comm.http;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.TimerTask;

/**
 * Created by ThinkPad on 2018/4/17.
 */
public class MessageThread extends TimerTask{

    private static Logger log = LoggerFactory.getLogger(MessageThread.class);

    private Socket socket;

    private boolean isAlive;

    public MessageThread(Socket socket, boolean isAlive) {
        this.socket = socket;
        this.isAlive = isAlive;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    @Override
    public void run() {
        String key = "";
        //接收消息
        while (isAlive){
            InputStream is = null;
            OutputStream os=null;
            try{
                //获取key
                key = socket.getInetAddress().getHostAddress();
                if(socket.isClosed()){
                    isAlive = false;
                    log.error("客户端: "+key+"  断开了连接");
                }else{
                    os = socket.getOutputStream();
                    is = socket.getInputStream();
                    //String msg = "00 01 00 00 00 06 01 03 03 20 00 01";
                    byte[] sendInfo = new byte[] { 0x00, 0x07, 0x00, 0x00, 0x00, 0x06, 0x01, 0x03,0x03, 0x20, 0x00, 0x01 };  //发送给Modbus Slave软件的消息
                    os.write(sendInfo);
                    os.flush();
                    byte[] bs = new byte[32];
                    is.read(bs);
                    String result =  ServerThread.bytesToHexString(bs);  //输出十六进制
                    log.error("取到客户端数据："+result);
                }
            }catch (IOException e) {
                e.printStackTrace();
            } finally {

                    try {
                        if(is != null){
                            is.close();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

            }
        }
        //移除断开连接socket
        if(!StringUtils.isEmpty(key)){
            ModbusServer.aliveSocket.remove(key);
            if(socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
