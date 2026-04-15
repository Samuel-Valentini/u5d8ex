package samuelvalentini.u5d8ex.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import samuelvalentini.u5d8ex.entity.Autore;
import samuelvalentini.u5d8ex.exception.NotFoundException;
import samuelvalentini.u5d8ex.payload.AutorePayload;
import samuelvalentini.u5d8ex.payload.UpdateAutorePayload;
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

    public Autore saveNewAutore(AutorePayload autorePayload) {
        Autore autore = new Autore(autorePayload.getNome(), autorePayload.getCognome(), autorePayload.getEmail(), autorePayload.getDataDiNascita());
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

    public Autore findByIdAndUpdate(long autoreId, UpdateAutorePayload updateAutorePayload) {
        Autore found = autoreRepository.findById(autoreId).orElseThrow(() -> new NotFoundException(String.valueOf(autoreId)));
        found.setNome(updateAutorePayload.getNome());
        found.setCognome(updateAutorePayload.getCognome());
        found.setEmail(updateAutorePayload.getEmail());
        found.setDataDiNascita(updateAutorePayload.getDataDiNascita());
        found.setAvatar(updateAutorePayload.getAvatar());
        return autoreRepository.save(found);
    }
}
