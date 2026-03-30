package androidx.core.net;

import android.net.Uri;
import java.io.File;

public final class UriKt {
    public static final Uri toUri(String $this$toUri) {
        lu.f($this$toUri, "<this>");
        Uri parse = Uri.parse($this$toUri);
        lu.e(parse, "parse(this)");
        return parse;
    }

    public static final Uri toUri(File $this$toUri) {
        lu.f($this$toUri, "<this>");
        Uri fromFile = Uri.fromFile($this$toUri);
        lu.e(fromFile, "fromFile(this)");
        return fromFile;
    }

    public static final File toFile(Uri $this$toFile) {
        lu.f($this$toFile, "<this>");
        if (lu.a($this$toFile.getScheme(), "file")) {
            String path = $this$toFile.getPath();
            if (path != null) {
                return new File(path);
            }
            throw new IllegalArgumentException(("Uri path is null: " + $this$toFile).toString());
        }
        throw new IllegalArgumentException(("Uri lacks 'file' scheme: " + $this$toFile).toString());
    }
}
