package com.test.rpc.client;

import com.test.rpc.server.EchoService;
import com.test.rpc.server.RpcExporter;
import com.test.rpc.server.impl.EchoServiceImpl;

import java.net.InetSocketAddress;

/**
 * Created by zhangyaping on 18/7/15.
 */
public class Main {

    public static void main(String[] args) {
        new Thread(new Runnable() {
            public void run() {
                try {
                    RpcExporter.exporter("localhost", 8082);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        RpcImporter<EchoService> importer = new RpcImporter<EchoService>();
        EchoService echo = importer.importer(EchoServiceImpl.class, new InetSocketAddress("localhost", 8082));

        System.out.println(echo.echo("are you ok?"));
    }
}
