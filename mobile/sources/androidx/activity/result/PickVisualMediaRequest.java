package androidx.activity.result;

import androidx.activity.result.contract.ActivityResultContracts;

public final class PickVisualMediaRequest {
    private ActivityResultContracts.PickVisualMedia.VisualMediaType mediaType = ActivityResultContracts.PickVisualMedia.ImageAndVideo.INSTANCE;

    public final ActivityResultContracts.PickVisualMedia.VisualMediaType getMediaType() {
        return this.mediaType;
    }

    public final void setMediaType$activity_release(ActivityResultContracts.PickVisualMedia.VisualMediaType visualMediaType) {
        lu.f(visualMediaType, "<set-?>");
        this.mediaType = visualMediaType;
    }

    public static final class Builder {
        private ActivityResultContracts.PickVisualMedia.VisualMediaType mediaType = ActivityResultContracts.PickVisualMedia.ImageAndVideo.INSTANCE;

        public final Builder setMediaType(ActivityResultContracts.PickVisualMedia.VisualMediaType mediaType2) {
            lu.f(mediaType2, "mediaType");
            this.mediaType = mediaType2;
            return this;
        }

        public final PickVisualMediaRequest build() {
            PickVisualMediaRequest $this$build_u24lambda_u240 = new PickVisualMediaRequest();
            $this$build_u24lambda_u240.setMediaType$activity_release(this.mediaType);
            return $this$build_u24lambda_u240;
        }
    }
}
