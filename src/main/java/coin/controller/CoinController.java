package coin.controller;

import coin.model.Coin;
import coin.model.CoinCollection;
import coin.model.CoinType;
import coin.service.CoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@Controller
public class CoinController {

//   ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
    @Autowired CoinService cs;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView coin() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("coin");

        Coin c2 = new Coin(100L, 1978L, new CoinType("pre64Nickel", "Pre 1964 Nickel", 0f, 0f));

        String str = "Hello foo World!";
        mav.addObject("message", str + c2.getCoinType());

        return mav;
    }

    @RequestMapping(value = "/coin", method = RequestMethod.GET)
    public @ResponseBody CoinResponse getAll(HttpServletRequest request) {




        int rows = (request.getParameter("rows")!=null) ? Integer.parseInt(request.getParameter("rows")) : 1;
        int page = (request.getParameter("page")!=null) ? Integer.parseInt(request.getParameter("page")) : 1;
        String sidx = request.getParameter("sidx");
        String sord = request.getParameter("sord");

        CoinResponse response = new CoinResponse();
        response.setRows(cs.getCc().getCoinCollection());
        int count = cs.getCc().getCoinCollection().size();
        int total = count % rows == 0 ? (int) Math.ceil(count / rows) : (int) Math.ceil(count / rows) + 1;
        response.setTotal(total);
        response.setRecords(count);
        response.setPage(page);
        return response;

    }

    @RequestMapping(value = "/coin", method = RequestMethod.POST)
    ResponseEntity<Coin> saveCoin(@RequestBody Map<String, Object> inputCoin) {

        Map<String, CoinType> coinTypes = cs.getCts();
        Coin c2 = new Coin(Long.valueOf(inputCoin.get("id").toString()), Long.valueOf(inputCoin.get("year").toString()), coinTypes.get(inputCoin.get("coinType.description").toString()));

        ///Coin c2 = new Coin(inputCoin.getId(), inputCoin.getYear(), new CoinType("pre64Nickel", "Pre 1964 Nickel", 0f, 0f));
        CoinResponse response = new CoinResponse();

        cs.getCc().addCoinToCollection(c2);

        return new ResponseEntity<Coin>(c2, HttpStatus.OK);

    }
}