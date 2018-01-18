package com.huawei.cse.houseapp.customer.service;

import org.apache.servicecomb.provider.rest.common.RestSchema;
import org.apache.servicecomb.swagger.invocation.context.ContextUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestSchema(schemaId = "customer")
@RequestMapping(path = "/")
public class CustomerServiceImpl {
  @GetMapping(path = "/context")
  public String getContext() {
    return ContextUtils.getInvocationContext().getContext("session_id");
  }

  @PostMapping(path = "/template")
  public Holder<Person> getHolder(@RequestBody Holder<Person> personHolder) {
    return personHolder;
  }
}
