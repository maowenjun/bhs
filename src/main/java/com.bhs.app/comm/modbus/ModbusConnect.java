package com.bhs.app.comm.modbus;

import com.digitalpetri.modbus.codec.Modbus;
import com.digitalpetri.modbus.master.ModbusTcpMaster;
import com.digitalpetri.modbus.master.ModbusTcpMasterConfig;
import com.digitalpetri.modbus.requests.ReadCoilsRequest;
import com.digitalpetri.modbus.requests.ReadDiscreteInputsRequest;
import com.digitalpetri.modbus.requests.ReadHoldingRegistersRequest;
import com.digitalpetri.modbus.requests.ReadInputRegistersRequest;
import com.digitalpetri.modbus.responses.ReadCoilsResponse;
import com.digitalpetri.modbus.responses.ReadDiscreteInputsResponse;
import com.digitalpetri.modbus.responses.ReadHoldingRegistersResponse;
import com.digitalpetri.modbus.responses.ReadInputRegistersResponse;
import io.netty.buffer.ByteBuf;
import io.netty.util.ReferenceCountUtil;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * Created by ThinkPad on 2018/4/10.
 */
public class ModbusConnect {

    private ModbusTcpMaster master;

    public ModbusConnect() {

    }


    public ModbusConnect(ModbusTcpMaster master) {
        this.master = master;
    }

    public ModbusTcpMaster getMaster() {
        return master;
    }

    public void setMaster(ModbusTcpMaster master) {
        this.master = master;
    }



    public void init(String ip,int port){
        if (master == null) {
            // 创建配置
            ModbusTcpMasterConfig config = new ModbusTcpMasterConfig.Builder(ip).setPort(port).build();
            master = new ModbusTcpMaster(config);
        }
    }


    /***
     * 释放资源
     */
    public  void release() {
        if (master != null) {
            master.disconnect();
        }
        Modbus.releaseSharedResources();
    }

    /**
     * 读取HoldingRegister数据
     *
     * @param address
     *            寄存器地址
     * @param quantity
     *            寄存器数量
     * @param unitId
     *            id
     * @return 读取结果
     * @throws InterruptedException
     *             异常
     * @throws ExecutionException
     *             异常
     */
    public  Number readHoldingRegisters(int address, int quantity, int unitId)
            throws InterruptedException, ExecutionException {
        Number result = null;
        CompletableFuture<ReadHoldingRegistersResponse> future = master
                .sendRequest(new ReadHoldingRegistersRequest(address, quantity), unitId);
        ReadHoldingRegistersResponse readHoldingRegistersResponse = future.get();// 工具类做的同步返回.实际使用推荐结合业务进行异步处理
        if (readHoldingRegistersResponse != null) {
            ByteBuf buf = readHoldingRegistersResponse.getRegisters();
            result = buf.readFloat();
            ReferenceCountUtil.release(readHoldingRegistersResponse);
        }
        return result;
    }

    /**
     * 读取InputRegisters模拟量数据
     *
     * @param address
     *            寄存器开始地址
     * @param quantity
     *
     * @param unitId
     *            ID
     * @return 读取值
     * @throws InterruptedException
     *             异常
     * @throws ExecutionException
     *             异常
     */
    public  Number readInputRegisters(int address, int quantity, int unitId)
            throws InterruptedException, ExecutionException {
        Number result = null;
        CompletableFuture<ReadInputRegistersResponse> future = master
                .sendRequest(new ReadInputRegistersRequest(address, quantity), unitId);
        ReadInputRegistersResponse readInputRegistersResponse = future.get();// 工具类做的同步返回.实际使用推荐结合业务进行异步处理
        if (readInputRegistersResponse != null) {
            ByteBuf buf = readInputRegistersResponse.getRegisters();
            result = buf.readInt();
            ReferenceCountUtil.release(readInputRegistersResponse);
        }
        return result;
    }

    /**
     * 读取Coils开关量
     *
     * @param address
     *            寄存器开始地址
     * @param quantity
     *            数量
     * @param unitId
     *            ID
     * @return 读取值
     * @throws InterruptedException
     *             异常
     * @throws ExecutionException
     *             异常
     */
    public  Boolean readCoils(int address, int quantity, int unitId)
            throws InterruptedException, ExecutionException {
        Boolean result = null;
        CompletableFuture<ReadCoilsResponse> future = master.sendRequest(new ReadCoilsRequest(address, quantity),
                unitId);
        ReadCoilsResponse readCoilsResponse = future.get();// 工具类做的同步返回.实际使用推荐结合业务进行异步处理
        if (readCoilsResponse != null) {
            ByteBuf buf = readCoilsResponse.getCoilStatus();
            result = buf.readBoolean();
            ReferenceCountUtil.release(readCoilsResponse);
        }
        return result;
    }

    /**
     * 读取readDiscreteInputs开关量
     *
     * @param address
     *            寄存器开始地址
     * @param quantity
     *            数量
     * @param unitId
     *            ID
     * @return 读取值
     * @throws InterruptedException
     *             异常
     * @throws ExecutionException
     *             异常
     */
    public  Boolean readDiscreteInputs(int address, int quantity, int unitId)
            throws InterruptedException, ExecutionException {
        Boolean result = null;
        CompletableFuture<ReadDiscreteInputsResponse> future = master
                .sendRequest(new ReadDiscreteInputsRequest(address, quantity), unitId);
        ReadDiscreteInputsResponse discreteInputsResponse = future.get();// 工具类做的同步返回.实际使用推荐结合业务进行异步处理
        if (discreteInputsResponse != null) {
            ByteBuf buf = discreteInputsResponse.getInputStatus();
            result = buf.readBoolean();
            ReferenceCountUtil.release(discreteInputsResponse);
        }
        return result;
    }

    public static void main(String[] args) {
        try {
            // 初始化资源
            //initModbusTcpMaster();
            // 执行操作
            // 读取模拟量
            //System.out.println(readHoldingRegisters(0, 4, 1));
            //System.out.println(readInputRegisters(101, 2, 1));

            // 读取开关量
           /* System.out.println(readCoils(0, 1, 1));
            System.out.println(readDiscreteInputs(0, 1, 1));
            System.out.println(readDiscreteInputs(2, 1, 1));*/

            // 释放资源
            //release();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
