package org.springframework.data.neo4j.examples.hellograph;

import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.neo4j.repository.NamedIndexRepository;

/**
 * @author mh
 * @since 01.04.11
 */
public interface WorldRepository extends MyWorldRepository, GraphRepository<World>, NamedIndexRepository<World> {
}
