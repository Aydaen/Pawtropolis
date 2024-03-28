package pawtropolis.database.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pawtropolis.database.entity.ItemEntity;

public interface ItemRepository extends JpaRepository<ItemEntity, Long> {
}