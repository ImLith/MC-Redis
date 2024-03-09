package com.lith.redis;

import org.bukkit.plugin.java.JavaPlugin;

public class Plugin extends JavaPlugin {
  public void onEnable() {
    Static.log.info("Plugin enabled");
  }

  public void onDisable() {
    Static.log.info("Plugin disabled");
  }
}
