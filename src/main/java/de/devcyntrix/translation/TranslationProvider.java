package de.devcyntrix.translation;

import org.jetbrains.annotations.Nullable;

import java.util.Locale;

public interface TranslationProvider {
    @Nullable Translator getTranslator(Locale locale);
}
