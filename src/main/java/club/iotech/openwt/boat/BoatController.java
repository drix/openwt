package club.iotech.openwt.boat;

import java.util.List;

import club.iotech.openwt.exception.RecordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/boat")
public class BoatController
{
    @Autowired
    BoatService service;

    @GetMapping
    public ResponseEntity<List<BoatEntity>> getAll() {
        List<BoatEntity> list = service.getAll();

        return new ResponseEntity<List<BoatEntity>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BoatEntity> getById(@PathVariable("id") Long id)
            throws RecordNotFoundException {
        BoatEntity entity = service.getById(id);

        return new ResponseEntity<BoatEntity>(entity, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BoatEntity> createOrUpdate(BoatEntity boat)
            throws RecordNotFoundException {
        BoatEntity updated = service.createOrUpdate(boat);
        return new ResponseEntity<BoatEntity>(updated, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteById(@PathVariable("id") Long id)
            throws RecordNotFoundException {
        service.deleteById(id);
        return HttpStatus.FORBIDDEN;
    }

}