package local.kmcgeeka.newrepobank;

import local.kmcgeeka.newrepobank.models.Coin;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class NewrepobankApplication
{

    public static void main(String[] args)
    {

        SpringApplication.run(NewrepobankApplication.class, args);
        System.out.println("Piggy Bank");
        List<Coin> bankVault = new ArrayList<>();

        System.out.println(bankVault.toString());
    }

}
