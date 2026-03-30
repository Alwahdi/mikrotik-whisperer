package defpackage;

/* renamed from: cp  reason: default package */
public class cp implements Comparable<cp> {
    private final double a;
    private final double b;

    public cp(double latitude, double longitude) {
        if (Double.isNaN(latitude) || latitude < -90.0d || latitude > 90.0d) {
            throw new IllegalArgumentException("Latitude must be in the range of [-90, 90]");
        } else if (Double.isNaN(longitude) || longitude < -180.0d || longitude > 180.0d) {
            throw new IllegalArgumentException("Longitude must be in the range of [-180, 180]");
        } else {
            this.a = latitude;
            this.b = longitude;
        }
    }

    public double b() {
        return this.a;
    }

    public double c() {
        return this.b;
    }

    /* renamed from: a */
    public int compareTo(cp other) {
        int comparison = qu0.c(this.a, other.a);
        if (comparison == 0) {
            return qu0.c(this.b, other.b);
        }
        return comparison;
    }

    public String toString() {
        return "GeoPoint { latitude=" + this.a + ", longitude=" + this.b + " }";
    }

    public boolean equals(Object o) {
        if (!(o instanceof cp)) {
            return false;
        }
        cp geoPoint = (cp) o;
        if (this.a == geoPoint.a && this.b == geoPoint.b) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long temp = Double.doubleToLongBits(this.a);
        long temp2 = Double.doubleToLongBits(this.b);
        return (((int) ((temp >>> 32) ^ temp)) * 31) + ((int) ((temp2 >>> 32) ^ temp2));
    }
}
