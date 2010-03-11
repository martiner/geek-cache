package cz.geek.cache;

import java.io.Serializable;

import net.sf.ehcache.Element;
import net.sf.ehcache.Statistics;

public class EhCache<K extends Serializable, V extends Serializable> implements Cache<K, V> {
	
	private net.sf.ehcache.Cache cache;

	public void setCache(net.sf.ehcache.Cache cache) {
		this.cache = cache;
	}

	@SuppressWarnings("unchecked")
	public V get(K key) {
		Element element = cache.get(key);
		return (V) (element != null ? element.getValue() : null);
	}

	public void put(K key, V value) {
		cache.put(new Element(key, value));
	}

	public boolean containsKey(K key) {
		return cache.isKeyInCache(key);
	}

	public CacheStatistics getCacheStatistics() {
		Statistics statistics = cache.getStatistics();
		return new CacheStatistics(statistics.getObjectCount(), statistics.getCacheHits(), statistics.getCacheMisses());
	}

	public void clear() {
		cache.removeAll();
	}

	public net.sf.ehcache.Cache getCache() {
		return cache;
	}
	

}
