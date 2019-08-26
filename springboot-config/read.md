##全局配置文件
* application.properties
* application.yml

> 名称都是固定都,两种文件格式可以同时支持。application.properties都优先级别高

##yml的语法
key:(空格)value  空格必须有
依照空格缩进的方式表示层级关系，左边对齐的为一个层级。
```yaml
server:
  port: 8081
  
```
它可以表示数据格式：
```yaml

cat:
  name: cat2
  age: 2
  birth: 2019/1/10
  my: true
  lists: [1,2]
  maps: {k1:v1,k2:v2}
  child:
    name: a
    age: 1

```
```yaml
# list set
pets:
 - cat
 - dog
 - pig

# " "：双引号；不会转义字符串里面的特殊字符；特殊字符会作为本身想表示的意思
# name:   "zhangsan \n lisi"：输出；zhangsan 换行  lisi

# ' ' ''：单引号；会转义特殊字符，特殊字符最终只是一个普通的字符串数据
#name:   ‘zhangsan \n lisi’：输出；zhangsan \n  lisi

```

对比 application.properties 的属性写法
```bash

cat.name=cat2
cat.age=2
cat.birth=2019/10/10
cat.my=false
cat.lists=1,2
cat.maps.k1=vv
cat.maps.k2=vvv
cat.child.name=bb
cat.child.age=33
```

把配置属性映射到 bean 对象
```java
@Component
@ConfigurationProperties(prefix = "cat" )
public class CatConfig {
    private String name;
    private Integer age;
    private Date birth;
    private Boolean my;
    private Map<String,Object> maps;
    private List<Integer> lists;
    private Child child;

```
## properties配置文件在idea中默认utf-8可能会乱码 

## 加载指定的配置文件 @PropertySource 
> 只适用 ***.properties 文件


```java

@Component
@PropertySource("classpath:my.properties")
@ConfigurationProperties(prefix = "my")
public class MyConfig {

//    @Value("${my.name}")
    private String name;
//    @Value("${my.age}")
    private Integer age;

```





