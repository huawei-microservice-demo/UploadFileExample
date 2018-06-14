package com.huawei.cse.houseapp.edge.filter;

import org.apache.servicecomb.common.rest.filter.HttpServerFilter;
import org.apache.servicecomb.core.Invocation;
import org.apache.servicecomb.foundation.vertx.http.HttpServletRequestEx;
import org.apache.servicecomb.foundation.vertx.http.HttpServletResponseEx;
import org.apache.servicecomb.swagger.invocation.Response;

public class TestServerFilter implements HttpServerFilter {
  @Override
  public int getOrder() {
    return 0;
  }

  @Override
  public Response afterReceiveRequest(Invocation invocation, HttpServletRequestEx requestEx) {
    return null;
  }

  @Override
  public void beforeSendResponse(Invocation invocation, HttpServletResponseEx responseEx) {
    System.out.println(responseEx.getStatus());
    System.out.println(responseEx.getBodyBuffer().toString());
    for (String headerName : responseEx.getHeaderNames()) {
      System.out.println(headerName + ":" + responseEx.getHeader(headerName));
    }
  }
}
