package altea.pokemonshop.repository;

import altea.pokemonshop.bo.Item;
import altea.pokemonshop.bo.Trainer;

import java.util.List;

public interface ItemRepository {
    List<Item> finAllItems();
    Item findById(int id);

}

