package samuelvalentini.u5d8ex.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import samuelvalentini.u5d8ex.entity.Autore;
import samuelvalentini.u5d8ex.playload.AutorePlayload;
import samuelvalentini.u5d8ex.playload.UpdateAutorePlayload;
import samuelvalentini.u5d8ex.service.AutoreService;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AutoreController {

    private final AutoreService autoreService;

    public AutoreController(AutoreService autoreService) {
        this.autoreService = autoreService;
    }

    @GetMapping
    public List<Autore> findAll() {
        return autoreService.findAll();
    }

    @GetMapping("/{autoreId}")
    public Autore findById(@PathVariable long autoreId) {
        return autoreService.findById(autoreId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Autore createNewAutore(@RequestBody AutorePlayload autorePlayload) {
        return autoreService.saveNewAutore(autorePlayload);
    }

    @PutMapping("/{autoreId}")
    public Autore updateAutore(@PathVariable long autoreId, @RequestBody UpdateAutorePlayload updateAutorePlayload) {
        return this.autoreService.findByIdAndUpdate(autoreId, updateAutorePlayload);
    }

    @DeleteMapping("/{autoreId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAutore(@PathVariable long autoreId) {
        autoreService.deleteAutore(autoreId);
    }

}
