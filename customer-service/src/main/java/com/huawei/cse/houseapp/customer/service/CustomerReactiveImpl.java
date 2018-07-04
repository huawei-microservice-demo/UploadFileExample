package com.huawei.cse.houseapp.customer.service;

import com.huawei.cse.houseapp.common.HelloReactive;
import org.apache.servicecomb.provider.pojo.RpcReference;
import org.apache.servicecomb.provider.rest.common.RestSchema;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.ws.rs.core.MediaType;
import java.util.concurrent.CompletableFuture;

/**
 * Created by j00347529 on 2018/6/15.
 */
@RestSchema(schemaId = "reactiveClient")
@RequestMapping(path = "/reactiveClient", produces = MediaType.APPLICATION_JSON)
public class CustomerReactiveImpl {

    @RpcReference(schemaId = "reactiveHello", microserviceName = "upload-service")
    private HelloReactive hello;

    @GetMapping(path = "/hello/{name}")
    public CompletableFuture<String> hello(@PathVariable(name = "name") String name){
        CompletableFuture<String> future = new CompletableFuture<>();
        hello.sayHello(name).whenComplete((result, exception) -> {
            if (exception == null) {
                future.complete("from remote: " + result);
                return;
            }

            future.completeExceptionally(exception);
        });
        return future;
    }
}
