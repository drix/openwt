package club.iotech.openwt.boat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BoatControllerTest {

    @InjectMocks
    BoatController boatController;

    @Mock
    BoatService boatService;

    MockHttpServletRequest request;

    @BeforeEach
    void setUp() {
        if(request == null) {
            request = new MockHttpServletRequest();
            RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        }
    }

    @Test
    void getAll() {
        final List<BoatEntity> list = new ArrayList<BoatEntity>();
        list.add(new BoatEntity());
        list.add(new BoatEntity());

        when(boatService.getAll()).thenReturn(list);

        final ResponseEntity<List<BoatEntity>> response = boatController.getAll();

        assertThat(Objects.requireNonNull(response.getBody()).size())
                .isEqualTo(2);
        assertThat(response.getStatusCode())
                .isEqualTo(HttpStatus.OK);
        verify(boatService, times(1))
                .getAll();
    }

    @Test
    void getById() {
        final String myBoat = "myBoat";
        final BoatEntity boat = new BoatEntity();
        boat.setId(1L);
        boat.setName(myBoat);
        boat.setDescription(myBoat);

        when(boatService.getById(1L))
                .thenReturn(Optional.of(boat));

        final ResponseEntity<BoatEntity> response = boatController.getById(1L);

        assertThat(response.getStatusCode())
                .isEqualTo(HttpStatus.OK);
        assertThat(Objects.requireNonNull(response.getBody()).getName())
                .isEqualTo(myBoat);
        assertThat(Objects.requireNonNull(response.getBody()).toString())
                .asString();
    }

    @Test
    void createOrUpdate() {
        final ResponseEntity<BoatEntity> response = boatController.createOrUpdate(any());
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    void deleteById() {
        final HttpStatus status = boatController.deleteById(1L);
        verify(boatService)
                .deleteById(any());
        assertThat(status)
                .isEqualTo(HttpStatus.FORBIDDEN);
    }
}