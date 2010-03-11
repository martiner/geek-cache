package cz.geek.cache;

public class CacheStatistics {
	
	private long objects;
	private long hits;
	private long misses;
	
	public CacheStatistics(long objects, long hits, long misses) {
		super();
		this.objects = objects;
		this.hits = hits;
		this.misses = misses;
	}
	public long getObjects() {
		return objects;
	}
	public long getHits() {
		return hits;
	}
	public long getMisses() {
		return misses;
	}
}
