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

    public BoatEntity createOrUpdate(BoatEntity entity)
    {
        Optional<BoatEntity> boat = repository.findById(entity.getId());

        if(boat.isPresent()) {
            BoatEntity newEntity = boat.get();
            newEntity.setName(entity.getName());
            newEntity.setDescription(entity.getDescription());

            newEntity = repository.save(newEntity);

            return newEntity;
        } else {
            entity = repository.save(entity);

            return entity;
        }
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