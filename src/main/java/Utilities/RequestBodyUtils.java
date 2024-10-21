package Utilities;

import com.google.gson.JsonObject;

public class RequestBodyUtils {

    /**
     * need to pass the data to post body like this
     * this is one way using data tables or we can use pojo classes as well
     * @return
     */
    public static JsonObject relativeCodeRequestBody(){
        JsonObject jsonObject=new JsonObject();
        jsonObject.addProperty("requestId","string"); //key data should be same as data table keys,  value is hard coded need to pass parameter
        jsonObject.addProperty("isGlobal",true);
        jsonObject.addProperty("relativeDateCode",0);
        jsonObject.addProperty("dateAmount",0);
        return jsonObject;
    }

    public static JsonObject findSymbol(String strID,String strSymbol,String strSymbolTypeChar,String strDate,String strCountry,boolean blnIsGlobal){ //passing parameters
        JsonObject jsonObject=new JsonObject();
        jsonObject.addProperty("requestId",strID);
        jsonObject.addProperty("isGlobal",blnIsGlobal);
        jsonObject.addProperty("callerID","RestAssured");
        jsonObject.addProperty("symbol",strSymbol);
        jsonObject.addProperty("symbolTypeChar",strSymbolTypeChar);
        jsonObject.addProperty("date",strDate);
        jsonObject.addProperty("country",strCountry);
        return jsonObject;
    }

    public static JsonObject relativeCode(String strRelativeCode,String strBaseDate,String strDateAmount,boolean region){
        JsonObject jsonObject=new JsonObject();
        jsonObject.addProperty("requestId","");
        jsonObject.addProperty("baseDate",strBaseDate);
        jsonObject.addProperty("callerID","RestAssured");
        jsonObject.addProperty("relativeDateCode",Integer.parseInt(strRelativeCode));
        jsonObject.addProperty("dateAmount",Integer.parseInt(strDateAmount));
        jsonObject.addProperty("isGlobal",region);
        return jsonObject;
    }

    public static JsonObject portfolio(String strAccount,boolean region){
        JsonObject jsonObject=new JsonObject();
        jsonObject.addProperty("requestId","string"); //key data should be same as data table keys,  value is hard coded need to pass parameter
        jsonObject.addProperty("isGlobal",region);
        jsonObject.addProperty("relativeDateCode",0);
        jsonObject.addProperty("dateAmount",0);
        jsonObject.addProperty("portfolioName",strAccount);


        return jsonObject;
    }





}
