##springboot 整合 jdbc 和 druid  

###pom文件
```sybase

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-jdbc</artifactId>
        </dependency>
    
        <!-- https://mvnrepository.com/artifact/com.alibaba/druid -->
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>druid</artifactId>
            <version>1.1.19</version>
        </dependency>

          <dependency>
               <groupId>mysql</groupId>
               <artifactId>mysql-connector-java</artifactId>
               <scope>runtime</scope>
           </dependency>

 ```
 ###application.yml
 
 ```yaml

spring:
  datasource:
    username: root
    password: 123456
    url: jdbc:mysql://localhost:3306/default
    driver-class-name: com.mysql.cj.jdbc.Driver
#    type: com.alibaba.druid.pool.DruidDataSource


```

### springboot2.X 默认的连接池是 hikari
```java

  @Autowired
    DataSource dataSource;

    @Test
    public void contextLoads() throws SQLException {
        Connection connection = dataSource.getConnection();
        connection.close();
        System.out.println(connection);
    }

```

### hikari的配置
```properties

#  Hikari 连接池配置 ------ 详细配置请访问：https://github.com/brettwooldridge/HikariCP
# 最小空闲连接数量
spring.datasource.hikari.minimum-idle=5
## 空闲连接存活最大时间，默认600000（10分钟）
spring.datasource.hikari.idle-timeout=180000
## 连接池最大连接数，默认是10
spring.datasource.hikari.maximum-pool-size=10
## 此属性控制从池返回的连接的默认自动提交行为,默认值：true
spring.datasource.hikari.auto-commit=true
## 连接池名称
spring.datasource.hikari.pool-name=MyHikariCP
## 此属性控制池中连接的最长生命周期，值0表示无限生命周期，默认1800000即30分钟
spring.datasource.hikari.max-lifetime=1800000
## 数据库连接超时时间,默认30秒，即30000
spring.datasource.hikari.connection-timeout=30000
spring.datasource.hikari.connection-test-query=SELECT 1


```
### jdbc简单使用

model层

```java

public class UserModel {

    private Integer id;

    private String uniqueName;

    private String gender;

    private String password;

    private Integer isActive;
    
    //省略 set ,get 

```

controller 层
```java
  private final JdbcTemplate jdbcTemplate;

    public HelloController(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/hello")
    public List<UserModel> hello(){

        // 查询所有用户
        String sql = "select * from user";
        return jdbcTemplate.query(sql, new Object[]{}, new BeanPropertyRowMapper<>(UserModel.class));

    }

```

## druid 连接池的基本使用


