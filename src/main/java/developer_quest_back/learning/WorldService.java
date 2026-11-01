package developer_quest_back.learning;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorldService {

	private final WorldRepository worldRepository;

	public WorldService(WorldRepository worldRepository) {
		this.worldRepository = worldRepository;
	}

	public List<WorldResponse> findAll() {
		return worldRepository.findAllByOrderByWorldNumberAsc()
				.stream()
				.map(WorldResponse::from)
				.toList();
	}
}
