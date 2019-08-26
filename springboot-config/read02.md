##配置文件加载顺序

springboot 启动会扫描以下位置的application.properties或者application.yml文件作为Spring boot的默认配置文件

- file:./config/

- file:./

- classpath:/config/

- classpath:/

优先级由高到底，高优先级的配置会覆盖低优先级的配置；

**==我们还可以通过spring.config.location来改变默认的配置文件位置==**

```bash

java -jar springboot-config-0.0.1-SNAPSHOT.jar --location.config.location=~/Workspace/java/springBoot-example/config/application.yml
```

##多环境配置 profile
我们在主配置文件编写的时候，文件名可以是   application-{profile}.properties/yml

####yml支持多文档块方式

```yml

server:
  port: 8081
spring:
  profiles:
    active: prod

---
server:
  port: 8083
spring:
  profiles: dev


---

server:
  port: 8084
spring:
  profiles: prod  #指定属于哪个环境
```

默认使用application.properties的配置:

```bash
spring.profiles.active=prod
```


