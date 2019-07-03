package altea.pokemonshop;

import altea.pokemonshop.bo.Trainer;
import altea.pokemonshop.repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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
            var berne = new Trainer("Berne");
            berne.setPassword(bCryptPasswordEncoder.encode("1234"));
            berne.setCredits(300);

            var fellenia = new Trainer("Fellenia");
            fellenia.setPassword(bCryptPasswordEncoder.encode("1234"));
            fellenia.setCredits(7500);

            repository.save(berne);
            repository.save(fellenia);
        };
    }

}
