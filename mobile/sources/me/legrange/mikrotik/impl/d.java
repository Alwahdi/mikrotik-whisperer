package me.legrange.mikrotik.impl;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class d {
    private final String a;

    /* renamed from: a  reason: collision with other field name */
    private final List<g> f4342a = new LinkedList();
    private String b;

    /* renamed from: b  reason: collision with other field name */
    private final List<String> f4343b = new LinkedList();
    private final List<String> c = new LinkedList();

    public String toString() {
        return String.format("cmd[%s] = %s, params = %s, queries = %s, props=%s ", new Object[]{this.b, this.a, this.f4342a, this.f4343b, this.c});
    }

    d(String cmd) {
        if (!cmd.startsWith("/")) {
            cmd = "/" + cmd;
        }
        this.a = cmd;
    }

    /* access modifiers changed from: package-private */
    public String e() {
        return this.a;
    }

    /* access modifiers changed from: package-private */
    public void a(String name, String value) {
        this.f4342a.add(new g(name, value));
    }

    /* access modifiers changed from: package-private */
    public void b(g param) {
        this.f4342a.add(param);
    }

    /* access modifiers changed from: package-private */
    public void c(String... names) {
        this.c.addAll(Arrays.asList(names));
    }

    /* access modifiers changed from: package-private */
    public void d(String... queries) {
        this.f4343b.addAll(Arrays.asList(queries));
    }

    /* access modifiers changed from: package-private */
    public void j(String tag) {
        this.b = tag;
    }

    /* access modifiers changed from: package-private */
    public List<String> h() {
        return this.f4343b;
    }

    /* access modifiers changed from: package-private */
    public String i() {
        return this.b;
    }

    /* access modifiers changed from: package-private */
    public List<String> g() {
        return this.c;
    }

    /* access modifiers changed from: package-private */
    public List<g> f() {
        return this.f4342a;
    }
}
