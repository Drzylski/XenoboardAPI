# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/3.4.5/maven-plugin)
* [Create an OCI image](https://docs.spring.io/spring-boot/3.4.5/maven-plugin/build-image.html)
* [Azure MySQL support](https://aka.ms/spring/msdocs/mysql)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/3.4.5/reference/using/devtools.html)
* [Spring Web](https://docs.spring.io/spring-boot/3.4.5/reference/web/servlet.html)
* [Thymeleaf](https://docs.spring.io/spring-boot/3.4.5/reference/web/servlet.html#web.servlet.spring-mvc.template-engines)
* [Spring Security](https://docs.spring.io/spring-boot/3.4.5/reference/web/spring-security.html)
* [OAuth2 Client](https://docs.spring.io/spring-boot/3.4.5/reference/web/spring-security.html#web.security.oauth2.client)
* [Spring Cloud Azure developer guide](https://aka.ms/spring/msdocs/developer-guide)
* [Azure Storage](https://microsoft.github.io/spring-cloud-azure/current/reference/html/index.html#resource-handling)
* [Spring Data JPA](https://docs.spring.io/spring-boot/3.4.5/reference/data/sql.html#data.sql.jpa-and-spring-data)
* [Spring Reactive Web](https://docs.spring.io/spring-boot/3.4.5/reference/web/reactive.html)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Handling Form Submission](https://spring.io/guides/gs/handling-form-submission/)
* [Securing a Web Application](https://spring.io/guides/gs/securing-web/)
* [Spring Boot and OAuth2](https://spring.io/guides/tutorials/spring-boot-oauth2/)
* [Authenticating a User with LDAP](https://spring.io/guides/gs/authenticating-ldap/)
* [Accessing data with MySQL](https://spring.io/guides/gs/accessing-data-mysql/)
* [Deploying a Spring Boot app to Azure](https://spring.io/guides/gs/spring-boot-for-azure/)
* [How to use the Spring Boot starter for Azure Storage](https://aka.ms/spring/msdocs/storage)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Building a Reactive RESTful Web Service](https://spring.io/guides/gs/reactive-rest-service/)

### Additional Links
These additional references should also help you:

* [Azure Samples](https://aka.ms/spring/samples)
* [Azure Storage Sample](https://aka.ms/spring/samples/latest/storage)

### Deploy to Azure

This project can be deployed to Azure with Maven.

To get started, replace the following placeholder in your `pom.xml` with your specific Azure details:

- `subscriptionId`
- `resourceGroup`
- `appEnvironmentName`
- `region`

Now you can deploy your application:
```bash
./mvnw azure-container-apps:deploy
```

Learn more about [Java on Azure Container Apps](https://learn.microsoft.com/azure/container-apps/java-overview).
### Maven Parent overrides

Due to Maven's design, elements are inherited from the parent POM to the project POM.
While most of the inheritance is fine, it also inherits unwanted elements like `<license>` and `<developers>` from the parent.
To prevent this, the project POM contains empty overrides for these elements.
If you manually switch to a different parent and actually want the inheritance, you need to remove those overrides.

