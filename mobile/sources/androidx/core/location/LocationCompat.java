package androidx.core.location;

import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import androidx.annotation.DoNotInline;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.util.Preconditions;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public final class LocationCompat {
    public static final String EXTRA_BEARING_ACCURACY = "bearingAccuracy";
    public static final String EXTRA_IS_MOCK = "mockLocation";
    public static final String EXTRA_MSL_ALTITUDE = "androidx.core.location.extra.MSL_ALTITUDE";
    public static final String EXTRA_MSL_ALTITUDE_ACCURACY = "androidx.core.location.extra.MSL_ALTITUDE_ACCURACY";
    public static final String EXTRA_SPEED_ACCURACY = "speedAccuracy";
    public static final String EXTRA_VERTICAL_ACCURACY = "verticalAccuracy";
    @Nullable
    private static Method sSetIsFromMockProviderMethod;

    private LocationCompat() {
    }

    public static long getElapsedRealtimeNanos(@NonNull Location location) {
        if (Build.VERSION.SDK_INT >= 17) {
            return Api17Impl.getElapsedRealtimeNanos(location);
        }
        return TimeUnit.MILLISECONDS.toNanos(getElapsedRealtimeMillis(location));
    }

    public static long getElapsedRealtimeMillis(@NonNull Location location) {
        if (Build.VERSION.SDK_INT >= 17) {
            return TimeUnit.NANOSECONDS.toMillis(Api17Impl.getElapsedRealtimeNanos(location));
        }
        long timeDeltaMs = System.currentTimeMillis() - location.getTime();
        long elapsedRealtimeMs = SystemClock.elapsedRealtime();
        if (timeDeltaMs < 0) {
            return elapsedRealtimeMs;
        }
        if (timeDeltaMs > elapsedRealtimeMs) {
            return 0;
        }
        return elapsedRealtimeMs - timeDeltaMs;
    }

    public static boolean hasVerticalAccuracy(@NonNull Location location) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.hasVerticalAccuracy(location);
        }
        return containsExtra(location, EXTRA_VERTICAL_ACCURACY);
    }

    public static float getVerticalAccuracyMeters(@NonNull Location location) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.getVerticalAccuracyMeters(location);
        }
        Bundle extras = location.getExtras();
        if (extras == null) {
            return 0.0f;
        }
        return extras.getFloat(EXTRA_VERTICAL_ACCURACY, 0.0f);
    }

    public static void setVerticalAccuracyMeters(@NonNull Location location, float verticalAccuracyM) {
        if (Build.VERSION.SDK_INT >= 26) {
            Api26Impl.setVerticalAccuracyMeters(location, verticalAccuracyM);
        } else {
            getOrCreateExtras(location).putFloat(EXTRA_VERTICAL_ACCURACY, verticalAccuracyM);
        }
    }

    public static boolean hasSpeedAccuracy(@NonNull Location location) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.hasSpeedAccuracy(location);
        }
        return containsExtra(location, EXTRA_SPEED_ACCURACY);
    }

    public static float getSpeedAccuracyMetersPerSecond(@NonNull Location location) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.getSpeedAccuracyMetersPerSecond(location);
        }
        Bundle extras = location.getExtras();
        if (extras == null) {
            return 0.0f;
        }
        return extras.getFloat(EXTRA_SPEED_ACCURACY, 0.0f);
    }

    public static void setSpeedAccuracyMetersPerSecond(@NonNull Location location, float speedAccuracyMps) {
        if (Build.VERSION.SDK_INT >= 26) {
            Api26Impl.setSpeedAccuracyMetersPerSecond(location, speedAccuracyMps);
        } else {
            getOrCreateExtras(location).putFloat(EXTRA_SPEED_ACCURACY, speedAccuracyMps);
        }
    }

    public static boolean hasBearingAccuracy(@NonNull Location location) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.hasBearingAccuracy(location);
        }
        return containsExtra(location, EXTRA_BEARING_ACCURACY);
    }

    public static float getBearingAccuracyDegrees(@NonNull Location location) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.getBearingAccuracyDegrees(location);
        }
        Bundle extras = location.getExtras();
        if (extras == null) {
            return 0.0f;
        }
        return extras.getFloat(EXTRA_BEARING_ACCURACY, 0.0f);
    }

    public static void setBearingAccuracyDegrees(@NonNull Location location, float bearingAccuracyD) {
        if (Build.VERSION.SDK_INT >= 26) {
            Api26Impl.setBearingAccuracyDegrees(location, bearingAccuracyD);
        } else {
            getOrCreateExtras(location).putFloat(EXTRA_BEARING_ACCURACY, bearingAccuracyD);
        }
    }

    public static double getMslAltitudeMeters(@NonNull Location location) {
        Preconditions.checkState(hasMslAltitude(location), "The Mean Sea Level altitude of the location is not set.");
        return getOrCreateExtras(location).getDouble(EXTRA_MSL_ALTITUDE);
    }

    public static void setMslAltitudeMeters(@NonNull Location location, double mslAltitudeMeters) {
        getOrCreateExtras(location).putDouble(EXTRA_MSL_ALTITUDE, mslAltitudeMeters);
    }

    public static boolean hasMslAltitude(@NonNull Location location) {
        return containsExtra(location, EXTRA_MSL_ALTITUDE);
    }

    public static void removeMslAltitude(@NonNull Location location) {
        removeExtra(location, EXTRA_MSL_ALTITUDE);
    }

    @FloatRange(from = 0.0d)
    public static float getMslAltitudeAccuracyMeters(@NonNull Location location) {
        Preconditions.checkState(hasMslAltitudeAccuracy(location), "The Mean Sea Level altitude accuracy of the location is not set.");
        return getOrCreateExtras(location).getFloat(EXTRA_MSL_ALTITUDE_ACCURACY);
    }

    public static void setMslAltitudeAccuracyMeters(@NonNull Location location, @FloatRange(from = 0.0d) float mslAltitudeAccuracyMeters) {
        getOrCreateExtras(location).putFloat(EXTRA_MSL_ALTITUDE_ACCURACY, mslAltitudeAccuracyMeters);
    }

    public static boolean hasMslAltitudeAccuracy(@NonNull Location location) {
        return containsExtra(location, EXTRA_MSL_ALTITUDE_ACCURACY);
    }

    public static void removeMslAltitudeAccuracy(@NonNull Location location) {
        removeExtra(location, EXTRA_MSL_ALTITUDE_ACCURACY);
    }

    public static boolean isMock(@NonNull Location location) {
        if (Build.VERSION.SDK_INT >= 18) {
            return Api18Impl.isMock(location);
        }
        Bundle extras = location.getExtras();
        if (extras == null) {
            return false;
        }
        return extras.getBoolean(EXTRA_IS_MOCK, false);
    }

    public static void setMock(@NonNull Location location, boolean mock) {
        if (Build.VERSION.SDK_INT >= 18) {
            try {
                getSetIsFromMockProviderMethod().invoke(location, new Object[]{Boolean.valueOf(mock)});
            } catch (NoSuchMethodException e) {
                Error error = new NoSuchMethodError();
                error.initCause(e);
                throw error;
            } catch (IllegalAccessException e2) {
                Error error2 = new IllegalAccessError();
                error2.initCause(e2);
                throw error2;
            } catch (InvocationTargetException e3) {
                throw new RuntimeException(e3);
            }
        } else {
            Bundle extras = location.getExtras();
            if (extras == null) {
                if (mock) {
                    Bundle extras2 = new Bundle();
                    extras2.putBoolean(EXTRA_IS_MOCK, true);
                    location.setExtras(extras2);
                }
            } else if (mock) {
                extras.putBoolean(EXTRA_IS_MOCK, true);
            } else {
                extras.remove(EXTRA_IS_MOCK);
                if (extras.isEmpty()) {
                    location.setExtras((Bundle) null);
                }
            }
        }
    }

    @RequiresApi(26)
    private static class Api26Impl {
        private Api26Impl() {
        }

        @DoNotInline
        static boolean hasVerticalAccuracy(Location location) {
            return location.hasVerticalAccuracy();
        }

        @DoNotInline
        static float getVerticalAccuracyMeters(Location location) {
            return location.getVerticalAccuracyMeters();
        }

        @DoNotInline
        static void setVerticalAccuracyMeters(Location location, float verticalAccuracyM) {
            location.setVerticalAccuracyMeters(verticalAccuracyM);
        }

        @DoNotInline
        static boolean hasSpeedAccuracy(Location location) {
            return location.hasSpeedAccuracy();
        }

        @DoNotInline
        static float getSpeedAccuracyMetersPerSecond(Location location) {
            return location.getSpeedAccuracyMetersPerSecond();
        }

        @DoNotInline
        static void setSpeedAccuracyMetersPerSecond(Location location, float speedAccuracyMps) {
            location.setSpeedAccuracyMetersPerSecond(speedAccuracyMps);
        }

        @DoNotInline
        static boolean hasBearingAccuracy(Location location) {
            return location.hasBearingAccuracy();
        }

        @DoNotInline
        static float getBearingAccuracyDegrees(Location location) {
            return location.getBearingAccuracyDegrees();
        }

        @DoNotInline
        static void setBearingAccuracyDegrees(Location location, float bearingAccuracyD) {
            location.setBearingAccuracyDegrees(bearingAccuracyD);
        }
    }

    @RequiresApi(18)
    private static class Api18Impl {
        private Api18Impl() {
        }

        @DoNotInline
        static boolean isMock(Location location) {
            return location.isFromMockProvider();
        }
    }

    @RequiresApi(17)
    private static class Api17Impl {
        private Api17Impl() {
        }

        @DoNotInline
        static long getElapsedRealtimeNanos(Location location) {
            return location.getElapsedRealtimeNanos();
        }
    }

    private static Method getSetIsFromMockProviderMethod() throws NoSuchMethodException {
        if (sSetIsFromMockProviderMethod == null) {
            Method declaredMethod = Location.class.getDeclaredMethod("setIsFromMockProvider", new Class[]{Boolean.TYPE});
            sSetIsFromMockProviderMethod = declaredMethod;
            declaredMethod.setAccessible(true);
        }
        return sSetIsFromMockProviderMethod;
    }

    private static Bundle getOrCreateExtras(@NonNull Location location) {
        Bundle extras = location.getExtras();
        if (extras != null) {
            return extras;
        }
        location.setExtras(new Bundle());
        return location.getExtras();
    }

    private static boolean containsExtra(@NonNull Location location, String key) {
        Bundle extras = location.getExtras();
        return extras != null && extras.containsKey(key);
    }

    private static void removeExtra(@NonNull Location location, String key) {
        Bundle extras = location.getExtras();
        if (extras != null) {
            extras.remove(key);
            if (extras.isEmpty()) {
                location.setExtras((Bundle) null);
            }
        }
    }
}
