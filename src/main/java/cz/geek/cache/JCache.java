package cz.geek.cache;

import java.io.Serializable;

public class JCache<K extends Serializable, V extends Serializable> implements Cache<K, V> {
	
	protected javax.cache.Cache cache;

	public void setCache(javax.cache.Cache cache) {
		this.cache = cache;
	}

	@SuppressWarnings("unchecked")
	public V get(K key) {
		return (V) cache.get(key);
	}

	public void put(K key, V value) {
		cache.put(key, value);
	}

	public boolean containsKey(K key) {
		return cache.containsKey(key);
	}

	public CacheStatistics getCacheStatistics() {
		javax.cache.CacheStatistics stat = cache.getCacheStatistics();
		int objectCount = -1;
		try {
			objectCount = stat.getObjectCount();
		} catch (Exception e) {	}
		return new CacheStatistics(objectCount, stat.getCacheHits(), stat.getCacheMisses());
	}

	public void clear() {
		cache.clear();
	}

	public javax.cache.Cache getCache() {
		return cache;
	}

}
