package defpackage;

/* renamed from: ke  reason: default package */
public class ke extends xc {
    float a = -1.0f;

    public void a(kl0 shapePath, float angle, float interpolation, float radius) {
        shapePath.o(0.0f, radius * interpolation, 180.0f, 180.0f - angle);
        shapePath.m((float) (Math.sin(Math.toRadians((double) angle)) * ((double) radius) * ((double) interpolation)), (float) (Math.sin(Math.toRadians((double) (90.0f - angle))) * ((double) radius) * ((double) interpolation)));
    }
}
