package samuelvalentini.u5d8ex.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import samuelvalentini.u5d8ex.entity.Autore;
import samuelvalentini.u5d8ex.exception.NotFoundException;
import samuelvalentini.u5d8ex.playload.AutorePlayload;
import samuelvalentini.u5d8ex.playload.UpdateAutorePlayload;
import samuelvalentini.u5d8ex.repository.AutoreRepository;

import java.util.List;

@Service
@Slf4j
public class AutoreService {
    private final AutoreRepository autoreRepository;

    public AutoreService(AutoreRepository autoreRepository) {
        this.autoreRepository = autoreRepository;
    }

    public List<Autore> findAll() {
        return autoreRepository.findAll();
    }

    public Autore saveNewAutore(AutorePlayload autorePlayload) {
        Autore autore = new Autore(autorePlayload.getNome(), autorePlayload.getCognome(), autorePlayload.getEmail(), autorePlayload.getDataDiNascita());
        return this.autoreRepository.save(autore);
    }

    public Autore findById(long autoreId) {
        return autoreRepository.findById(autoreId).orElseThrow(() -> new NotFoundException(String.valueOf(autoreId)));
    }

    public void deleteAutore(long autoreId) {
        Autore found = autoreRepository.findById(autoreId).orElseThrow(() -> new NotFoundException(String.valueOf(autoreId)));
        String nome = found.getNome();
        String cognome = found.getCognome();
        autoreRepository.delete(found);
        log.info("Autore {} {} rimosso", nome, cognome);
    }

    public Autore findByIdAndUpdate(long autoreId, UpdateAutorePlayload updateAutorePlayload) {
        Autore found = autoreRepository.findById(autoreId).orElseThrow(() -> new NotFoundException(String.valueOf(autoreId)));
        found.setNome(updateAutorePlayload.getNome());
        found.setCognome(updateAutorePlayload.getCognome());
        found.setEmail(updateAutorePlayload.getEmail());
        found.setDataDiNascita(updateAutorePlayload.getDataDiNascita());
        found.setAvatar(updateAutorePlayload.getAvatar());
        return autoreRepository.save(found);
    }
}
