package api.everis.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import api.everis.Entity.Star;

@Repository
public interface StarRepository extends JpaRepository<Star, Integer>{

}
