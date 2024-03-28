package pawtropolis.database.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pawtropolis.database.entity.SpeciesEntity;

public interface SpeciesRepository extends JpaRepository<SpeciesEntity, Long> {
}