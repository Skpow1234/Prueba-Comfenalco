package backend.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import backend.entities.Comerciante;

@Repository
public interface ComercianteRepository extends JpaRepository<Comerciante, Long> {
    Page<Comerciante> findByNombreContainingAndEstadoContaining(
        String nombre, String estado, Pageable pageable
    );
}

