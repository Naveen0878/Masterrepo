package utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertyReader {
    private static Properties prop = new Properties();

    public PropertyReader(String filePath) {
        try {
            File file = new File(filePath);
            FileInputStream fileInput = new FileInputStream(file);
            prop.load(fileInput);
        } catch (Exception ex) {
            ex.printStackTrace();

        }
    }

    public String getProperty(String key) {
        if (prop != null) {
            return prop.getProperty(key, "Key " + key + " is not present").toString();
        }
        return " properties file is blank ";
    }
}
