package com.lith.redis;

import com.lith.lithcore.abstractClasses.MainPlugin;
import com.lith.redis.classes.RedisDb;
import com.lith.redis.config.ConfigManager;

public class Plugin extends MainPlugin<ConfigManager> {
  public static Plugin plugin;

  public void onEnable() {
    Plugin.plugin = this;
    new ConfigManager(this);
    RedisDb.init().connect();
    Static.log.info("Plugin enabled");
  }

  public void onDisable() {
    RedisDb.init().disconnect();
    Static.log.info("Plugin disabled");
  }
}
