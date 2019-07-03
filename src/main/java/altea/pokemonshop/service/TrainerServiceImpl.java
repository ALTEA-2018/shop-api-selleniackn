package altea.pokemonshop.service;

import altea.pokemonshop.bo.Trainer;
import altea.pokemonshop.repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainerServiceImpl implements TrainerService {
    public TrainerRepository trainerRepository;

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
        return this.trainerRepository.findTrainerByName(name);
    }

    public TrainerRepository getTrainerRepository() {
        return trainerRepository;
    }

    @Autowired
    public void setTrainerRepository(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }

}
