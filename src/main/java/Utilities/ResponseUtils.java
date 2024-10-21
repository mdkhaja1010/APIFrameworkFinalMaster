package Utilities;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;

import java.io.IOException;

public class ResponseUtils {

    public static <T> T getResponse(Response response, Class T){
        ObjectMapper mapper =new ObjectMapper();
        T responseDeserialized=null;
        try{
            responseDeserialized=(T) mapper.readValue(response.asString(),T);
                String jsonStr=mapper.writerWithDefaultPrettyPrinter().writeValueAsString(responseDeserialized);//pretty print JSON
            System.out.println("Handling Response: \n"+responseDeserialized.toString());

        }catch (IOException e){
            e.printStackTrace();
        }
        return responseDeserialized;

    }
}
