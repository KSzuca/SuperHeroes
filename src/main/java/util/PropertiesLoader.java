package util;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoader {


    private static PropertiesLoader INSTANCE;

    private PropertiesLoader() {
        if (null != INSTANCE) {
            throw new IllegalStateException("Logger class instance is already initialized!");
        }
    }

        public static PropertiesLoader getInstance (){
        if (null == INSTANCE) {
            INSTANCE = new PropertiesLoader();
}
            return INSTANCE;
        }

        public void loadProperties () {
            Properties properties = new Properties();
            String propertyFile = "application.properties";
            ClassLoader loader = Thread.currentThread().getContextClassLoader();
            InputStream stream = loader.getResourceAsStream(propertyFile);
            try {
                properties.load(stream);
            } catch (IOException e) {
                System.out.println("There were problems loading property file.");
            }
            System.setProperties(properties);
    }

    public int getProperties(String key) {
        String value = System.getProperty(key);
        return Integer.parseInt(value);
    }
}
