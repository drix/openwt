package club.iotech.openwt.boat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import club.iotech.openwt.exception.RecordNotFoundException;

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

    public BoatEntity getById(Long id) throws RecordNotFoundException
    {
        Optional<BoatEntity> boat = repository.findById(id);

        if(boat.isPresent()) {
            return boat.get();
        } else {
            throw new RecordNotFoundException("No boat record exist for given id");
        }
    }

    public BoatEntity createOrUpdate(BoatEntity entity) throws RecordNotFoundException
    {
        Optional<BoatEntity> boat = repository.findById(entity.getId());

        if(boat.isPresent())
        {
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

    public void deleteById(Long id) throws RecordNotFoundException
    {
        Optional<BoatEntity> boat = repository.findById(id);

        if(boat.isPresent())
        {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No boat record exist for given id");
        }
    }
}