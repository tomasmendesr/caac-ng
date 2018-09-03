package ar.gov.sedronar.aplicacion.util;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigProperties {

    private static ConfigProperties instance = null;
    private Properties prop;

    public static ConfigProperties getInstance(){
        if(instance == null)
            instance = new ConfigProperties();
        return instance;
    }

    private ConfigProperties(){
        prop = new Properties();
        InputStream input = null;

        try {
            // src > main > resources > config.properties
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            input = classloader.getResourceAsStream("config.properties");
            //	 load a properties file
            prop.load(input);

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public String getVersion(){
        return prop.getProperty("version");
    }

}
