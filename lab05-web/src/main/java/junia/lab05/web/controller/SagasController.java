package junia.lab05.web.controller;

import junia.lab05.core.entity.Saga;
import junia.lab05.core.service.SagaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("sagas")

public class SagasController {
    final private SagaService sagaService;

    public SagasController(SagaService sagaService) {
        this.sagaService = sagaService;
    }

    @GetMapping("/list")
    public String getListOfSagas(ModelMap modelMap){
       List<Saga> sagas = sagaService.findAllWithPhasesAndMovies();
       modelMap.addAttribute("SagasList", sagas);
       return "SagasList";
    }
}
