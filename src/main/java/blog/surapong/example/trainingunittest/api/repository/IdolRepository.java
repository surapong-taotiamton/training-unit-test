package blog.surapong.example.trainingunittest.api.repository;

import blog.surapong.example.trainingunittest.api.model.Idol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IdolRepository extends JpaRepository<Idol, String> {
}
