package blog.surapong.example.trainingunittest.api.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Accessors(chain = true)
@Entity
public class Idol {
    @Id
    private String name;
    private String description;
}
