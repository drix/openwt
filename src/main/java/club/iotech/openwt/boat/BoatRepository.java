package club.iotech.openwt.boat;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
@CrossOrigin(origins = "http://localhost:8080")
public interface BoatRepository extends JpaRepository<BoatEntity, Long> {

}