package api.everis.main.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import api.everis.main.Entity.Planet;

@Repository
public interface PlanetRepository extends JpaRepository<Planet, Integer> {

}
