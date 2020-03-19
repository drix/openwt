package club.iotech.openwt.boat;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@NoArgsConstructor
@Table(name="TBL_BOAT")
public class BoatEntity {

    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    @Column(name="name", nullable=false, length=200)
    private String name;

    @Column(name="description")
    private String description;

    @Override
    public String toString() {
        return "BoatEntity [id=" + id + ", name=" + name +
                ", description=" + description  + "]";
    }
}