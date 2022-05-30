package de.devcyntrix.translation;

import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;
import java.util.Map;

public class LazyFileTranslationProvider extends LazyTranslationProvider {
    private final File folder;
    private final FileLoader loader;

    public LazyFileTranslationProvider(File folder, FileLoader loader) {
        this.folder = folder;
        this.loader = loader;
    }

    @Override
    protected @Nullable MapTranslator initTranslator(Locale locale) {
        String name = loader.getFilename(locale);
        File file = new File(folder, name + loader.getExtension());
        if (!file.isFile())
            return null;
        try (FileReader reader = new FileReader(file)) {
            Map<String, String> map = loader.load(reader);
            return new MapTranslator(map);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
