package Utilities;

import DriverManagers.LoggerManager;
import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.log4j.Logger;
import org.testng.Assert;

import java.util.Map;

public class ReusableMethodUtils {
    static Logger log = LoggerManager.getLogger(ReusableMethodUtils.class);
    public static String token;

    public static Response postMethod(String strBaseURL, String strEndPoint, Map<String, Object> header, JsonObject requestBody) {
        Response response = null;
        try {
            log.info("\nBase URL and EndPoint:\n" + strBaseURL + strEndPoint);
            log.info("\nRequest Header:\n" + header);
            log.info("\nRequest Body:\n" + requestBody);
            RestAssured.baseURI = strBaseURL;
            RequestSpecification request = RestAssured.given().log().all();
            request.headers(header);
            request.body(requestBody.toString());
            response = request.post(strEndPoint);
            log.info("\nResponse Header:\n" + response.getHeaders());
            log.info("\nResponse Body:\n" + response.getBody().asString());

        } catch (Exception e) {
            Assert.fail("post method has failed" + e.getMessage());
        }
        return response;

    }

    public static Response putMethod(String strBaseURL, String strEndPoint, Map<String, Object> header, JsonObject requestBody) {
        Response response = null;
        try {
            log.info("\nBase URL and EndPoint:\n" + strBaseURL + strEndPoint);
            log.info("\nRequest Header:\n" + header);
            log.info("\nRequest Body:\n" + requestBody);
            RestAssured.baseURI = strBaseURL;
            RequestSpecification request = RestAssured.given().log().all();
            request.headers(header);
            request.body(requestBody.toString());
            response = request.put(strEndPoint);
            log.info("\nResponse Header:\n" + response.getHeaders());
            log.info("\nResponse Body:\n" + response.getBody().asString());

        } catch (Exception e) {
            Assert.fail("put method has failed" + e.getMessage());
        }
        return response;

    }
    public static Response getMethod(String strBaseURL, String strEndPoint, Map<String, Object> header) {
        Response response = null;
        try {
            log.info("\nBase URL and EndPoint:\n"+strBaseURL+strEndPoint);
            log.info("\nRequest Header:\n"+header);
            RestAssured.baseURI=strBaseURL;
            RequestSpecification request=RestAssured.given().log().all();
            request.headers(header);
            response=request.get(strEndPoint);
            log.info("\nResponse Header:\n"+response.getHeaders());
            log.info("\nResponse Body:\n"+response.getBody().asString());

        }catch(Exception e){
            Assert.fail("get method has failed"+e.getMessage());
        }
        return response;



    }
    public static Response postMethodforUrlencoded(String strBaseURL, String strEndPoint, Map<String, Object> header, String username, String email, String password) {
        Response response = null;
        try {
            log.info("\nBase URL and EndPoint:\n" + strBaseURL + strEndPoint);
            log.info("\nRequest Header:\n" + header);

            RestAssured.baseURI = strBaseURL;
            RequestSpecification request = RestAssured.given().log().all();

            // Set headers
            request.headers(header);

            // Add dynamic form parameters correctly
            request.formParam("name", username)
                    .formParam("email", email)
                    .formParam("password", password);

            // Log form parameters for debugging
            log.info("Sending form parameters: name=" + username + ", email=" + email + ", password=" + password);

            // Send the POST request
            response = request.post(strEndPoint);

            // Log response details
            log.info("\nResponse Code:\n" + response.getStatusCode());
            log.info("\nResponse Header:\n" + response.getHeaders());
            log.info("\nResponse Body:\n" + response.getBody().asString());

        } catch (Exception e) {
            Assert.fail("Post method has failed: " + e.getMessage());
        }
        return response;
    }
    public static Response postMethodforUrlencoded(String strBaseURL, String strEndPoint, Map<String, Object> header,String email, String password) {
        Response response = null;
        try {
            log.info("\nBase URL and EndPoint:\n" + strBaseURL + strEndPoint);
            log.info("\nRequest Header:\n" + header);

            RestAssured.baseURI = strBaseURL;
            RequestSpecification request = RestAssured.given().log().all();
            request.headers(header);

                   request.formParam("email", email)
                    .formParam("password", password);

            response = request.post(strEndPoint);

            // Log response details
            log.info("\nResponse Code:\n" + response.getStatusCode());
            log.info("\nResponse Header:\n" + response.getHeaders());
            log.info("\nResponse Body:\n" + response.getBody().asString());
            token=response.jsonPath().getString("data.token");
            System.out.println("%^&*(&&&&&&&&&&&&&&&&&& "+token);
            log.info(response.print());
        } catch (Exception e) {
            Assert.fail("Post method has failed: " + e.getMessage());
        }
        return response;
    }
    public static void waittime(int sec){
        try{
            Thread.sleep(sec);
        }catch(Exception e){
            System.out.println(e);
        }
    }



}
