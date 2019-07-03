package altea.pokemonshop.service;
import altea.pokemonshop.bo.Item;
import altea.pokemonshop.bo.Trainer;
import altea.pokemonshop.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    public ItemRepository itemRepository;

    @Override
    public List<Item> findAllItems() {
        return this.itemRepository.finAllItems();
    }


    @Override
    public List<Item> findItemsByTrainers(Trainer trainer) {
        return this.itemRepository.findItemsByTrainers(trainer);
    }

    public ItemRepository getItemRepository() {
        return itemRepository;
    }

    @Autowired
    public void setItemRepository(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;

    }
}