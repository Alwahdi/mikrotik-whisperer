package me.legrange.mikrotik.impl;

class f extends j {
    private String b;

    f(String tag, String message) {
        super(tag);
        this.b = message;
    }

    f() {
        super((String) null);
    }

    /* access modifiers changed from: package-private */
    public String c() {
        return this.b;
    }

    /* access modifiers changed from: package-private */
    public void d(String message) {
        this.b = message;
    }
}
