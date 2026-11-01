package developer_quest_back.learning;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface WorldRepository extends JpaRepository<World, UUID> {

	boolean existsBySlug(String slug);

	List<World> findAllByOrderByWorldNumberAsc();
}
