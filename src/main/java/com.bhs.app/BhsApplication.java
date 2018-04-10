package com.bhs.app;

import com.bhs.app.comm.http.ModbusServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BhsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BhsApplication.class, args);
		//启动tcp服务
		ModbusServer.startServer();
	}
}
