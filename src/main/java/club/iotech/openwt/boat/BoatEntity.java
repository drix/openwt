package club.iotech.openwt.boat;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TBL_BOAT")
public class BoatEntity {

    @Id
    @Getter
    @Setter
    @GeneratedValue
    private Long id;

    @Getter
    @Setter
    @Column(name="name", nullable=false, length=200)
    private String name;

    @Getter
    @Setter
    @Column(name="description")
    private String description;

    @Override
    public String toString() {
        return "BoatEntity [id=" + id + ", name=" + name +
                ", description=" + description  + "]";
    }
}