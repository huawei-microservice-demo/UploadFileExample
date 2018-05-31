/*
 * Copyright 2017 Huawei Technologies Co., Ltd
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.huawei.cse.houseapp.edge;

import java.util.Map;


import org.apache.servicecomb.edge.core.AbstractEdgeDispatcher;
import org.apache.servicecomb.edge.core.CompatiblePathVersionMapper;
import org.apache.servicecomb.edge.core.EdgeInvocation;

import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.CookieHandler;

public class ApiDispatcher extends AbstractEdgeDispatcher {
  private CompatiblePathVersionMapper versionMapper = new CompatiblePathVersionMapper();

  @Override
  public int getOrder() {
    return Integer.MIN_VALUE;
  }

  @Override
  public void init(Router router) {
    // api + 微服务名 + 实际路径
    String regex = "/api/([^\\\\/]+)/(.*)";
    router.routeWithRegex(regex).handler(CookieHandler.create());
    router.routeWithRegex(regex).handler(createBodyHandler());
    router.routeWithRegex(regex).failureHandler(this::onFailure).handler(this::onRequest);
  }

  protected void onRequest(RoutingContext context) {
    Map<String, String> pathParams = context.pathParams();
    String microserviceName = pathParams.get("param0");
//    String pathVersion = pathParams.get("param1");
    String path = "/" + pathParams.get("param1");

    EdgeInvocation edgeInvocation = new EdgeInvocation() {
      protected void createInvocation(Object[] args) {
        super.createInvocation();
        invocation.addContext("session_id", "my_test_session_id");
      }
    };
//    edgeInvocation.setVersionRule(versionMapper.getOrCreate(pathVersion).getVersionRule());

    context.response().putHeader("xxxxx","sss");
    edgeInvocation.init(microserviceName, context, path, httpServerFilters);

    edgeInvocation.edgeInvoke();
  }
}
