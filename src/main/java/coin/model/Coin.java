package coin.model;

import java.math.BigDecimal;

public class Coin {


    private Long id;
    private Long year;
    private CoinType coinType;


    public Coin() {

    }

    public Coin(Long id, Long year, CoinType coinType) {
        this.id = id;
        this.year = year;
        this.coinType = coinType;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Long getYear() {
        return year;
    }

    public void setYear(Long year) {
        this.year = year;
    }

    public CoinType getCoinType() {
        return coinType;
    }

    public void setCoinType(CoinType coinType) {
        this.coinType = coinType;
    }


}