package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.Visit;
import guru.springframework.sfgpetclinic.repositories.VisitRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class VisitSDJpaServiceTest {

    @Mock
    VisitRepository repository;

    @InjectMocks
    VisitSDJpaService service;

    @DisplayName("Test Find All")
    @Test
    void findAll() {
        Visit visit = new Visit();

        Set<Visit> visits = new HashSet<>();
        visits.add(visit);

        when(repository.findAll()).thenReturn(visits);

        Set<Visit> foundVisits = service.findAll();

        verify(repository).findAll();

        assertThat(foundVisits).hasSize(1);

    }

    @DisplayName("Test Find All BDD")
    @Test
    void findAllBDD() {
        // given
        Visit visit = new Visit();
        Set<Visit> visits = new HashSet<>();
        visits.add(visit);
        given(repository.findAll()).willReturn(visits);

        // when
        Set<Visit> foundVisits = service.findAll();

        // then
        then(repository).should().findAll();
        assertThat(foundVisits).hasSize(1);
    }

    @Test
    void findById() {
        Visit visit = new Visit();

        when(repository.findById(anyLong())).thenReturn(Optional.of(visit));

        Visit foundVisit = service.findById(1L);

        verify(repository).findById(anyLong());

        assertThat(foundVisit).isNotNull();
    }

    @Test
    void findByIdBDD() {
        // Given
        Visit visit = new Visit();
        given(repository.findById(anyLong())).willReturn(Optional.of(visit));

        // when
        Visit foundVisit = service.findById(1L);

        // then
        then(repository).should().findById(anyLong());
        assertThat(foundVisit).isNotNull();
    }

    @Test
    void save() {
        Visit visit = new Visit();

        when(repository.save(any(Visit.class))).thenReturn(visit);

        Visit savedVisit = service.save(new Visit());

        verify(repository).save(any(Visit.class));

        assertThat(savedVisit).isNotNull();
    }

    @Test
    void saveBDD() {
        // Given
        Visit visit = new Visit();
        given(repository.save(any(Visit.class))).willReturn(visit);

        // when
        Visit savedVisit = service.save(new Visit());

        // then
        then(repository).should().save(any(Visit.class));
        assertThat(savedVisit).isNotNull();
    }


    @Test
    void delete() {
        Visit visit = new Visit();

        service.delete(visit);

        verify(repository).delete(any(Visit.class));

    }

    @Test
    void deleteBDD() {
        // given
        Visit visit = new Visit();

        // when
        service.delete(visit);

        // then
        then(repository).should().delete(any(Visit.class));
    }

    @Test
    void deleteById() {

        service.deleteById(1L);

        verify(repository).deleteById(anyLong());
    }

    @Test
    void deleteByIdBDD() {

        // when
        service.deleteById(1L);

        // then
        then(repository).should().deleteById(anyLong());
    }
}
