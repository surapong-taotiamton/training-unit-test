package blog.surapong.example.trainingunittest.api.service;

import blog.surapong.example.trainingunittest.api.model.Idol;
import blog.surapong.example.trainingunittest.api.repository.IdolRepository;

import java.util.Optional;

public class DatabaseIdolService {

    private IdolRepository idolRepository;

    public DatabaseIdolService(IdolRepository idolRepository) {
        this.idolRepository = idolRepository;
    }

    public String getIdol(String name) {

        Optional<Idol> result = this.idolRepository.findById(name);

        if (result.isPresent()) {
            return result.get().getDescription();
        } else {
            return null;
        }


    }
}
