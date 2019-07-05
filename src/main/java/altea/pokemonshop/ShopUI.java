package altea.pokemonshop;

import altea.pokemonshop.bo.ItemTrainer;
import altea.pokemonshop.bo.Trainer;
import altea.pokemonshop.repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.util.Arrays;


@SpringBootApplication
public class ShopUI {

    public static void main(String... args) {
        SpringApplication.run(ShopUI.class, args);
    }

    @Bean
    @Autowired
    public CommandLineRunner connect(TrainerRepository repository) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        return (args) -> {
            var item1 = new ItemTrainer(1);
            var item5 = new ItemTrainer(1);
            var item6 = new ItemTrainer(1);
            var item2 = new ItemTrainer(4);
            var item3 = new ItemTrainer(2);
            var item4 = new ItemTrainer(3);
            var listItem = Arrays.asList(item1, item2, item3, item4, item5, item6);


            // SASHA
            var sasha = new Trainer("Sasha");
            sasha.setPassword(bCryptPasswordEncoder.encode("pokepoke"));
            sasha.setCredits(300);
            sasha.setTrainerItems(listItem);
            repository.save(sasha);
        };
    }

}
