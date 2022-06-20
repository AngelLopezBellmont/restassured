import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class first_examples {
    String myUri;
    Response response;
    Response response2;

    @Before
    public void Response(){
        myUri = "https://reqres.in/api/products/3";
        Utils utils = new Utils();
        //myUri = utils.getDemoSwagger();


        response = given()
                .when()
                .get(myUri)
                .then()
                //.statusCode(200)
                .extract()
                .response();
        //another way to get Response:
        RestAssured.baseURI = myUri;
        RequestSpecification httpRequest = RestAssured.given();
        response2 = httpRequest.get();
    }


    @Test
    public void Status_code_etc() {
        int statusCode         = given().when().get(myUri).getStatusCode();
        String contentType     = given().when().get(myUri).then().extract().contentType();
        String headers         = String.valueOf(given().when().get(myUri).then().extract().headers());
        response.then().assertThat().statusCode(200);
        Assert.assertNotNull(response);
        System.out.println("statusCode: "+ statusCode);
        System.out.println("contentType: "+ contentType);
        System.out.println("headers: "+ headers);
    }

    @Test
    public void Response_log_all() {
        String response_log_all =  response2.then().log().all().toString();
        System.out.println("response_log_all: "+ response_log_all);
    }


    @Test
    public void Response_extract_body_toString() {
        String strBody  = response.then().extract().body().toString();
        System.out.println("strBody: "+ strBody);
    }

    @Test
    public void myResponse_getBody() {
        ResponseBody responseBody  =  response.getBody();
        System.out.println("responseBody: "+ responseBody.asString());
        //System.out.println("responseBody.prettyPrint(): "+ responseBody.prettyPrint());
        System.out.println("responseBody.asPrettyString(): "+ responseBody.asPrettyString());
    }

    @Test
    public void myResponse_JsonPath() {
        //System.out.println(response.getBody().asPrettyString());
        JsonPath jsonPath = response.jsonPath();

/*        //https://reqres.in/api/products/3
        int id = jsonPath.get("data.id");
        String name = jsonPath.get("data.name");
        System.out.println("data.id: " + id);
        System.out.println("data.name: " + name);
        assertEquals(id,3);
        assertEquals(name,"true red");*/

        //swagger
        System.out.println("swagger version: " + jsonPath.get("swagger"));
        System.out.println("swagger paths: " + jsonPath.get("swagger"));


    }
    @Test
    public void read_config_file() {
        Utils utils = new Utils();
        String env = utils.getEnvironment();
        System.out.println("env: "+ env);
        System.out.println("getMicroserviceName : "+ utils.getMicroserviceName());
        System.out.println("getMicroservicePath : "+ utils.getMicroservicePath());
        System.out.println("getDemoSwagger      : "+ utils.getDemoSwagger());
    }

    @Test
    public void swagger() {
        // using myUri = utils.getDemoSwagger();
        // System.out.println(response.getBody().asPrettyString());
        JsonPath jsonPath = response.jsonPath();
        //swagger
        System.out.println("swagger version: " + jsonPath.get("swagger"));
        System.out.println("swagger paths  : " + jsonPath.get("paths"));
        //System.out.println("swagger paths/holidays: " + jsonPath.get("paths.holidays"));
    }


}

//    @Test
//    public void myResponse_ValidatableResponse() {
//        ValidatableResponse myValidatableResponse =  myResponse.then().log().all();
//        System.out.println("myValidatableResponse: "+ myValidatableResponse);
//    }