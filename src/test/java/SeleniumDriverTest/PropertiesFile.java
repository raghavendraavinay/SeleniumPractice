package SeleniumDriverTest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class PropertiesFile {
    static Properties propertiesFile = new Properties();

    public static void main(String[] args) {
        System.out.println("Browser: "+getProperties("browser"));
        setProperties("firefox");
    }

    public static String getProperties(String properties) {
        try {
            InputStream file = new FileInputStream("src/test/resources/config.properties");
            propertiesFile.load(file);
           return propertiesFile.getProperty(properties);
        }catch (Exception e){
            System.out.println("No Properties found");
            return null;
        }
    }

    public static void setProperties(String properties){
        try {
            OutputStream outputStream = new FileOutputStream("src/test/resources/config.properties");
            propertiesFile.setProperty("browser",properties);
            propertiesFile.store(outputStream,"Updated");
        } catch (Exception e){
            System.out.println("No properties found");
        }


    }

}
