package info.pragmaticdeveloper.iam

import groovy.transform.CompileStatic
import io.restassured.RestAssured
import io.restassured.http.Header
import io.restassured.http.Headers
import io.restassured.specification.RequestSpecification
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import spock.lang.Specification

class IntegrationTestSpecification extends Specification {
    @Value('http://localhost')
    protected String host

    @Value('${local.server.port}')
    protected int port

    @CompileStatic
    RequestSpecification getEndpoint() {
        RestAssured.given()
                .baseUri(host)
                .port(port)
    }

    def buildHeaders() {
        new Headers(Arrays.asList(new Header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)))
    }
}
