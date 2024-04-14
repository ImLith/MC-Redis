package com.lith.redis;

import com.lith.lithcore.abstractClasses.AbstractPlugin;
import com.lith.redis.classes.RedisDb;
import com.lith.redis.config.ConfigManager;

public class Plugin extends AbstractPlugin<Plugin, ConfigManager> {
  public static Plugin plugin;

  public void onEnable() {
    Plugin.plugin = this;
    new ConfigManager(this);
    RedisDb.init().connect();
    log.info("Plugin enabled");
  }

  public void onDisable() {
    RedisDb.init().disconnect();
    log.info("Plugin disabled");
  }
}
