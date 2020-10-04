# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.3.3.RELEASE/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.3.3.RELEASE/maven-plugin/reference/html/#build-image)
* [Spring Security](https://docs.spring.io/spring-boot/docs/2.3.3.RELEASE/reference/htmlsingle/#boot-features-security)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.3.3.RELEASE/reference/htmlsingle/#boot-features-developing-web-applications)
* [OAuth2 Resource Server](https://docs.spring.io/spring-boot/docs/2.3.3.RELEASE/reference/htmlsingle/#boot-features-security-oauth2-server)

### Guides
The following guides illustrate how to use some features concretely:

* [Securing a Web Application](https://spring.io/guides/gs/securing-web/)
* [Spring Boot and OAuth2](https://spring.io/guides/tutorials/spring-boot-oauth2/)
* [Authenticating a User with LDAP](https://spring.io/guides/gs/authenticating-ldap/)
* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)


* https://docs.spring.io/spring-security-oauth2-boot/docs/current/reference/html5/#oauth2-boot-authorization-server-spring-security-oauth2-resource-server
* https://dzone.com/articles/build-an-oauth-20-authorization-server-with-spring
* https://docs.spring.io/spring-security-oauth2-boot/docs/2.2.x-SNAPSHOT/reference/html/boot-features-security-oauth2-authorization-server.html
* https://www.toptal.com/spring/spring-boot-oauth2-jwt-rest-protection
* https://spring.io/guides/topicals/spring-security-architecture/

* Authentication manager: coordinate with Authentication provider to perform the authentication.
```
class ProviderManager implements AuthenticationManager{
private List<AuthenticationProvider> providers
public Authentication authenticate(Authentication authentication){
providers.stream
.findFirst()
.authenticate(authentication)
.orElseThrow(()->new anyException());

}
}
```
* DelegatingFilterProxy
* Authentication provider does the actual work of authentication.
