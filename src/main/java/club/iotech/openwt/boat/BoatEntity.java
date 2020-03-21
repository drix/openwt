package club.iotech.openwt.boat;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Map;

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
    final public String toString() {
        return "BoatEntity [id=" + id + ", name=" + name +
                ", description=" + description  + "]";
    }

    static final public BoatEntity fromMap(Map<String, String> body){
        final BoatEntity boat = new BoatEntity();
        boat.setName(body.get("name"));
        boat.setDescription(body.get("description"));
        return boat;
    }

    final public boolean validate(){
        try {
            return this.getName().length() > 0;
        } catch (NullPointerException e) {
            return false;
        }
    }
}