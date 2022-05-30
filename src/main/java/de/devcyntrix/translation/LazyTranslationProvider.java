package de.devcyntrix.translation;

import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public abstract class LazyTranslationProvider implements TranslationProvider {

    private final Map<Locale, Translator> map = new HashMap<>();

    protected abstract @Nullable Translator initTranslator(Locale locale);

    @Override
    public @Nullable Translator getTranslator(Locale locale) {
        return this.map.computeIfAbsent(locale, this::initTranslator);
    }

}
