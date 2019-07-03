package altea.pokemonshop.repository;

import altea.pokemonshop.bo.Trainer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TrainerRepositoryImpl implements TrainerRepository {
    private List<Trainer> trainers;

    public TrainerRepositoryImpl() {
        this.trainers = new ArrayList<>();
    }

    @Override
    public List finAllTrainers() {
        return this.trainers;
    }

    @Override
    public Trainer findTrainerById(int id) {
        return this.trainers.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }

    @Override
    public Trainer findTrainerByName(String name) {
        return this.trainers.stream().filter(p -> p.getName().equals(name)).findFirst().orElse(null);
    }

    @Override
    public void save(Trainer trainer) {
        this.trainers.add(trainer);
    }
}
