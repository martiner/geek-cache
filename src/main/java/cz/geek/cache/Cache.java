package cz.geek.cache;

import java.io.Serializable;

public interface Cache<K extends Serializable, V extends Serializable> {

	V get(K key);
	
	void put(K key, V value);
	
	boolean containsKey(K key);
	
	void clear();
	
	CacheStatistics getCacheStatistics();
	
	Object getCache();
}
