package altea.pokemonshop.repository;

import altea.pokemonshop.bo.Trainer;

import java.util.List;

public interface TrainerRepository {
    List finAllTrainers();
    Trainer findTrainerById(int id);
    Trainer findTrainerByName(String name);
    void save(Trainer trainer);
}
