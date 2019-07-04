package altea.pokemonshop.repository;

import altea.pokemonshop.bo.Item;
import altea.pokemonshop.bo.Trainer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
@Repository
public class ItemRepositoryImpl implements ItemRepository {
    private List<Item> items;
    private Trainer trainer;

    public ItemRepositoryImpl(){
        try {
            var itemsStream = new ClassPathResource("items.json").getInputStream();
            var objectMapper = new ObjectMapper();
            var itemsArray = objectMapper.readValue(itemsStream, Item[].class);
            this.items = Arrays.asList(itemsArray);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public List<Item> finAllItems() {

        return this.items;
    }

    @Override
    public Item findById(int id) {
        return this.items.stream().filter(i -> i.getId() == id).findFirst().orElse(null);
    }

   /* @Override
    public void save(Item item) {
       var itemsUpd = this.trainer.getTrainerItems().add(item);
       this.trainer.setTrainerItems(itemsUpd);
    }*/
}
