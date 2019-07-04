package altea.pokemonshop.contoller;

import altea.pokemonshop.bo.Item;
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
    List<Item> trainerItems = this.itemService.findItemsByTrainers(trainer);
    stringObjectMap.put("trainerItems", trainerItems);
    return new ModelAndView("bag", stringObjectMap);
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

