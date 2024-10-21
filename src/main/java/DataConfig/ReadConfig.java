package DataConfig;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {

    private final Properties properties;

    /**
     * Method to read config values
     */
    public ReadConfig(){
        BufferedReader bufferedReader;
        FileReader fileReader;
        String strPropertyPath="config/configuaration.properties";
        try{
            fileReader=new FileReader(strPropertyPath);
            bufferedReader=new BufferedReader(fileReader);
            properties=new Properties();
            try{
            properties.load(bufferedReader);
            bufferedReader.close();
        } catch(IOException ex){
            ex.printStackTrace();
        }

    }catch(FileNotFoundException e){
            e.printStackTrace();
            throw new RuntimeException("Config file not found at "+strPropertyPath);
        }
}
public String getBaseURL() {

    String strProp = properties.getProperty("Base_URL");
    if (strProp != null) {
        return strProp;
    } else {
        throw new RuntimeException("Base_URL is not present in the config property");
    }
}

    public String getNotesEndPoint() {

        String strProp = properties.getProperty("NotesEndPoint");
        if (strProp != null) {
            return strProp;
        } else {
            throw new RuntimeException("NotesEndPoint is not present in the config property");
        }
    }
    public String getUserCreateEndPoint() {

        String strProp = properties.getProperty("UserCreateEndPoint");
        if (strProp != null) {
            return strProp;
        } else {
            throw new RuntimeException("UserCreateEndPointis not present in the config property");
        }
    }
    public String getLoginEndPoint() {

        String strProp = properties.getProperty("UserLoginEndPoint");
        if (strProp != null) {
            return strProp;
        } else {
            throw new RuntimeException("UserLoginEndPoint is not present in the config property");
        }
    }
    public String getUserEndPoint() {

        String strProp = properties.getProperty("UserEndPoint");
        if (strProp != null) {
            return strProp;
        } else {
            throw new RuntimeException("UserEndPoint is not present in the config property");
        }
    }

    public String getPostRequestEndPoint() {

        String strProp = properties.getProperty("PostRequestEndPoint");
        if (strProp != null) {
            return strProp;
        } else {
            throw new RuntimeException("PostRequestEndPoint is not present in the config property");
        }
    }

    }

