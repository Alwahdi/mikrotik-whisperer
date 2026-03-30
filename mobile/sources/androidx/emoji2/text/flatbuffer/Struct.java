package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

public class Struct {
    protected ByteBuffer bb;
    protected int bb_pos;

    /* access modifiers changed from: protected */
    public void __reset(int _i, ByteBuffer _bb) {
        this.bb = _bb;
        if (_bb != null) {
            this.bb_pos = _i;
        } else {
            this.bb_pos = 0;
        }
    }

    public void __reset() {
        __reset(0, (ByteBuffer) null);
    }
}
