package club.iotech.openwt.boat;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/boat")
public class BoatController
{
    @ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "boat not found")
    static final public class BoatNotFoundException extends RuntimeException { }

    @Autowired
    BoatService service;

    @GetMapping
    final public ResponseEntity<List<BoatEntity>> getAll() {
        List<BoatEntity> list = service.getAll();

        return new ResponseEntity<List<BoatEntity>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    final public ResponseEntity<BoatEntity> getById(
            @PathVariable("id") Long id)
            throws BoatNotFoundException {
        Optional<BoatEntity> entity = service.getById(id);
        if (entity.isPresent()) {
            return new ResponseEntity<BoatEntity>(entity.get(), new HttpHeaders(), HttpStatus.OK);
        } else {
            throw new BoatNotFoundException();
        }
    }

    @PostMapping
    final public ResponseEntity<BoatEntity> create(
            @RequestBody BoatEntity boat)
            throws BoatNotFoundException {
        BoatEntity updated = service.create(boat);
        return new ResponseEntity<BoatEntity>(updated, new HttpHeaders(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    final public ResponseEntity<BoatEntity> update(
            @RequestBody BoatEntity boat,
            @PathVariable("id") Long id)
            throws BoatNotFoundException {

        boat.setId(id);

        BoatEntity updated = service.update(boat);
        return new ResponseEntity<BoatEntity>(updated, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    final public HttpStatus deleteById(
            @PathVariable("id") Long id)
            throws BoatNotFoundException {
        service.deleteById(id);
        return HttpStatus.FORBIDDEN;
    }
}