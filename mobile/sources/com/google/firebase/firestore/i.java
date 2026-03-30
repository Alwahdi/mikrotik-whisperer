package com.google.firebase.firestore;

import android.util.SparseArray;
import androidx.annotation.NonNull;
import com.google.firebase.firestore.FirebaseFirestoreException;

public class i extends wl {
    private final a a;

    public enum a {
        OK(0),
        CANCELLED(1),
        UNKNOWN(2),
        INVALID_ARGUMENT(3),
        DEADLINE_EXCEEDED(4),
        NOT_FOUND(5),
        ALREADY_EXISTS(6),
        PERMISSION_DENIED(7),
        RESOURCE_EXHAUSTED(8),
        FAILED_PRECONDITION(9),
        ABORTED(10),
        OUT_OF_RANGE(11),
        UNIMPLEMENTED(12),
        INTERNAL(13),
        UNAVAILABLE(14),
        DATA_LOSS(15),
        UNAUTHENTICATED(16);
        
        private static final SparseArray<a> STATUS_LIST = null;
        private final int value;

        static {
            STATUS_LIST = buildStatusList();
        }

        private a(int value2) {
            this.value = value2;
        }

        public int value() {
            return this.value;
        }

        private static SparseArray<a> buildStatusList() {
            SparseArray<FirebaseFirestoreException.Code> codes = new SparseArray<>();
            a[] values = values();
            int length = values.length;
            int i = 0;
            while (i < length) {
                a c = values[i];
                a existingValue = (a) codes.get(c.value());
                if (existingValue == null) {
                    codes.put(c.value(), c);
                    i++;
                } else {
                    throw new IllegalStateException("Code value duplication between " + existingValue + "&" + c.name());
                }
            }
            return codes;
        }

        @NonNull
        public static a fromValue(int value2) {
            return STATUS_LIST.get(value2, UNKNOWN);
        }
    }

    public i(String detailMessage, a code) {
        super(detailMessage);
        v90.o(detailMessage, "Provided message must not be null.");
        n4.d(code != a.OK, "A FirebaseFirestoreException should never be thrown for OK", new Object[0]);
        this.a = (a) v90.o(code, "Provided code must not be null.");
    }

    public i(String detailMessage, a code, Throwable cause) {
        super(detailMessage, cause);
        v90.o(detailMessage, "Provided message must not be null.");
        n4.d(code != a.OK, "A FirebaseFirestoreException should never be thrown for OK", new Object[0]);
        this.a = (a) v90.o(code, "Provided code must not be null.");
    }
}
