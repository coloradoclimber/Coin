package coin.service;

import coin.model.Coin;
import coin.model.CoinCollection;
import coin.model.CoinType;
import org.apache.catalina.Session;
import org.json.simple.parser.JSONParser;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;


import javax.annotation.PostConstruct;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.*;
import org.json.simple.*;

@Service("coinService")


public class CoinService {

    CoinCollection cc;
    Map<String, CoinType> cts;

   public CoinService()
   {

    }

    @PostConstruct
    public void init()
    {
        try
        {
            final JSONParser parser = new JSONParser();
            FileReader reader = null;

            reader = new FileReader("src/main/resources/conf/coinTypes.json");
            Object obj = parser.parse(reader);
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray coinTypes = (JSONArray) jsonObject.get("coinTypes");
            Iterator<JSONObject> iterator = coinTypes.iterator();
            cts = new HashMap<>();

            while(iterator.hasNext())
            {
                JSONObject coinTypeObject = iterator.next();
                CoinType tempType = new CoinType(coinTypeObject.get("coinType").toString(), coinTypeObject.get("description").toString(), Float.valueOf(coinTypeObject.get("silverContent").toString()), Float.valueOf(coinTypeObject.get("goldContent").toString()));
                cts.put(tempType.getCoinType(), tempType);
            }


            reader = new FileReader("src/main/resources/conf/coins.json");


            obj = parser.parse(reader);

            jsonObject = (JSONObject) obj;
            JSONArray coinList = (JSONArray) jsonObject.get("coinCollection");

            cc = new CoinCollection();

             iterator = coinList.iterator();

          while(iterator.hasNext()) {
              JSONObject coinObject = iterator.next();
              CoinType foundType = cts.get(coinObject.get("coinType").toString());
              Coin tempCoin = new Coin(Long.valueOf(coinObject.get("id").toString()), Long.valueOf(coinObject.get("year").toString()), foundType);
              cc.addCoinToCollection(tempCoin);
          }

        }
        catch(Exception e)
        {
            System.out.println(e);
        }


    }


    public CoinCollection getCc() {
        return cc;
    }

    public Map<String, CoinType> getCts() {
        return cts;
    }

    public void setCc(CoinCollection cc) {
        this.cc = cc;
    }




}