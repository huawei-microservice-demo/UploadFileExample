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
    Person p = personHolder.getData();
    System.out.println(p.getName());
    return personHolder;
  }

  @PostMapping(path = "/templateHolderHolder")
  public Holder<Person> getHolderHolderHolder(@RequestBody Holder<Holder<Person>> personHolder) {
    Person p = personHolder.getData().getData();
    System.out.println(p.getName());
    return personHolder.getData();
  }

  @PostMapping(path = "/templateLong")
  public Holder<Long> getHolderLong(@RequestBody Holder<Long> personHolder) {
    Long a = new Long(personHolder.getData().longValue());
    return new Holder<Long>(a);
  }

  @PostMapping(path = "/templateWrapped")
  public WapperHolder getHolderWrapped(@RequestBody WapperHolder personHolder) {
    Holder<Person> tt = personHolder;
    Person p = tt.getData();
    System.out.println(p.getName());
    return personHolder;
  }
}
