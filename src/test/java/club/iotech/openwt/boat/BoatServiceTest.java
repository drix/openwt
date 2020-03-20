package club.iotech.openwt.boat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class BoatServiceTest {

    @InjectMocks
    BoatService boatService;

    @Mock
    final BoatRepository repository = mock(BoatRepository.class);;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getAll() {
        ArrayList<BoatEntity> list = new ArrayList<BoatEntity>();

        when(repository.findAll())
                .thenReturn(list);

        List<BoatEntity>
        response = boatService.getAll();

        assertThat(response.size())
                .isEqualTo(0);


        list.add(new BoatEntity());
        list.add(new BoatEntity());
        response = boatService.getAll();

        assertThat(response.size())
                .isEqualTo(2);

        verify(repository, times(2))
                .findAll();
    }

    @Test
    void getById() {
        final String myBoat = "myBoat";
        final BoatEntity boat = new BoatEntity();
        boat.setId(1L);
        boat.setName(myBoat);

        when(repository.findById(1L))
                .thenReturn(Optional.of(boat));

        final Optional<BoatEntity> response = boatService.getById(1L);

        assertThat(response.isPresent())
                .isTrue();
        assertThat(response.get().getName())
                .isEqualTo(myBoat);
    }

    @Test
    void createOrUpdate() {
        final String myBoat = "myBoat";
        final BoatEntity boat = new BoatEntity();
        boat.setId(1L);
        boat.setName(myBoat);

        when(repository.save(boat))
                .thenReturn(boat);
        // create
        BoatEntity
        response = boatService.createOrUpdate(boat);

        assertThat(response.getName())
                .isEqualTo(myBoat);
        // update
        boat.setName("random");
        when(repository.findById(boat.getId()))
                .thenReturn(Optional.of(boat));
        response = boatService.createOrUpdate(boat);

        assertThat(response.getName())
                .isNotEqualTo(myBoat);
    }

    @Test
    void deleteByIdOK() {
        when(repository.findById(1L))
                .thenReturn(Optional.of(new BoatEntity()));
        assertThat(boatService.deleteById(1L))
                .isTrue();
    }

    @Test
    void deleteByIdNotOK() {
        when(repository.findById(1L))
                .thenReturn(Optional.empty());
        assertThat(boatService.deleteById(1L))
                .isFalse();
    }
}