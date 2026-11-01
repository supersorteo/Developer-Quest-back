package developer_quest_back.learning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/worlds")
public class WorldController {

	private final WorldService worldService;

	public WorldController(WorldService worldService) {
		this.worldService = worldService;
	}

	@GetMapping
	public List<WorldResponse> findAll() {
		return worldService.findAll();
	}
}
