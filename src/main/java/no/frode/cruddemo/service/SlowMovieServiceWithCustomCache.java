package no.frode.cruddemo.service;

import no.frode.cruddemo.cache.InMemCache;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cache.JCacheManagerCustomizer;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import javax.cache.CacheManager;
import javax.cache.configuration.MutableConfiguration;
import javax.cache.expiry.Duration;
import javax.cache.expiry.TouchedExpiryPolicy;

import static java.util.concurrent.TimeUnit.SECONDS;

@Service
public class SlowMovieServiceWithCustomCache {

    private static final Logger LOGGER = LoggerFactory.getLogger(SlowMovieService.class);

    @Autowired
    InMemCache cache;

    public String findMoveByDirector(String s) {

        LOGGER.info("findMoveByDirector s:{}",s);

        Object cacheResult = cache.get("director");

        if (cacheResult == null) {
            slowQuery(2000L);
            if (StringUtils.equals("Spielberg", s)) {
                cache.add("director", "indianaJones", 5000);
                System.out.println("__Cache size: "+cache.size());
                return "indianaJones";
            } else {
                return "unknown";
            }
        } else {
            cacheResult = cache.get("director");
            return (String) cacheResult;
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
