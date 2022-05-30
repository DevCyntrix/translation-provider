package de.devcyntrix.translation;

import org.apache.commons.text.StringSubstitutor;

import java.text.MessageFormat;
import java.util.Map;

public class MapTranslator implements Translator {

    private final Map<String, String> map;

    public MapTranslator(Map<String, String> map) {
        this.map = map;
    }

    @Override
    public String format(String key, Object... arguments) {
        StringSubstitutor sub = new StringSubstitutor(map);
        String value = map.getOrDefault(key, key);
        value = sub.replace(value);
        MessageFormat format = new MessageFormat(value);
        return format.format(arguments);
    }
}
