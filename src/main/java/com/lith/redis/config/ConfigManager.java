package com.lith.redis.config;

import com.lith.lithcore.abstractClasses.AbstractConfigManager;
import com.lith.redis.Plugin;
import com.lith.redis.Static;

public class ConfigManager extends AbstractConfigManager<Plugin, ConfigManager> {
    private String host, password;
    private Integer port;

    public ConfigManager(final Plugin plugin) {
        super(plugin);

        this.getConfigs();
    }

    public String host() {
        return this.host;
    }

    public int port() {
        return this.port;
    }

    public String password() {
        return this.password;
    }

    private void getConfigs() {
        this.host = this.config.getString(Static.ConfigKeys.HOST);
        this.password = this.config.getString(Static.ConfigKeys.PASSWORD);
        this.port = this.config.getInt(Static.ConfigKeys.PORT);
    }
}
