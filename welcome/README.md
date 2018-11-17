# Swagger generated server

CSE Spring MVC Server


## Overview
这里的代码是根据用户提供的swagger.yaml文件自动生成。生成的代码总的来说分成以下几类：

1，入口main函数在com.service.welcome.WelcomeApplication这个类中。

2，com.service.welcome.controller.WelcomeImpl这个类插入通过定义springmvc的annotation，拦截用户请求、解析参数，并将处理的handler代理给welcomeDelegate类。

3，com.service.welcome.controller.WelcomeDelegate类是用户实现具体handler实现的类，理论上只需要用户在这个类里面实现业务逻辑。


4，resource目录下定义了一些配置文件，包括log4j的配置文件，微服务的配置信息，以及swagger协议文件等等。

5，特别注意两点：microservice.yaml里面配置信息要填写正确，生成的有可能有些偏差；swagger.yaml里面的x-java-interface配置项一定要指定为com.service.welcome.controller.Welcome。
