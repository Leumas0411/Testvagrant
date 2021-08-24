package utilities;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

    private Properties properties;
    private final String commonPath="src//main//java//properties//";
    private final String propertyFilePath= "src//main//java//properties//config.properties";
    private  String filePath="";



    public ConfigFileReader(String fileName){
        BufferedReader reader;
        try {
            filePath=commonPath+fileName;
            reader = new BufferedReader(new FileReader(filePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + filePath);
        }
    }

    public String getBrowser(){
        String browser = properties.getProperty("Browser");
        if(browser!= null) return browser;
        else throw new RuntimeException("Browser not specified in the Configuration.properties file.");
    }

    public String get_UI_URL(){
        String url = properties.getProperty("URL");
        if(url!= null) return url;
        else throw new RuntimeException("URL not specified in the Configuration.properties file.");
    }

    public String get_Base_URI(){
        String baseuri = properties.getProperty("Base_URI");
        if(baseuri!= null) return baseuri;
        else throw new RuntimeException("Base URI not specified in the Endpoint.properties file.");
    }

    public String get_property(String key){
        String value = properties.getProperty(key);
        if(value!= null) return value;
        else throw new RuntimeException(key+" is not specified in any properties file.");
    }



}
