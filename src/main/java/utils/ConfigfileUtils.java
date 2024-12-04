package utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigfileUtils {


    public Properties readConfig(String filename) throws Exception{

        filename = filename.trim();

        FileInputStream filestream = new FileInputStream(filename);

        Properties property = new Properties();

        property.load(filestream);

        return property;

    }
    
}
