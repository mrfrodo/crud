package no.frode.cruddemo.controller;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.response.ResponseBody;
import no.frode.cruddemo.CrudDemoApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static com.jayway.restassured.RestAssured.get;
import static org.hamcrest.Matchers.equalTo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CrudDemoApplication.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@Profile("dev")
public class ReportControllerIntTest {
    @Value("${server.port}")
    int port;

    @Before
    public void setBaseUri () {
        RestAssured.port = port;
        RestAssured.baseURI = "http://localhost"; // replace as appropriate
    }

    @Test
    public void getDataTest() {
        Response response = get("/demo/products/1");
        ResponseBody body = response.getBody();
        body.prettyPrint();
        response.then().assertThat().body("productName",
                equalTo("Eplekake"));
    }

    @Test
    public void getDataTest2() {
        Response response = get("/demo/products/1");
        ResponseBody body = response.getBody();
        body.prettyPrint();
        response.then().assertThat().body("category",
                equalTo("Kake"));
    }
}
