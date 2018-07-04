package com.huawei.cse.houseapp.common;

import java.util.concurrent.CompletableFuture;

/**
 * Created by j00347529 on 2018/6/15.
 */
public interface HelloReactive {
    CompletableFuture<String> sayHello(String hello);
}
