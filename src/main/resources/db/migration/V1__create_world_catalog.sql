CREATE TABLE worlds (
    id UUID PRIMARY KEY,
    world_number SMALLINT NOT NULL UNIQUE CHECK (world_number BETWEEN 1 AND 8),
    slug VARCHAR(60) NOT NULL UNIQUE,
    name VARCHAR(100) NOT NULL,
    subtitle VARCHAR(120) NOT NULL,
    description TEXT NOT NULL
);
