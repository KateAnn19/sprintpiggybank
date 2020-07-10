package local.kmcgeeka.newrepobank.controllers;

import local.kmcgeeka.newrepobank.models.Coin;
import local.kmcgeeka.newrepobank.repositories.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Comparator;
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

    @GetMapping(value="/money/{amount:.+}", produces = {"application/json"})
    public ResponseEntity<?> subtractAndGetNewPBankAmount(@PathVariable double amount)
    {
        List<Coin> cList = new ArrayList<>();
        coinrepos.findAll().iterator().forEachRemaining(cList::add);
        double total = 0;

        //get totals of new amounts after withdrawal and print them --  not sure if new list is needed
        for(Coin c: cList)
        {

            total = total + (c.getValue() * c.getQuantity());

        }

        //sort by amount and then sort by value
        cList.sort(Comparator.comparing(c -> c.getQuantity(), Comparator.reverseOrder()));
        cList.sort(Comparator.comparing(c -> c.getValue(), Comparator.reverseOrder()));

        int amtToSub;
        int newVal;
        double multipliedTrans = amount * 100;
        //if amount > amount in piggy bank exit with print statement
        if(amount > total)
        {
            System.out.println("Insufficient Funds");
        }

        for(Coin c : cList)
        {
            newVal = (int)c.getValue() * 100;
            amtToSub = (int)(multipliedTrans/newVal);

            //if the division of the transaction and val is greater than 0
            if(amtToSub > 0)
            {
                if(c.getQuantity() >= amtToSub)
                {
                    c.subtract(amtToSub);
                    multipliedTrans = (int)multipliedTrans - ((int)amtToSub* newVal);
                }else
                {
                    multipliedTrans = (int)multipliedTrans - ((int)c.getQuantity()* newVal);
                    c.emptyCurrency();
                }
                if(multipliedTrans == 0)
                {
                    break;
                }
            }
            else
            {
                continue;
            }
        }

            //get totals of new amounts after withdrawal and print them --  not sure if new list is needed
            for(Coin c: cList)
            {
                total = total + (c.getValue() * c.getQuantity());
                System.out.println(c.getQuantity() + " " + (c.getQuantity() == 1 ? c.getName() : c.getNameplural()));
            }
        return new ResponseEntity<>(cList, HttpStatus.OK);
    }

}
