package org.oldcode.javaweb;

import java.util.Map;

public class RouteParts {
    public String controller;
    public String method;
    public String version;
    public boolean valid;
    public Map<String, String> params; // these are specific to our naming scheme, not Servlet Request params

    public RouteParts(String c, String m) {
        controller = c;
        method = m;
        params = null;
        valid = false;
    }

    public String toString() {
        return String.format("<RouteParts controller:%s method:%s params:null>", this.controller, this.method);
    }
}
