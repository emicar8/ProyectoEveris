package api.everis.main.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import api.everis.main.Entity.Star;

@Repository
public interface StarRepository extends JpaRepository<Star, Integer>{

}
