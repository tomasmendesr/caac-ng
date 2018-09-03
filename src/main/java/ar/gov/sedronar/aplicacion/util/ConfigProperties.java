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

    public ConfigProperties(){
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

    public String getUrlChangePassword() {
        return prop.getProperty("urlChangePassword");
    }

    public String getEmailFrom(){
        return prop.getProperty("email_from");
    }

    public String getEmailPassword(){
        return prop.getProperty("email_password");
    }

    public String getVersion(){
        return prop.getProperty("version");
    }

    public String getFilePath(){
        return prop.getProperty("filePath");
    }

    public int getTimeOutCodigoCambioPass() {
        String value = prop.getProperty("timeOutCodigoCambioPass").replaceAll("\\s","");
        return Integer.parseInt(value);
    }


    public long getDiasExpiroDeClave() {
        String value = prop.getProperty("diasExpiroDeClave").replaceAll("\\s","");
        return Integer.parseInt(value);
    }

    public String getDBServer() {
        return prop.getProperty("DB_SERVER");    }

    public String getDBName() {
        return prop.getProperty("DB_NAME");    }

    public String getDBUser() {
        return prop.getProperty("DB_USER");    }

    public String getDBPassword() {
        return prop.getProperty("DB_PASSWORD");    }

    public String getDBEncoding() {
        return prop.getProperty("DB_ENCODING");
    }

    public String getBDNuevaName() {
        return prop.getProperty("bd_nueva_name");
    }

    public String getBDOrigenName() {
        return prop.getProperty("bd_origen_name");
    }
}
