package com.zxk.network.client.socket;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/***************************************************/
  /* 
  Usage                : 支持接收多个连接
  Project name         : zxk-network
  Author               : zhuxk
  Mail                 : zhuxiaokang@wintelia.com
  Date                 : 2021-02-07 15:54
  Version              : 1.0
  Modification history :
      Date          Author          Version          Description
  ---------------------------------------------------------------
   2021-02-07       zhuxk             1.0             新建
   @Copyright(C)2008-2020: 华夏航空股份有限公司 All right Reserved.
  */

@Slf4j
public class SimpleMultSocketClient {

    public static void main(String[] args) throws IOException {
        // 要连接的服务端IP地址和端口
        String host = "127.0.0.1";
        int port = 11332;
        // 与服务端建立连接
        log.info("开始连接服务端");

        Socket socket = new Socket(host, port);

        log.info("连接服务端成功");

        // 建立连接后获得输出流
        OutputStream outputStream = socket.getOutputStream();
        for (int i =0; i < 10; i++) {

            String message="简单Socket通信。 实现接收一次客户端发送消息" + i;
            socket.getOutputStream().write(message.getBytes("UTF-8"));

        }

        outputStream.close();
        socket.close();

    }
}
