package cz.geek.cache;

import java.util.Collections;
import java.util.Map;

import javax.cache.Cache;
import javax.cache.CacheManager;

import org.springframework.beans.factory.FactoryBean;

/**
 * Simple wrapper to expose a Cache in the Spring context.
 */
public class JCacheFactoryBean implements FactoryBean {

		protected Map<?,?> cacheProperties = Collections.emptyMap();
        
        public void setCacheProperties(Map<?,?> cacheProperties) {
                this.cacheProperties = cacheProperties;
        }
        
        public Object getObject() throws Exception {
                Cache cache = CacheManager.getInstance().getCacheFactory().createCache(cacheProperties);
                return cache;
        }

        public Class<Cache> getObjectType() {
                return Cache.class;
        }

        public boolean isSingleton() {
                return false;
        }

}
