package pawtropolis.database.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pawtropolis.database.entity.AnimalEntity;

public interface AnimalRepository extends JpaRepository<AnimalEntity, Long> {
}
