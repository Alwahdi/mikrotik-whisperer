package me.legrange.mikrotik.impl;

abstract class j {
    private String a;

    public String a() {
        return this.a;
    }

    public String toString() {
        return String.format("%s: tag=%s", new Object[]{getClass().getSimpleName(), this.a});
    }

    /* access modifiers changed from: package-private */
    public void b(String tag) {
        this.a = tag;
    }

    protected j(String tag) {
        this.a = tag;
    }
}
