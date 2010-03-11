package cz.geek.cache;

import java.io.Serializable;

public class NoCache implements Cache<Serializable, Serializable> {

	private static final NoCache instance = new NoCache();
	
	private static final CacheStatistics statistics = new CacheStatistics(0, 0, 0);
	
	@SuppressWarnings("unchecked")
	public static <K extends Serializable, V extends Serializable> Cache<K,V> getInstance() {
		return (Cache<K,V>)instance;
	}
	
	public Serializable get(Serializable key) {
		return null;
	}

	public void put(Serializable key, Serializable value) {
	}

	public boolean containsKey(Serializable key) {
		return false;
	}

	public CacheStatistics getCacheStatistics() {
		return statistics;
	}

	public void clear() {
	}

	public Object getCache() {
		return this;
	}

}
