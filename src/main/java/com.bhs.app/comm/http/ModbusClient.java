package com.bhs.app.comm.http;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * modbus客户端
 * Created by ThinkPad on 2018/4/3.
 */
public class ModbusClient {

    private static Logger log = LoggerFactory.getLogger(ModbusClient.class);

    public static void main(String[] args) {
        try {
            //1.创建客户端Socket，指定服务器地址和端口
            Socket socket = new Socket("127.0.0.1",8888);
            //2.获取输出流,向服务端发送信息
            OutputStream os = socket.getOutputStream();//字节输出流
            PrintWriter pw = new PrintWriter(os);//将输出包装成打印流
            //定义一些客户端信息
            while (true){
                //3.获取输入流，并读取服务器端的响应信息
                InputStream is=socket.getInputStream();
                ByteArrayOutputStream result = new ByteArrayOutputStream();
                //获取查询指令
                byte [] b  =new byte[32];
                is.read(b);
                log.info("服务端返回数据: "+ServerThread.bytesToHexString(b));
                byte [] msg = {0x00,0x01,0x00,0x00,0x00,0x06,0x01,0x03,0x03,0x20,0x00,0x01};
                os.write(msg);
                os.flush();
            }
        }catch (UnknownHostException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
