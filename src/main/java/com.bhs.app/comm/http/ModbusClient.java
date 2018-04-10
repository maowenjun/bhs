package com.bhs.app.comm.http;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * modbus客户端
 * Created by ThinkPad on 2018/4/3.
 */
public class ModbusClient {

    public static void main(String[] args) {
        try {
            //1.创建客户端Socket，指定服务器地址和端口
            Socket socket = new Socket("localhost",8888);
            //2.获取输出流,向服务端发送信息
            OutputStream os = socket.getOutputStream();//字节输出流
            PrintWriter pw = new PrintWriter(os);//将输出包装成打印流
            //定义一些客户端信息
            pw.write("0x0001 0x1101");
            pw.flush();
            socket.shutdownOutput();//关闭输出流
            //3.获取输入流，并读取服务器端的响应信息
            InputStream is=socket.getInputStream();
            BufferedReader br=new BufferedReader(new InputStreamReader(is));
            String info=null;
            while((info=br.readLine())!=null){

                System.out.println("我是客户端，服务器说："+info);
            }
            //关闭资源
            br.close();
            is.close();
            pw.close();
            os.close();
            socket.close();
        }catch (UnknownHostException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
