package altea.pokemonshop.repository;

import altea.pokemonshop.bo.ItemTrainer;
import altea.pokemonshop.bo.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TrainerRepositoryImpl implements TrainerRepository {
    private List<Trainer> trainers;
    private ItemRepository itemRepository;

    public TrainerRepositoryImpl() {
        this.trainers = new ArrayList<>();
    }

    @Override
    public List finAllTrainers() {
        return this.trainers;
    }

    @Override
    public Trainer findTrainerById(int id) {
        return this.trainers.stream().filter(t -> t.getId() == id).findFirst().orElse(null);
    }

    @Override
    public Trainer findTrainerByName(String name) {
        return this.trainers.stream().filter(t -> t.getName().equals(name)).findFirst().orElse(null);
    }

    @Override
    public void addCredits(int qte, String trainerName) {
    var trainer = this.trainers.stream().filter(t -> t.getName().equals(trainerName)).findFirst().orElse(null);
    trainer.setCredits(trainer.getCredits()+ (qte * 1000));
    }

    @Override
    public void save(Trainer trainer) {
        this.trainers.add(trainer);
    }

    @Override
    public boolean addItem(int idItem, String trainerName) {
        var trainer = this.trainers.stream().filter(t -> t.getName().equals(trainerName)).findFirst().orElse(null);
        var itemType = this.itemRepository.findById(idItem);
        if (trainer.getCredits() >= itemType.getPrice()){

            var trainerItems = trainer.getTrainerItems();
            var stagingList = new ArrayList<>(trainerItems);
            var addedItem = new ItemTrainer(idItem);
            stagingList.add(addedItem);
            trainer.setTrainerItems(stagingList);
            trainer.setCredits(trainer.getCredits() - itemType.getPrice());

            return true;
        }
        return false;
    }
    @Autowired
    public void setItemRepository(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }
}
