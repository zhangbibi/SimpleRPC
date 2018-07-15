package com.test.rpc.server.impl;

import com.test.rpc.server.EchoService;

/**
 * Created by zhangyaping on 18/7/15.
 */
public class EchoServiceImpl implements EchoService {


    public String echo(String ping) {
        return ping != null ? ping + " --> I am ok." : " I am ok.";
    }
}
