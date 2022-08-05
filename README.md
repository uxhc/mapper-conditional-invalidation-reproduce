# Mybatis Mapper 接口条件注解不生效

## 准备工作
- 创建 `DbHelloServiceImpl` and `HelloMapper` 两个类，都加上如下所示的条件注解
```java
@ConditionalOnProperty(name = "fetch.type", havingValue = "DB")
```
`DbHelloServiceImpl` 依赖 `HelloMapper`
- 在 `application.yml` 中进行配置
```yaml
fetch:
  type: DB
```

## 重现步骤 

- 运行 `BootStrap` 启动类, 启动会报错，日志如下:
```
...
2022-08-05 15:06:42.510  WARN 51026 --- [           main] o.m.s.mapper.ClassPathMapperScanner      : No MyBatis mapper was found in '[org.example.mapper]' package. Please check your configuration.
...
Error starting ApplicationContext. To display the conditions report re-run your application with 'debug' enabled.
2022-08-05 15:06:43.085 ERROR 51026 --- [           main] o.s.b.d.LoggingFailureAnalysisReporter   : 

***************************
APPLICATION FAILED TO START
***************************

Description:

Parameter 0 of constructor in org.example.service.impl.DbHelloServiceImpl required a bean of type 'org.example.mapper.HelloMapper' that could not be found.


Action:

Consider defining a bean of type 'org.example.mapper.HelloMapper' in your configuration.
```
正常情况下，`DbHelloServiceImpl` 是可以自动注入 `HelloMapper` 的，因为按照配置文件配置的那样，`HelloMapper` 上的条件注解应该会匹配成功，然而并没有匹配成功

- 修改 `BootStrap` 启动类, 在项目启动之前设置系统变量
```java
@SpringBootApplication
@MapperScan(basePackages = "org.example.mapper")
public class Bootstrap {
  public static void main(String[] args) {
    System.setProperty("fetch.type", "DB");
    SpringApplication.run(Bootstrap.class, args);
  }
}
```
这下项目可以正常启动