package no.frode.cruddemo.service;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.cache.JCacheManagerCustomizer;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.cache.annotation.Cacheable;

import javax.cache.CacheManager;
import javax.cache.annotation.CacheDefaults;
import javax.cache.annotation.CacheResult;
import javax.cache.configuration.MutableConfiguration;
import javax.cache.expiry.Duration;
import javax.cache.expiry.TouchedExpiryPolicy;

import static java.util.concurrent.TimeUnit.SECONDS;

@Service
@CacheDefaults(cacheName = "movies")
public class SlowMovieService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SlowMovieService.class);

    //create cache
    @Component
    public static class CachingSetup implements JCacheManagerCustomizer
    {
        @Override
        public void customize(CacheManager cacheManager) {
            Duration cacheDuration = new Duration(SECONDS, 10);
            cacheManager.createCache("movies", new MutableConfiguration<>()
                    .setExpiryPolicyFactory(TouchedExpiryPolicy.factoryOf(cacheDuration))
                    .setStoreByValue(false)
                    .setStatisticsEnabled(true));
        }
    }

    @CacheResult
    public String findMoveByDirector(String s) {

        LOGGER.info("findMoveByDirector s:{}",s);

        slowQuery(2000L);
        if (StringUtils.equals("Spielberg", s)) {
            return "indianaJones";
        } else {
            return "unknown";
        }

    }

    private void slowQuery(long seconds){
        try {
            Thread.sleep(seconds);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }
}
