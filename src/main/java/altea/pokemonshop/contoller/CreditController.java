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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CreditController {
    private TrainerService trainerService;
    private ItemService itemService;

    @GetMapping(value = "/Credits")
    public ModelAndView credits() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails principal = (UserDetails) authentication.getPrincipal();
        Map<String, Object> stringObjectMap = new HashMap<>();

        Trainer trainer = this.trainerService.findTrainerByName(principal.getUsername());
        stringObjectMap.put("trainer", trainer);
        return new ModelAndView("credits", stringObjectMap);
    }
    /*@PostMapping(value = "/buyPokedollars")
    public ModelAndView buyPoke(int qte){
        ModelAndView modelAndView = new ModelAndView("buycredit");
        modelAndView.addObject("qte", );
        return modelAndView;

}*/

        @Autowired
    public void setTrainerService(TrainerService trainerService) {
        this.trainerService = trainerService;
    }

    @Autowired
    public void setItemService(ItemService itemService) {
        this.itemService = itemService;
    }

}
