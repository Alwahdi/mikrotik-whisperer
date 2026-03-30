package me.legrange.mikrotik.impl;

class g {
    private String a;
    private String b;

    public String toString() {
        if (!c()) {
            return this.a;
        }
        return String.format("%s=%s", new Object[]{this.a, this.b});
    }

    g(String name, String value) {
        this.a = name;
        this.b = value;
    }

    g(String name) {
        this(name, (String) null);
    }

    /* access modifiers changed from: package-private */
    public boolean c() {
        return this.b != null;
    }

    /* access modifiers changed from: package-private */
    public String a() {
        return this.a;
    }

    /* access modifiers changed from: package-private */
    public String b() {
        return this.b;
    }
}
