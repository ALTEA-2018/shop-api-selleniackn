package altea.pokemonshop.service;

import altea.pokemonshop.bo.Item;
import altea.pokemonshop.bo.Trainer;
import altea.pokemonshop.repository.ItemRepository;
import altea.pokemonshop.repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainerServiceImpl implements TrainerService {
    public TrainerRepository trainerRepository;
    public ItemRepository itemRepository;

    @Override
    public List findAllTrainers() {
        return this.trainerRepository.finAllTrainers();
    }

    @Override
    public Trainer findTrainerById(int id) {
        return this.trainerRepository.findTrainerById(id);
    }

    @Override
    public Trainer findTrainerByName(String name) {
        Trainer trainer = this.trainerRepository.findTrainerByName(name);
        trainer.getTrainerItems().forEach(item -> {
            Item itemType = this.itemRepository.findById(item.getIdItem());
            item.setName(itemType.getName());
            item.setDescription(itemType.getDescription());
            item.setPicture(itemType.getPicture());
            item.setPrice(itemType.getPrice());
        });

        return trainer;
    }

    @Override
    public void addCredits(int qte, String trainerName) {
        this.trainerRepository.addCredits(qte,trainerName);

    }

    @Override
    public boolean addItem(int idItem, String trainerName) {
        return this.trainerRepository.addItem(idItem,trainerName);
    }


    public TrainerRepository getTrainerRepository() {
        return trainerRepository;
    }

    @Autowired
    public void setTrainerRepository(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }

    @Autowired
    public void setItemRepository(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

}
