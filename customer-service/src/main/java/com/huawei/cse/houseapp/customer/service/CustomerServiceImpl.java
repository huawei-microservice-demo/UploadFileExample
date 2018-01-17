package com.huawei.cse.houseapp.customer.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import io.servicecomb.provider.rest.common.RestSchema;
import io.servicecomb.swagger.invocation.context.ContextUtils;

@RestSchema(schemaId = "customer")
@RequestMapping(path = "/")
public class CustomerServiceImpl {
  @GetMapping(path = "/context")
  public String getContext() {
    return ContextUtils.getInvocationContext().getContext("session_id");
  }
}
