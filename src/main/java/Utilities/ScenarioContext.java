package Utilities;

import com.google.gson.JsonObject;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {

    public PrintStream log;
    public Response response;
    public String strBaseURL;
    public String strEndPoint;
    public Map<String,Object>session =new HashMap<>();
    public HashMap<String, RequestSpecification>requestBuilder=new HashMap<>();
    public Map<String,Object>headers=new HashMap<String,Object>();
    public JsonObject requestBody;
}
