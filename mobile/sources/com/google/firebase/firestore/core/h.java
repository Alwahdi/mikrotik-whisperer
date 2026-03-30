package com.google.firebase.firestore.core;

import com.google.firebase.firestore.model.b;

public abstract class h {
    public abstract String a();

    public abstract boolean b(b bVar);

    public enum a {
        LESS_THAN("<"),
        LESS_THAN_OR_EQUAL("<="),
        EQUAL("=="),
        GREATER_THAN(">"),
        GREATER_THAN_OR_EQUAL(">="),
        ARRAY_CONTAINS("array_contains"),
        ARRAY_CONTAINS_ANY("array_contains_any"),
        IN("in");
        
        private final String text;

        private a(String text2) {
            this.text = text2;
        }

        public String toString() {
            return this.text;
        }
    }
}
