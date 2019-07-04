package altea.pokemonshop.bo;

import java.util.List;

public class Trainer {
    private int id;
    private String name;
    private String password;
    private int credits;
    private List<Item> trainerItems;

    public Trainer() {

    }

    public Trainer(String name) {
        this.name = name;
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

    public List<Item> getTrainerItems() {
        return trainerItems;
    }

    public void setTrainerItems(List<Item> trainerItems) {
        this.trainerItems = trainerItems;
    }
}
