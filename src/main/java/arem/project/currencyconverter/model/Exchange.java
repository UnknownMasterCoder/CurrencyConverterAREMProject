package arem.project.currencyconverter.model;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import arem.project.currencyconverter.api.Currency;

public class Exchange {

    private Currency actualCurrency;
    private Currency wantedCurrency;
    private BigDecimal actualAmount;
    private BigDecimal wantedAmount;

    /**
     * @return the actualCurrency
     */
    public Currency getActualCurrency() {
        return actualCurrency;
    }

    /**
     * @param actualCurrency the actualCurrency to set
     */
    public void setActualCurrency(Currency actualCurrency) {
        this.actualCurrency = actualCurrency;
    }

    /**
     * @return the wantedCurrency
     */
    public Currency getWantedCurrency() {
        return wantedCurrency;
    }

    /**
     * @param wantedCurrency the wantedCurrency to set
     */
    public void setWantedCurrency(Currency wantedCurrency) {
        this.wantedCurrency = wantedCurrency;
    }

    /**
     * @return the actualAmount
     */
    public BigDecimal getActualAmount() {
        return actualAmount;
    }

    /**
     * @param actualAmount the actualAmount to set
     */
    public void setActualAmount(BigDecimal actualAmount) {
        this.actualAmount = actualAmount;
    }

    /**
     * @return the wantedAmount
     */
    public BigDecimal getWantedAmount() {
        return wantedAmount;
    }

    /**
     * @param wantedAmount the wantedAmount to set
     */
    public void setWantedAmount(BigDecimal wantedAmount) {
        this.wantedAmount = wantedAmount;
    }

    public List<Currency> getSupportedCurrencies() {
        return Arrays.asList(Currency.values());
    }

}
