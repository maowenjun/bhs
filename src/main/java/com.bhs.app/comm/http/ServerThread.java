package com.bhs.app.comm.http;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;


/**
 * 服务器线程处理类
 * Created by ThinkPad on 2018/4/3.
 */
public class ServerThread extends Thread {

    private static Logger log = LoggerFactory.getLogger(ServerThread.class);

    // 和本线程相关的Socket
    Socket socket = null;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    //线程执行的操作，响应客户端的请求
    public void run(){
        InputStream is=null;
        InputStreamReader isr=null;
        BufferedReader br=null;
        OutputStream os=null;
        PrintWriter pw=null;
        boolean flag = true;//客户端连接标识
        try {
            InetSocketAddress socketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
            log.info("客户端地址  ："+socketAddress.getAddress()+":"+socketAddress.getPort());
            //获取输出流，响应客户端的请求
            os = socket.getOutputStream();
            //String msg = "00 01 00 00 00 06 01 03 03 20 00 01";
            byte [] msg = {0x00,0x01,0x00,0x00,0x00,0x06,0x01,0x03,0x03,0x20,0x00,0x01};
            os.write(msg);
            while (flag) {
                String info = null;
                //获取输入流，并读取客户端信息
                if (socket.isClosed()) {
                    flag = false;
                }
                is = socket.getInputStream();
               /* isr = new InputStreamReader(is);
                br = new BufferedReader(isr);
                while ((info = br.readLine()) != null) {//循环读取客户端的信息
                    log.info("我是服务器，客户端说：" + info);
                }*/
                //这个类就跟StringBuffer作用类似，可以动态的扩展字节数组的大小
                ByteArrayOutputStream result = new ByteArrayOutputStream();
                byte[] b = new byte[1];
                while (-1 != (is.read(b))) {
                        result.write(b);
                }
                if(result.size() > 0 ){
                    log.info("客户端返回数据: "+result.toByteArray());
                    String data = new String(result.toByteArray());
                    log.info("客户端返回数据: "+data);
                }
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //socket.shutdownInput();//关闭输入流
            //os.flush();
            //pw.flush();//调用flush()方法将缓冲输出
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        try {
            if(pw!=null)
                pw.close();
            if(os!=null)
                os.close();
            if(br!=null)
                br.close();
            if(isr!=null)
                isr.close();
            if(is!=null)
                is.close();
            if(socket!=null)
                socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static final String bytesToHexString(byte[] buf) {
        StringBuilder sb = new StringBuilder(buf.length * 2);
        String tmp = "";
        // 将字节数组中每个字节拆解成2位16进制整数
        for (int i = 0; i < buf.length; i++) {
            // 1.
            // sb.append(Integer.toHexString((buf[i] & 0xf0) >> 4));
            // sb.append(Integer.toHexString((buf[i] & 0x0f) >> 0));
            // //////////////////////////////////////////////////////////////////
            // 2.sodino更喜欢的方式，嘿嘿...
            tmp = Integer.toHexString(0xff & buf[i]);
            tmp = tmp.length() == 1 ? "0" + tmp : tmp;
            sb.append(tmp);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(bytesToHexString("0320".getBytes()));
    }
}
