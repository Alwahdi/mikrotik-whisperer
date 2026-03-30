package org.apache.http.impl.cookie;

import java.lang.ref.SoftReference;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import org.apache.http.annotation.Immutable;

@Immutable
public final class DateUtils {
    private static final String[] DEFAULT_PATTERNS = {PATTERN_RFC1036, "EEE, dd MMM yyyy HH:mm:ss zzz", PATTERN_ASCTIME};
    private static final Date DEFAULT_TWO_DIGIT_YEAR_START;
    public static final TimeZone GMT;
    public static final String PATTERN_ASCTIME = "EEE MMM d HH:mm:ss yyyy";
    public static final String PATTERN_RFC1036 = "EEEE, dd-MMM-yy HH:mm:ss zzz";
    public static final String PATTERN_RFC1123 = "EEE, dd MMM yyyy HH:mm:ss zzz";

    static {
        TimeZone timeZone = TimeZone.getTimeZone("GMT");
        GMT = timeZone;
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(timeZone);
        calendar.set(2000, 0, 1, 0, 0, 0);
        calendar.set(14, 0);
        DEFAULT_TWO_DIGIT_YEAR_START = calendar.getTime();
    }

    public static Date parseDate(String dateValue) throws DateParseException {
        return parseDate(dateValue, (String[]) null, (Date) null);
    }

    public static Date parseDate(String dateValue, String[] dateFormats) throws DateParseException {
        return parseDate(dateValue, dateFormats, (Date) null);
    }

    public static Date parseDate(String dateValue, String[] dateFormats, Date startDate) throws DateParseException {
        if (dateValue != null) {
            if (dateFormats == null) {
                dateFormats = DEFAULT_PATTERNS;
            }
            if (startDate == null) {
                startDate = DEFAULT_TWO_DIGIT_YEAR_START;
            }
            if (dateValue.length() > 1 && dateValue.startsWith("'") && dateValue.endsWith("'")) {
                dateValue = dateValue.substring(1, dateValue.length() - 1);
            }
            String[] arr$ = dateFormats;
            int len$ = arr$.length;
            int i$ = 0;
            while (i$ < len$) {
                SimpleDateFormat dateParser = DateFormatHolder.formatFor(arr$[i$]);
                dateParser.set2DigitYearStart(startDate);
                try {
                    return dateParser.parse(dateValue);
                } catch (ParseException e) {
                    i$++;
                }
            }
            throw new DateParseException("Unable to parse the date " + dateValue);
        }
        throw new IllegalArgumentException("dateValue is null");
    }

    public static String formatDate(Date date) {
        return formatDate(date, "EEE, dd MMM yyyy HH:mm:ss zzz");
    }

    public static String formatDate(Date date, String pattern) {
        if (date == null) {
            throw new IllegalArgumentException("date is null");
        } else if (pattern != null) {
            return DateFormatHolder.formatFor(pattern).format(date);
        } else {
            throw new IllegalArgumentException("pattern is null");
        }
    }

    private DateUtils() {
    }

    static final class DateFormatHolder {
        private static final ThreadLocal<SoftReference<Map<String, SimpleDateFormat>>> THREADLOCAL_FORMATS = new ThreadLocal<SoftReference<Map<String, SimpleDateFormat>>>() {
            /* access modifiers changed from: protected */
            public SoftReference<Map<String, SimpleDateFormat>> initialValue() {
                return new SoftReference<>(new HashMap());
            }
        };

        DateFormatHolder() {
        }

        public static SimpleDateFormat formatFor(String pattern) {
            ThreadLocal<SoftReference<Map<String, SimpleDateFormat>>> threadLocal = THREADLOCAL_FORMATS;
            Map<String, SimpleDateFormat> formats = threadLocal.get().get();
            if (formats == null) {
                formats = new HashMap<>();
                threadLocal.set(new SoftReference(formats));
            }
            SimpleDateFormat format = formats.get(pattern);
            if (format != null) {
                return format;
            }
            SimpleDateFormat format2 = new SimpleDateFormat(pattern, Locale.US);
            format2.setTimeZone(TimeZone.getTimeZone("GMT"));
            formats.put(pattern, format2);
            return format2;
        }
    }
}
