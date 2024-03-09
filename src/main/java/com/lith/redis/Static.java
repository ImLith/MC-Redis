package com.lith.redis;

import java.util.logging.Logger;

public class Static {
    public static final String pluginName = "Redis";
    public static final Logger log = Logger.getLogger(Static.pluginName);

    public static class ConfigKeys {
        public static final String HOST = "host";
        public static final String PORT = "port";
        public static final String PASSWORD = "password";
    }
}
