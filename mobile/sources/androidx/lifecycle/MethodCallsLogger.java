package androidx.lifecycle;

import androidx.annotation.RestrictTo;
import java.util.HashMap;
import java.util.Map;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class MethodCallsLogger {
    private final Map<String, Integer> calledMethods = new HashMap();

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean approveCall(String name, int type) {
        lu.f(name, "name");
        Integer nullableMask = this.calledMethods.get(name);
        int mask = nullableMask != null ? nullableMask.intValue() : 0;
        boolean wasCalled = (mask & type) != 0;
        this.calledMethods.put(name, Integer.valueOf(mask | type));
        if (!wasCalled) {
            return true;
        }
        return false;
    }
}
