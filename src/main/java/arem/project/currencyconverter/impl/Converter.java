package arem.project.currencyconverter.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import arem.project.currencyconverter.cache.CacheExchangeRates;
import arem.project.currencyconverter.model.Features;
import arem.project.currencyconverter.model.Result;
import arem.project.currencyconverter.api.Connection;
import arem.project.currencyconverter.api.Currency;

@Component
public class Converter {

    @Autowired
    private Environment env;

    @Autowired
    private CacheExchangeRates cacheExcRat;

    //@Override
    public arem.project.currencyconverter.model.Exchange getConverterExchange() {
        arem.project.currencyconverter.model.Exchange cm = new arem.project.currencyconverter.model.Exchange();
        return cm;
    }

    //@Override
    public Result getConvertedValue(Currency source, Currency target, BigDecimal amount) {

        Result res = new Result();

        String rateKey = source.getCurrencyCode() + target.getCurrencyCode();
        BigDecimal cachedRate = cacheExcRat.getCachedExchangeRate(rateKey);
        if (null != cachedRate) {
            res.setConvertedCurrency(cachedRate.multiply(amount));
            //System.out.println("Returing data for " + rateKey + " from Cache");
            return res;
        }

        MultiValueMap<String, String> uriVariables = new LinkedMultiValueMap<String, String>();
        uriVariables.add("access_key", env.getProperty(Connection.API_KEY));
        uriVariables.add("currencies", target.getCurrencyCode());
        uriVariables.add("source", source.getCurrencyCode());
        uriVariables.add("format", "1");

        UriComponents uriComponents = UriComponentsBuilder.fromHttpUrl(env.getProperty(Connection.API_BASE_URL)).queryParams(uriVariables).build();

        RestTemplate restTemplate = new RestTemplate();
        Features rates = restTemplate.getForObject(uriComponents.toUri(), Features.class);

        if (rates.getSuccess()) {
            String cRate = rates.getQuotes().get(rateKey);
            BigDecimal bdRate = new BigDecimal(cRate);
            res.setConvertedCurrency(bdRate.multiply(amount));
            cacheExcRat.setCacheExchangeRate(rateKey, bdRate);
        } else {
            res.setError(rates.getError());
            res.setConvertedCurrency(BigDecimal.ZERO);
        }

        return res;
    }

}
