package com.lith.redis.classes;

import com.lith.redis.Plugin;
import redis.clients.jedis.Jedis;

public class RedisDb {
    private static RedisDb redis = null;
    private Jedis jedis = null;

    private RedisDb() {
    }

    public static synchronized RedisDb init() {
        if (RedisDb.redis == null)
            RedisDb.redis = new RedisDb();

        return RedisDb.redis;
    }

    public void connect() {
        if (this.jedis == null) {
            this.jedis = new Jedis(Plugin.plugin.cm.host(), Plugin.plugin.cm.port());
            this.jedis.auth(Plugin.plugin.cm.password());
        }
    }

    public void disconnect() {
        if (this.jedis != null) {
            this.jedis.close();
            this.jedis = null;
        }
    }

    public void set(String key, String value) {
        this.throwNotConnected();
        this.jedis.set(key, value);
    }

    public String get(String key) {
        this.throwNotConnected();
        return this.jedis.get(key);
    }

    private void throwNotConnected() {
        if (jedis == null) {
            throw new IllegalStateException("Redis connection is not initialized");
        }
    }
}
