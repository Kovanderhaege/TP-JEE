package junia.lab05.web.controller;

import junia.lab05.core.entity.Movie;
import junia.lab05.core.service.MovieService;
import junia.lab05.core.service.PhaseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("movies")
public class MoviesController {
    final private MovieService movieService;
    final private PhaseService phaseService;

    public MoviesController(MovieService movieService, PhaseService phaseService) {
        this.movieService = movieService;
        this.phaseService = phaseService;
    }

    @GetMapping("/add")
    public String addMovieForm(ModelMap modelMap, @RequestParam("phase") long id){
        modelMap.addAttribute("movie", new Movie());
        modelMap.addAttribute("phase", phaseService.findOne(id));
        return "MovieForm";
    }

    @PostMapping("/save")
    public String saveMovie(@ModelAttribute("movie") Movie movie, @RequestParam("phase") long id){
        movieService.saveMovieInPhase(movie, id);
        return "redirect:../sagas/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteMovie(@PathVariable("id") long movieId){
        movieService.deleteById(movieId);
        return "redirect:../../sagas/list";
    }
}
