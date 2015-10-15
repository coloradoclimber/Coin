package coin.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mcrofford on 5/4/15.
 */
public class CoinCollection {

    private List<Coin> coinCollection;

    public CoinCollection()
    {
        coinCollection = new ArrayList<>();
    }

    public void addCoinToCollection(Coin c)
    {
        coinCollection.add(c);
    }

    public List<Coin> getCoinCollection()
    {
        return coinCollection;
    }


}
