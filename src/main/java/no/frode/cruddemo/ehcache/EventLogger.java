package no.frode.cruddemo.ehcache;

import org.ehcache.event.CacheEvent;
import org.ehcache.event.CacheEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EventLogger implements CacheEventListener<Object, Object>{

    private static final Logger LOGGER = LoggerFactory.getLogger(EventLogger.class);

    @Override
    public void onEvent(CacheEvent<?, ?> cacheEvent) {
        LOGGER.info("Event: " + cacheEvent.getType() +
                " Key: " + cacheEvent.getKey() + " old value: " + cacheEvent.getOldValue() + " new value: " + cacheEvent.getNewValue());
    }

}
