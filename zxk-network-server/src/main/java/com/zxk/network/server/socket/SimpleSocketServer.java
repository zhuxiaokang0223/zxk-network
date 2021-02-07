package com.zxk.network.server.socket;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/***************************************************/
  /* 
  Usage                : 简单Socket通信。 实现接收一次客户端发送消息
  Project name         : zxk-network
  Author               : zhuxk
  Mail                 : zhuxiaokang@wintelia.com
  Date                 : 2021-02-07 14:56
  Version              : 1.0
  Modification history :
      Date          Author          Version          Description
  ---------------------------------------------------------------
   2021-02-07       zhuxk             1.0             新建
  */

@Slf4j
public class SimpleSocketServer {


    public static void main(String[] args) throws IOException {
        int port = 11331;

        ServerSocket serverSocket = new ServerSocket(port);
        log.info("绑定并监听端口[{}]成功", port);
        log.info("等待客户端连接...");
        // 阻塞
        Socket socket = serverSocket.accept();
        log.info("成功获取连接");

        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int len;
        StringBuilder sb = new StringBuilder();
        while ((len = inputStream.read(bytes)) != -1) {
            //注意指定编码格式，发送方和接收方一定要统一，建议使用UTF-8
            sb.append(new String(bytes, 0, len,"UTF-8"));
        }
        log.info("客户端数据：{}", sb);
        inputStream.close();

        socket.close();
        serverSocket.close();

    }

}
