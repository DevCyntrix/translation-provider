package de.devcyntrix.translation;

import java.util.Locale;

public class TranslationManager {

    private final Locale defaultLocale;
    private final LazyTranslationProvider registry;

    public TranslationManager(Locale defaultLocale, LazyTranslationProvider registry) {
        this.defaultLocale = defaultLocale;
        this.registry = registry;
    }

    public String getMessage(Locale locale, String key, Object... args) {
        Translator translator = this.registry.getTranslator(locale);
        if (translator == null)
            translator = this.registry.getTranslator(defaultLocale);

        if (translator == null)
            return "Missing default lang";

        return translator.format(key, args);
    }
}
