package com.itextpdf.text.pdf.fonts.otf;

import java.util.Arrays;
import java.util.List;

public enum a {
    BENGALI("beng", "bng2");
    
    private final List<String> codes;

    private a(String... codes2) {
        this.codes = Arrays.asList(codes2);
    }

    public boolean isSupported(String languageCode) {
        return this.codes.contains(languageCode);
    }
}
