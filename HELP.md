# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/4.0.6/maven-plugin)
* [Create an OCI image](https://docs.spring.io/spring-boot/4.0.6/maven-plugin/build-image.html)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/4.0.6/reference/using/devtools.html)
* [Spring Web](https://docs.spring.io/spring-boot/4.0.6/reference/web/servlet.html)
* [HTTP Client](https://docs.spring.io/spring-boot/4.0.6/reference/io/rest-client.html#io.rest-client.restclient)
* [Reactive HTTP Client](https://docs.spring.io/spring-boot/4.0.6/reference/io/rest-client.html#io.rest-client.webclient)
* [Spring Reactive Web](https://docs.spring.io/spring-boot/4.0.6/reference/web/reactive.html)
* [Spring for GraphQL](https://docs.spring.io/spring-boot/4.0.6/reference/web/spring-graphql.html)
* [Rest Repositories](https://docs.spring.io/spring-boot/4.0.6/how-to/data-access.html#howto.data-access.exposing-spring-data-repositories-as-rest)
* [Spring Session for Spring Data Redis](https://docs.spring.io/spring-session/reference/)
* [Spring Session for JDBC](https://docs.spring.io/spring-session/reference/)
* [Thymeleaf](https://docs.spring.io/spring-boot/4.0.6/reference/web/servlet.html#web.servlet.spring-mvc.template-engines)
* [Groovy Templates](https://docs.spring.io/spring-boot/4.0.6/reference/web/servlet.html#web.servlet.spring-mvc.template-engines)
* [Spring Security](https://docs.spring.io/spring-boot/4.0.6/reference/web/spring-security.html)
* [OAuth2 Client](https://docs.spring.io/spring-boot/4.0.6/reference/web/spring-security.html#web.security.oauth2.client)
* [Spring Data JPA](https://docs.spring.io/spring-boot/4.0.6/reference/data/sql.html#data.sql.jpa-and-spring-data)
* [JDBC API](https://docs.spring.io/spring-boot/4.0.6/reference/data/sql.html)
* [Elasticsearch](https://docs.spring.io/spring-boot/4.0.6/reference/data/nosql.html#data.nosql.elasticsearch)
* [Spring Data Elasticsearch](https://docs.spring.io/spring-boot/4.0.6/reference/data/nosql.html#data.nosql.elasticsearch)
* [Java Mail Sender](https://docs.spring.io/spring-boot/4.0.6/reference/io/email.html)
* [Validation](https://docs.spring.io/spring-boot/4.0.6/reference/io/validation.html)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Building a Reactive RESTful Web Service](https://spring.io/guides/gs/reactive-rest-service/)
* [Building a GraphQL service](https://spring.io/guides/gs/graphql-server/)
* [Accessing JPA Data with REST](https://spring.io/guides/gs/accessing-data-rest/)
* [Accessing Neo4j Data with REST](https://spring.io/guides/gs/accessing-neo4j-data-rest/)
* [Accessing MongoDB Data with REST](https://spring.io/guides/gs/accessing-mongodb-data-rest/)
* [Handling Form Submission](https://spring.io/guides/gs/handling-form-submission/)
* [Securing a Web Application](https://spring.io/guides/gs/securing-web/)
* [Spring Boot and OAuth2](https://spring.io/guides/tutorials/spring-boot-oauth2/)
* [Authenticating a User with LDAP](https://spring.io/guides/gs/authenticating-ldap/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Accessing Relational Data using JDBC with Spring](https://spring.io/guides/gs/relational-data-access/)
* [Managing Transactions](https://spring.io/guides/gs/managing-transactions/)
* [Accessing data with MySQL](https://spring.io/guides/gs/accessing-data-mysql/)
* [Validation](https://spring.io/guides/gs/validating-form-input/)

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

