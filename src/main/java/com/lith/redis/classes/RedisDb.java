package com.lith.redis.classes;

import redis.clients.jedis.Jedis;
import static com.lith.redis.Plugin.plugin;

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

    public boolean isOnline() {
        return this.jedis != null;
    }

    public void connect() {
        if (!isOnline()) {
            this.jedis = new Jedis(plugin.configs.getHost(), plugin.configs.getPort());
            this.jedis.auth(plugin.configs.getPassword());
        }
    }

    public void disconnect() {
        if (isOnline()) {
            this.jedis.close();
            this.jedis = null;
        }
    }

    public void set(String key, String value, long expiration) {
        this.throwNotConnected();
        this.jedis.set(key, value);

        if (expiration > 0L)
            this.jedis.expire(key, expiration);
    }

    public String get(String key) {
        this.throwNotConnected();
        return this.jedis.get(key);
    }

    public void del(String key) {
        this.throwNotConnected();
        this.jedis.del(key);
    }

    private void throwNotConnected() {
        if (jedis == null) {
            throw new IllegalStateException("Redis connection is not initialized");
        }
    }
}
