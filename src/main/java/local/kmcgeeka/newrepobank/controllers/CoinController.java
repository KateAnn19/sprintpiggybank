package local.kmcgeeka.newrepobank.controllers;

import local.kmcgeeka.newrepobank.models.Coin;
import local.kmcgeeka.newrepobank.repositories.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CoinController
{
    @Autowired
    CoinRepository coinrepos;
    //Create an endpoint http://localhost:2019/total
    // that prints to console the contents of the
    // Piggy Bank as follows and returns an HTTP Status of OK:
    @GetMapping(value = "/total", produces={"application/json"})
    public ResponseEntity<?> bankTotal()
    {
        List<Coin> clist = new ArrayList<>();
        coinrepos.findAll().iterator().forEachRemaining(clist::add);

        double total = 0;
        for(Coin c : clist)
        {
            total = total + (c.getValue() * c.getQuantity());
            System.out.println(c.getQuantity() + " " + (c.getQuantity() == 1 ? c.getName() : c.getNameplural()));
        }

        System.out.println("The piggy bank holds " + total);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
