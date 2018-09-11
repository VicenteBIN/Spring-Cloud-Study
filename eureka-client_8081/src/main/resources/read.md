#spring-cloud  api
##多环境配置
> - 在application.properties 中配置通用内容，并设置spring.profiles.active={dev/test/prod}表示启动哪个环境的配置
> - 在application-{profile}.properties 中配置不同环境的内容
> - 通过命令行方式去激活不同环境的配置
   > - - java -jar xxx.jar --server.port==8888 (--server.port表示对属性赋值)
   > - - java -jar xxx.jar --spring.profiles.active=test (表示启动测试环境的配置)

--- 

##服务治理：spring cloud eureka
> - pom文件添加需要的包

        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-eureka-server</artifactId>
        </dependency>
        <dependencyManagement>
                <dependencies>
                    <dependency>
                        <groupId>org.springframework.cloud</groupId>
                        <artifactId>spring-cloud-dependencies</artifactId>
                        <version>Brixton.SR5</version>
                        <type>pom</type>
                        <scope>import</scope>
                    </dependency>
                </dependencies>
        </dependencyManagement>

> - @EnableEurekaServer 注解启动一个服务注册中心提供给其他应用进行对话
> - 配置

       
           //eureka.client.register-with-eureka --> 禁用不向注册中心注册自己
           //eureka.client.fetch-registry       --> 注册中心的职责就是维护服务实例，并不需要检索服务，所以设置false
           eureka.instance.hostname=localhost
           eureka.client.register-with-eureka=false
           eureka.client.fetch-registry=false
           eureka.client.service-url.defaultZone=http://${eureka.instance.hostname}:{server.port}/eureka/
---