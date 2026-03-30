package androidx.profileinstaller;

import androidx.annotation.NonNull;
import java.util.TreeMap;

class DexProfileData {
    @NonNull
    final String apkName;
    int classSetSize;
    @NonNull
    int[] classes;
    final long dexChecksum;
    @NonNull
    final String dexName;
    final int hotMethodRegionSize;
    long mTypeIdCount;
    @NonNull
    final TreeMap<Integer, Integer> methods;
    final int numMethodIds;

    DexProfileData(@NonNull String apkName2, @NonNull String dexName2, long dexChecksum2, long typeIdCount, int classSetSize2, int hotMethodRegionSize2, int numMethodIds2, @NonNull int[] classes2, @NonNull TreeMap<Integer, Integer> methods2) {
        this.apkName = apkName2;
        this.dexName = dexName2;
        this.dexChecksum = dexChecksum2;
        this.mTypeIdCount = typeIdCount;
        this.classSetSize = classSetSize2;
        this.hotMethodRegionSize = hotMethodRegionSize2;
        this.numMethodIds = numMethodIds2;
        this.classes = classes2;
        this.methods = methods2;
    }
}
