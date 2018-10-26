package arem.project.currencyconverter.cache;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

@Component
public class CacheExchangeRates {

    @Value("${cache.expiration}")
        private int cacheExpiration;
    private Cache<String, BigDecimal> cacheExcRat;

    @PostConstruct
    public void CacheExchangeRates() {
        if (cacheExcRat == null) {
            cacheExcRat = CacheBuilder.newBuilder().expireAfterWrite(cacheExpiration, TimeUnit.MINUTES).build();
        }
    }
    
    public void setCacheExchangeRate(String currencyCode, BigDecimal exchangeRate) {
        cacheExcRat.put(currencyCode, exchangeRate);
    }

    public BigDecimal getCachedExchangeRate(String currencyCode) {
        return cacheExcRat.getIfPresent(currencyCode);
    }    
}
