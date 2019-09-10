package api.everis.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import api.everis.Entity.Planet;

@Repository
public interface PlanetRepository extends JpaRepository<Planet, Integer> {

}
