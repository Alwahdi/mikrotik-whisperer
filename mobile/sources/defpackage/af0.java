package defpackage;

/* renamed from: af0  reason: default package */
public class af0 extends xc {
    float a = -1.0f;

    public void a(kl0 shapePath, float angle, float interpolation, float radius) {
        shapePath.o(0.0f, radius * interpolation, 180.0f, 180.0f - angle);
        shapePath.a(0.0f, 0.0f, radius * 2.0f * interpolation, 2.0f * radius * interpolation, 180.0f, angle);
    }
}
