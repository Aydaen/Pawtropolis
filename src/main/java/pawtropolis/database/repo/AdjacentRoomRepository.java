package pawtropolis.database.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pawtropolis.database.entity.AdjacentRoomEntity;

public interface AdjacentRoomRepository extends JpaRepository<AdjacentRoomEntity, Long> {
}