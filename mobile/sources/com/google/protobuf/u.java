package com.google.protobuf;

abstract class u {

    private interface b {
        byte a(int i);

        int size();
    }

    static String b(b input) {
        StringBuilder builder = new StringBuilder(input.size());
        for (int i = 0; i < input.size(); i++) {
            byte b2 = input.a(i);
            switch (b2) {
                case 7:
                    builder.append("\\a");
                    break;
                case 8:
                    builder.append("\\b");
                    break;
                case 9:
                    builder.append("\\t");
                    break;
                case 10:
                    builder.append("\\n");
                    break;
                case 11:
                    builder.append("\\v");
                    break;
                case 12:
                    builder.append("\\f");
                    break;
                case 13:
                    builder.append("\\r");
                    break;
                case 34:
                    builder.append("\\\"");
                    break;
                case 39:
                    builder.append("\\'");
                    break;
                case 92:
                    builder.append("\\\\");
                    break;
                default:
                    if (b2 >= 32 && b2 <= 126) {
                        builder.append((char) b2);
                        break;
                    } else {
                        builder.append('\\');
                        builder.append((char) (((b2 >>> 6) & 3) + 48));
                        builder.append((char) (((b2 >>> 3) & 7) + 48));
                        builder.append((char) ((b2 & 7) + 48));
                        break;
                    }
            }
        }
        return builder.toString();
    }

    static class a implements b {
        final /* synthetic */ e a;

        a(e eVar) {
            this.a = eVar;
        }

        public int size() {
            return this.a.size();
        }

        public byte a(int offset) {
            return this.a.b(offset);
        }
    }

    static String a(e input) {
        return b(new a(input));
    }

    static String c(String input) {
        return a(e.m(input));
    }
}
