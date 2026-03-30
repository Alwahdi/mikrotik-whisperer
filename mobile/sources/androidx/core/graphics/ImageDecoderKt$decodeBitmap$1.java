package androidx.core.graphics;

import android.graphics.ImageDecoder;

public final class ImageDecoderKt$decodeBitmap$1 implements ImageDecoder.OnHeaderDecodedListener {
    final /* synthetic */ lo<ImageDecoder, ImageDecoder.ImageInfo, ImageDecoder.Source, jt0> $action;

    public ImageDecoderKt$decodeBitmap$1(lo<? super ImageDecoder, ? super ImageDecoder.ImageInfo, ? super ImageDecoder.Source, jt0> loVar) {
        this.$action = loVar;
    }

    public final void onHeaderDecoded(ImageDecoder decoder, ImageDecoder.ImageInfo info, ImageDecoder.Source source) {
        lu.f(decoder, "decoder");
        lu.f(info, "info");
        lu.f(source, "source");
        this.$action.a(decoder, info, source);
    }
}
