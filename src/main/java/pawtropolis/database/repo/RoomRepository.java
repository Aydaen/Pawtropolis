package pawtropolis.database.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pawtropolis.database.entity.RoomEntity;

public interface RoomRepository extends JpaRepository<RoomEntity, Long> {
}
