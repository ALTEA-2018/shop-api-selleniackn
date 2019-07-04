package altea.pokemonshop.service;

import altea.pokemonshop.bo.Trainer;

import java.util.List;

public interface TrainerService {
    List findAllTrainers();
    Trainer findTrainerById(int id);
    Trainer findTrainerByName(String name);
    void addCredits(int qte, String trainerName);

}