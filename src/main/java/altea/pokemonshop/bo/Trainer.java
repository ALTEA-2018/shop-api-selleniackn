package altea.pokemonshop.bo;

import java.util.ArrayList;
import java.util.List;

public class Trainer {
    private int id;
    private String name;
    private String password;
    private int credits;
    private List<ItemTrainer> trainerItems;

    public Trainer() {
        this.trainerItems = new ArrayList<>();

    }

    public Trainer(String name) {
        this.name = name;
        this.trainerItems = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public List<ItemTrainer> getTrainerItems() {
        return trainerItems;
    }

    public void setTrainerItems(List<ItemTrainer> trainerItems) {
        this.trainerItems = trainerItems;
    }
}
