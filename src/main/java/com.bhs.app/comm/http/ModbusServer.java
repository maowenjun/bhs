package com.bhs.app.comm.http;

import com.alibaba.fastjson.JSON;
import jdk.nashorn.internal.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * modbus 服务端
 * Created by ThinkPad on 2018/4/3.
 */
public class ModbusServer {

    private static Logger log = LoggerFactory.getLogger(ModbusServer.class);

    protected static volatile ConcurrentHashMap<String,Socket> aliveSocket = new ConcurrentHashMap();


    public static ScheduledExecutorService executorService = Executors
            .newScheduledThreadPool(4);

    public  static void startServer(){
        try {
            //1.创建一个服务器端Socket，即ServerSocket，指定绑定的端口，并监听此端口
            ServerSocket serverSocket=new ServerSocket(8888);
            Socket socket=null;
            //记录客户端的数量
            int count=0;
            log.info("***服务器即将启动，等待客户端的连接***");
            //循环监听等待客户端的连接
            while(true){
                //调用accept()方法开始监听，等待客户端的连接
                socket=serverSocket.accept();
                //创建一个新的线程
                aliveSocket.put(socket.getInetAddress().getHostAddress(),socket);
                MessageThread serverThread=new MessageThread(socket,true);
                //启动线程
                executorService.scheduleAtFixedRate(serverThread,0,5, TimeUnit.SECONDS);
                InetSocketAddress socketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
                String clientIp = socketAddress.getAddress().getHostAddress();
                log.error("客户端地址："+clientIp);
                log.error(JSON.toJSONString(aliveSocket));
                log.error("客户端的数量："+aliveSocket.size());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public static void main(String[] args) {
        //String clientIp = "/101.231.0.156";
        //System.out.println(clientIp.substring(1,clientIp.length()));
        startServer();
    }
}
