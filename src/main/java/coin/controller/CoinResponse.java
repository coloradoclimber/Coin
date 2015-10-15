package coin.controller;

import coin.model.Coin;
import coin.model.CoinCollection;

import java.util.List;

/**
 * Created by mcrofford on 4/29/15.
 */
public class CoinResponse {
    private List<Coin> rows;
    private Integer total;
    private Integer records;
    private Integer page;

    public List<Coin> getRows() {
        return rows;
    }

    public void setRows(List<Coin> cc) {
        this.rows = cc;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getRecords() {
        return records;
    }

    public void setRecords(Integer records) {
        this.records = records;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }
}
