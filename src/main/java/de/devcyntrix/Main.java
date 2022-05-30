package de.devcyntrix;

import de.devcyntrix.translation.LazyFileTranslationProvider;
import de.devcyntrix.translation.TranslationManager;

import java.io.File;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {

        File file = new File("lang");

        LazyFileTranslationProvider registry = new LazyFileTranslationProvider(file, new PropertiesFileLoader());

        TranslationManager manager = new TranslationManager(Locale.GERMANY, registry);
        Locale l = Locale.US;

        int old = 1;

        String message = manager.getMessage(l, "test.text." + (old == 1 ? "year" : "years"), old);
        System.out.println(message);
    }
}