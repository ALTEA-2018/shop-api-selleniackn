package altea.pokemonshop.contoller;

import altea.pokemonshop.bo.Item;
import altea.pokemonshop.bo.ItemTrainer;
import altea.pokemonshop.bo.Trainer;
import altea.pokemonshop.service.ItemService;
import altea.pokemonshop.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class BagController {
    private TrainerService trainerService;
    private ItemService itemService;

    @GetMapping(value = "/Bag")
    public ModelAndView bag() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails principal = (UserDetails) authentication.getPrincipal();
        Trainer trainer = this.trainerService.findTrainerByName(principal.getUsername());
        Map<String, Object> stringObjectMap = new HashMap<>();
        stringObjectMap.put("trainer", trainer);
        Map qty = this.getItemsQty(trainer);
        stringObjectMap.put("items", qty);

        return new ModelAndView("bag", stringObjectMap);
    }

    // Création d'une Map qui associe les Items du Trainer avec leur quantité possédée.
    private HashMap<ItemTrainer, Integer> getItemsQty(Trainer trainer) {
        HashMap<Integer, Integer> map = new HashMap<>();
        trainer.getTrainerItems().forEach(item -> {

            if (map.containsKey(item.getIdItem())) {
                int prevQty = map.get(item.getIdItem());
                map.replace(item.getIdItem(), prevQty + 1);
            } else {
                map.put(item.getIdItem(), 1);
            }
        });

        HashMap<ItemTrainer, Integer> result = new HashMap<>();
        map.forEach((key,value) -> {
            ItemTrainer i = trainer.getTrainerItems().stream().filter(it -> it.getIdItem() == key).findFirst().orElse(null);
            result.put(i, value);
        });

        return result;
    }

    @Autowired
    public void setTrainerService(TrainerService trainerService) {
        this.trainerService = trainerService;
    }

    @Autowired
    public void setItemService(ItemService itemService) {
        this.itemService = itemService;
    }
}

