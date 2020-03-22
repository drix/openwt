package club.iotech.openwt.boat;

import lombok.*;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name="TBL_BOAT")
public class BoatEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column(name="name", nullable=false, length=200)
    private String name;

    @Column(name="description", nullable=true)
    private String description;

    @Override
    final public String toString() {
        return "BoatEntity [id=" + id + ", name=" + name +
                ", description=" + description  + "]";
    }
}