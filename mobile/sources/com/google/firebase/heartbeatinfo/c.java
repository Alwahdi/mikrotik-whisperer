package com.google.firebase.heartbeatinfo;

public interface c {
    a a(String str);

    public enum a {
        NONE(0),
        SDK(1),
        GLOBAL(2),
        COMBINED(3);
        
        private final int code;

        private a(int code2) {
            this.code = code2;
        }

        public int getCode() {
            return this.code;
        }
    }
}
