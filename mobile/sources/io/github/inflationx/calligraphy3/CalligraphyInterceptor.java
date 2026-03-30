package io.github.inflationx.calligraphy3;

import defpackage.au;

public class CalligraphyInterceptor implements au {
    private final Calligraphy calligraphy;

    public CalligraphyInterceptor(CalligraphyConfig calligraphyConfig) {
        this.calligraphy = new Calligraphy(calligraphyConfig);
    }

    public os intercept(au.a chain) {
        os result = chain.a(chain.b());
        return result.d().b(this.calligraphy.onViewCreated(result.e(), result.b(), result.a())).a();
    }
}
