package developer_quest_back.learning;

import java.util.UUID;

public record WorldResponse(
		UUID id,
		short worldNumber,
		String slug,
		String name,
		String subtitle,
		String description) {

	static WorldResponse from(World world) {
		return new WorldResponse(
				world.getId(),
				world.getWorldNumber(),
				world.getSlug(),
				world.getName(),
				world.getSubtitle(),
				world.getDescription());
	}
}
