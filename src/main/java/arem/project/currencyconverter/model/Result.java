package arem.project.currencyconverter.model;

import java.math.BigDecimal;

public class Result {

    private BigDecimal convertedCurrency;
    private Error error;

    /**
     * @return the convertedCurrency
     */
    public BigDecimal getConvertedCurrency() {
        return convertedCurrency;
    }

    /**
     * @param convertedCurrency the convertedCurrency to set
     */
    public void setConvertedCurrency(BigDecimal convertedCurrency) {
        this.convertedCurrency = convertedCurrency;
    }

    /**
     * @return the error
     */
    public Error getError() {
        return error;
    }

    /**
     * @param error the error to set
     */
    public void setError(Error error) {
        this.error = error;
    }

}
