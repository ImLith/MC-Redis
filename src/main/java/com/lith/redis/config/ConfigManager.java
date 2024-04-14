package com.lith.redis.config;

import com.lith.lithcore.abstractClasses.AbstractConfigManager;
import com.lith.redis.Plugin;
import com.lith.redis.Static;
import lombok.Getter;

public class ConfigManager extends AbstractConfigManager<Plugin, ConfigManager> {
    @Getter
    private String host, password;
    @Getter
    private Integer port;

    public ConfigManager(final Plugin plugin) {
        super(plugin);

        this.getConfigs();
    }

    private void getConfigs() {
        this.host = this.config.getString(Static.ConfigKeys.HOST);
        this.password = this.config.getString(Static.ConfigKeys.PASSWORD);
        this.port = this.config.getInt(Static.ConfigKeys.PORT);
    }
}
