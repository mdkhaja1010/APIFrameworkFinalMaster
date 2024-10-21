package Utilities;

import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.testng.Assert;

import java.io.File;

import static org.hamcrest.MatcherAssert.assertThat;

public class ValidationUtils {

    public static void validateResponseCode(Response response,String strResponseCode){
        Assert.assertEquals(response.getStatusCode(),Integer.parseInt(strResponseCode),"response code is not correct");
    }
    public static void validateResponseType(Response response,String strResponseType){
        Assert.assertEquals(response.getContentType(),strResponseType,"response type is not correct");
    }
    public static void validateSchema(Response response,String strSchema){
       try{
           String strDir=System.getProperty("user.dir");
           assertThat(response.getBody().asString(), JsonSchemaValidator.matchesJsonSchema(new File(strDir+"\\schemaJSON\\"+strSchema+".json")));

       }catch (Exception e){
           Assert.fail("Schema validation has issue "+e.getMessage());
       }
    }

}
