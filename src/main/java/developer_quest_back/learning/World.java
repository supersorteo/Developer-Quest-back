package developer_quest_back.learning;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "worlds")
public class World {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;

	@Column(name = "world_number", nullable = false, unique = true)
	private short worldNumber;

	@Column(nullable = false, unique = true, length = 60)
	private String slug;

	@Column(nullable = false, length = 100)
	private String name;

	@Column(nullable = false, length = 120)
	private String subtitle;

	@Column(nullable = false, columnDefinition = "text")
	private String description;

	protected World() {
	}

	public World(short worldNumber, String slug, String name, String subtitle, String description) {
		this.worldNumber = worldNumber;
		this.slug = slug;
		this.name = name;
		this.subtitle = subtitle;
		this.description = description;
	}

	public UUID getId() {
		return id;
	}

	public short getWorldNumber() {
		return worldNumber;
	}

	public String getSlug() {
		return slug;
	}

	public String getName() {
		return name;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public String getDescription() {
		return description;
	}
}
