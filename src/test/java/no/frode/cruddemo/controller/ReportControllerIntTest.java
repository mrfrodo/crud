package no.frode.cruddemo.controller;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.response.ResponseBody;
import no.frode.cruddemo.CrudDemoApplication;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import static com.jayway.restassured.RestAssured.get;
import static org.hamcrest.Matchers.equalTo;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = CrudDemoApplication.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("dev")
@Ignore
public class ReportControllerIntTest {
    @LocalServerPort
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
