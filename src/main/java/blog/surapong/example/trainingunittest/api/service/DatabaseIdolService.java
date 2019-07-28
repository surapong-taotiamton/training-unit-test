package blog.surapong.example.trainingunittest.api.service;

import blog.surapong.example.trainingunittest.api.repository.IdolRepository;

public class DatabaseIdolService {

    private IdolRepository idolRepository;

    public DatabaseIdolService(IdolRepository idolRepository) {
        this.idolRepository = idolRepository;
    }

    public String getIdol(String name) {
        return null;
    }
}
