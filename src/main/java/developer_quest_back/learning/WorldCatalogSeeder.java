package developer_quest_back.learning;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class WorldCatalogSeeder implements ApplicationRunner {

	private static final List<World> INITIAL_WORLDS = List.of(
			new World((short) 1, "fundamentos", "Fundamentos", "El origen de tu aventura",
					"Aprende a pensar como programador. Transforma problemas cotidianos en instrucciones claras y construye tus primeros algoritmos."),
			new World((short) 2, "orientacion-a-objetos", "Orientación a objetos", "Construye tu universo",
					"Modela situaciones reales con clases y objetos. Descubre cómo organizar código que pueda crecer contigo."),
			new World((short) 3, "java-y-estructuras", "Java y estructuras", "La ciudad de la lógica",
					"Domina las herramientas de Java y aprende a elegir la estructura de datos adecuada para resolver cada problema."),
			new World((short) 4, "backend-con-spring", "Backend con Spring", "El núcleo del sistema",
					"Construye el motor de una aplicación: APIs, persistencia, reglas de negocio y autenticación."),
			new World((short) 5, "frontend-profesional", "Frontend profesional", "Dale vida a tus ideas",
					"Crea interfaces accesibles e interactivas que conecten a las personas con tus aplicaciones."),
			new World((short) 6, "bases-de-datos", "Bases de datos", "El archivo del conocimiento",
					"Organiza información, relaciona datos y escribe consultas eficientes con PostgreSQL."),
			new World((short) 7, "ingenieria-de-software", "Ingeniería de software", "El taller de los maestros",
					"Aprende a colaborar, probar, mantener y desplegar software con prácticas profesionales."),
			new World((short) 8, "mundo-profesional", "Mundo profesional", "Tu siguiente gran desafío",
					"Conecta todo lo aprendido en proyectos, entrevistas y desafíos inspirados en el trabajo real."));

	private final WorldRepository worldRepository;

	public WorldCatalogSeeder(WorldRepository worldRepository) {
		this.worldRepository = worldRepository;
	}

	@Override
	@Transactional
	public void run(ApplicationArguments args) {
		for (World world : INITIAL_WORLDS) {
			if (!worldRepository.existsBySlug(world.getSlug())) {
				worldRepository.save(world);
			}
		}
	}
}
