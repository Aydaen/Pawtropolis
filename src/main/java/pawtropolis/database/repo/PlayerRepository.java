package pawtropolis.database.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pawtropolis.database.entity.PlayerEntity;

public interface PlayerRepository extends JpaRepository<PlayerEntity, Long> {
}