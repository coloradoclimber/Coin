package coin.model;

/**
 * Created by mcrofford on 6/11/15.
 */
public class CoinType {

    private String coinType;
    private String description;
    private Float goldContent;
    private Float silverContent;

    public CoinType(String coinType, String description, Float silverContent, Float goldContent) {
        this.coinType = coinType;
        this.description = description;
        this.goldContent = goldContent;
        this.silverContent = silverContent;
    }

    public Float getGoldContent() {
        return goldContent;
    }

    public void setGoldContent(Float goldContent) {
        this.goldContent = goldContent;
    }

    public Float getSilverContent() {
        return silverContent;
    }

    public void setSilverContent(Float silverContent) {
        this.silverContent = silverContent;
    }

    public String getCoinType() {
        return coinType;
    }

    public void setCoinType(String coinType) {
        this.coinType = coinType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }




}
