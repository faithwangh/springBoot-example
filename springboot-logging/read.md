##springboot日志
**市面上的日志框架；**

JUL、JCL、Jboss-logging、logback、log4j、log4j2、slf4j....

| 日志门面  （日志的抽象层）                           | 日志实现                                     |
| ---------------------------------------- | ---------------------------------------- |
| ~~JCL（Jakarta  Commons Logging）~~    SLF4j（Simple  Logging Facade for Java）    **~~jboss-logging~~** | Log4j  JUL（java.util.logging）  Log4j2  **Logback** |

左边选一个门面（抽象层）、右边来选一个实现；

日志门面：  SLF4J；

日志实现：Logback；

SpringBoot：底层是Spring框架，Spring框架默认是用JCL；‘

**===SpringBoot选用 SLF4j和logback===**

####日志级别
从低到高 trace ,debug ,info, error 
配置文件 ,springboot 默认是 info
```bash
logging.level.root=debug
logging.level.org.springframework.web=DEBUG
logging.level.org.hibernate=ERROR
```

##基本使用
```java

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

    @GetMapping("/hello")
    public String hello() {

       Logger logger = LoggerFactory.getLogger("sms-info");
    // Logger logger = LoggerFactory.getLogger(HelloWorld.class);

        logger.trace("logging trace");
        logger.debug("longing debug");
        logger.info("logging info");
        logger.error("logging error");
         
```

##logging文件输出

logging.file 与 logging.path 的关系：

| logging.file | logging.path | Example  | Description             |
| ------------ | ------------ | -------- | ----------------------- |
| (none)       | (none)       |          | 只在控制台输出                 |
| 指定文件名        | (none)       | my.log   | 输出日志到my.log文件           |
| (none)       | 指定目录         | /var/log | 输出到指定目录的 spring.log 文件中 |

配置文件：
```bash

#  在控制台输出的日志的格式
logging.pattern.console=%d{yyyy-MM-dd} [%thread] %-5level %logger{50} - %msg%n
# 指定文件中日志输出的格式
logging.pattern.file=%d{yyyy-MM-dd} === [%thread] === %-5level === %logger{50} ==== %msg%n

#logging.file=/var/log/springBoot-example/logging/my.log
logging.file.max-history=30
logging.file.max-size=10MB
logging.path=/var/log/springBoot-example/logging

```

##自定义日志文件

给类路径下放上每个日志框架自己的配置文件即可；SpringBoot就不使用他默认配置的了

| Logging System          | Customization                            |
| ----------------------- | ---------------------------------------- |
| Logback                 | `logback-spring.xml`, `logback-spring.groovy`, `logback.xml` or `logback.groovy` |
| Log4j2                  | `log4j2-spring.xml` or `log4j2.xml`      |
| JDK (Java Util Logging) | `logging.properties`                     |

logback.xml：直接就被日志框架识别了；

**logback-spring.xml**：日志框架就不直接加载日志的配置项，由SpringBoot解析日志配置，可以使用SpringBoot的高级Profile功能


