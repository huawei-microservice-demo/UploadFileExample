package com.huawei.cse.houseapp.customer.service;

import com.huawei.cse.houseapp.common.*;
import org.apache.servicecomb.provider.rest.common.RestSchema;
import org.apache.servicecomb.provider.springmvc.reference.RestTemplateBuilder;
import org.apache.servicecomb.swagger.invocation.context.ContextUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@RestSchema(schemaId = "customer")
@RequestMapping(path = "/")
public class CustomerServiceImpl {
  private static RestTemplate restTemplate = RestTemplateBuilder.create();

  @GetMapping(path = "/time")
  public String getTime() {
    HelloTime ht = restTemplate.getForObject("cse://upload-service/time/getTime", HelloTime.class);
    System.out.println(ht.getDate().toString());
    return ht.toString();
  }

  @GetMapping(path = "/context")
  public String getContext() {
    return ContextUtils.getInvocationContext().getContext("session_id");
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

  @PostMapping(path = "/template")
  public Holder<Person> getHolder(@RequestBody Holder<Person> personHolder) {
    Person p = personHolder.getData();
    System.out.println(p.getName());
    return personHolder;
  }

  @GetMapping(path = "/template")
  public String testTemplate() {
    Holder<Person> param = new Holder<>();
    Person person = new Person();
    person.setName("hello");
    param.setData(person);

    Holder<Person> result = restTemplate.postForObject("cse://upload-service/generic/template", param, Holder.class);
    StringBuilder response = new StringBuilder()
            .append(result.getClass())
            .append(":")
            .append(result.getData().getClass())
            .append(":")
            .append(result.getData().getName());
    return response.toString();
  }

  @GetMapping(path="/getHolderListArea")
  public String testGetHolderListArea(){
    Holder<List<BaseArea>> result = restTemplate.postForObject("cse://upload-service/generic/getHolderListArea",null,Holder.class);

    return result.toString();
  }
}
