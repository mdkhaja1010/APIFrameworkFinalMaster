package Utilities;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.testng.Assert;

import java.io.FileReader;

public class ReadJSONUtils {

    public static JsonObject readRequestJSON(String strRequestFile){
        JsonObject jsonObject=new JsonObject();
        try{
            String strDir=System.getProperty("user.dir");
            JsonParser jsonParser=new JsonParser();
            JsonElement jsonElement=jsonParser.parse(new FileReader(strDir+"\\requestJSON\\"+strRequestFile+".json"));
            jsonObject =jsonElement.getAsJsonObject();
        }catch (Exception e){
            Assert.fail("Request Json file has problem"+strRequestFile);

        }
        return jsonObject;
    }
    public static JsonObject readResponseJSON(String strRequestFile){
        JsonObject jsonObject=new JsonObject();
        try{
            String strDir=System.getProperty("user.dir");
            JsonParser jsonParser=new JsonParser();
            JsonElement jsonElement=jsonParser.parse(new FileReader(strDir+"\\responseJSON\\"+strRequestFile+".json"));
            jsonObject=jsonElement.getAsJsonObject();
        }catch(Exception e){
            Assert.fail("Response Json file has problem"+e.getMessage());
        }
        return jsonObject;
    }




}
