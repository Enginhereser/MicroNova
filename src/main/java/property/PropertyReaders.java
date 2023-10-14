package property;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyReaders {

    Properties properties=new Properties();
    FileReader reader;

    String file;

    public PropertyReaders(String fileName){

        try {
            file="src/test/resources/datafiles/"+fileName+".properties";
            reader=new FileReader(file);
            properties.load(reader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public static PropertyReaders read(String fileName){
        return new PropertyReaders(fileName);
    }
    public static PropertyReaders read(){
        return read("config");
    }

    public String get(String key){
        return properties.getProperty(key);
    }
    public void set(String key,String value){
        properties.setProperty(key,value);
    }
}
