package de.devcyntrix;

import de.devcyntrix.translation.FileLoader;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;

public class PropertiesFileLoader implements FileLoader {

    @Override
    public String getFilename(Locale locale) {
        return locale.getLanguage();
    }

    @Override
    public String getExtension() {
        return ".properties";
    }

    @Override
    public Map<String, String> load(Reader reader) {
        Properties properties = new Properties();
        try {
            properties.load(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Map<String, String> map = new HashMap<>();
        properties.forEach((o, o2) -> map.put(o.toString(), o2.toString()));
        return map;
    }
}
