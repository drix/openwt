package club.iotech.openwt.boat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoatService {

    @Autowired
    BoatRepository repository;

    public List<BoatEntity> getAll()
    {
        List<BoatEntity> boatList = repository.findAll();

        if(boatList.size() > 0) {
            return boatList;
        } else {
            return new ArrayList<BoatEntity>();
        }
    }

    public Optional<BoatEntity> getById(Long id)
    {
        return repository.findById(id);
    }

    public BoatEntity update(BoatEntity entity)
            throws IllegalArgumentException
    {
        Optional<BoatEntity> boat = repository.findById(entity.getId());
        if(!boat.isPresent()) {
            throw new IllegalArgumentException();
        }

        BoatEntity newEntity = boat.get();
        newEntity.setName(entity.getName());
        newEntity.setDescription(entity.getDescription());

        newEntity = repository.save(newEntity);

        return newEntity;
    }

    public BoatEntity create(BoatEntity entity)
            throws IllegalArgumentException
    {
        BoatEntity newEntity = new BoatEntity();
        newEntity.setName(entity.getName());
        newEntity.setDescription(entity.getDescription());

        return repository.save(newEntity);
    }

    public boolean deleteById(Long id)
    {
        Optional<BoatEntity> boat = repository.findById(id);

        if(boat.isPresent()) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}