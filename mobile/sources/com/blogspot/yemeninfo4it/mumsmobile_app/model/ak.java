package com.blogspot.yemeninfo4it.mumsmobile_app.model;

public enum ak {
    DISCOVERY_TAG_MACADDR(1),
    DISCOVERY_TAG_CANUNPACK(2),
    DISCOVERY_TAG_HEADERUNPACK(3),
    DISCOVERY_TAG_DATAUNPACK(4),
    DISCOVERY_TAG_IDENTITY(5),
    DISCOVERY_TAG_PEEK(6),
    DISCOVERY_TAG_VERSION(7),
    DISCOVERY_TAG_PLATFORM(8),
    DISCOVERY_TAG_MAXAGRSIZE(9),
    DISCOVERY_TAG_UPTIME(10),
    DISCOVERY_TAG_SOFTWAREID(11),
    DISCOVERY_TAG_BOARDNAME(12),
    DISCOVERY_TAG_SWITCHBOARD(13),
    DISCOVERY_TAG_MAX(14);
    
    private final int o;

    private ak(int i) {
        this.o = i;
    }

    public int a() {
        return this.o;
    }
}
