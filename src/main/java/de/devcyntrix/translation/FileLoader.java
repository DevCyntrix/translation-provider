package de.devcyntrix.translation;

import java.io.Reader;
import java.util.Locale;
import java.util.Map;

public interface FileLoader {

    String getFilename(Locale locale);

    String getExtension();

    Map<String, String> load(Reader reader);

}
