package com.lith.redis;

import com.lith.lithcore.abstractClasses.AbstractPlugin;
import com.lith.redis.classes.RedisDb;
import com.lith.redis.config.ConfigManager;

public class Plugin extends AbstractPlugin<Plugin, ConfigManager> {
  public static Plugin plugin;

  @Override
  public void onEnable() {
    plugin = this;
    configs = new ConfigManager(this);
    super.onEnable();
  }

  @Override
  public void onDisable() {
    RedisDb.init().disconnect();
    super.onDisable();
  }

  @Override
  protected void registerConfigs() {
    RedisDb.init().disconnect();
    super.registerConfigs();
    RedisDb.init().connect();
  }
}
