package org.oldcode.javaweb;

import java.util.Map;

public class RouteParts {
    public String controller;
    public String method;
    public String version;
    public boolean valid;
    public Map<String, String> params; // these are specific to our naming scheme, not Servlet Request params

    public RouteParts(String c, String m, String v) {
        controller = c;
        method = m;
        version = v;
        params = null;
        valid = false;
    }
    public RouteParts(String c, String m) {
        this(c, m, null);
    }
    public RouteParts() {
        this(null, null, null);
    }
    public RouteParts(boolean valid) {
        controller = null;
        method = null;
        version = null;
        params = null;
        this.valid = valid;
    }

    public String toString() {
        return String.format("<RouteParts controller:%s method:%s version:%s params:null>", controller, method, version);
    }
}
