package api.everis.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import api.everis.DTO.PlanetDTO;
import api.everis.Entity.Planet;
import api.everis.Repository.PlanetRepository;

@Service
public class PlanetService {
	
	private PlanetRepository planetRepository;

	public PlanetService(PlanetRepository planetRepository) {
		this.planetRepository = planetRepository;
	}
	
	@Transactional
	public PlanetDTO getOne(int id) throws Exception {
		
		Optional<Planet> optional = planetRepository.findById(id);
		
		try {
			
			Planet planet = optional.get();
			ModelMapper mapper = new ModelMapper();
			return mapper.map(planet, PlanetDTO.class);
			
		}catch(Exception e) {
			
			throw new Exception();
		
		}
		
	}
	
	@Transactional
	public List<PlanetDTO> getAll() throws Exception {
		
		List<Planet> planets = planetRepository.findAll();
		List<PlanetDTO> arrayPlanetDTO = new ArrayList<>();
		ModelMapper mapper = new ModelMapper();		
		
		try {
			
			for(Planet planet : planets) {
				
				PlanetDTO planetDTO = mapper.map(planet, PlanetDTO.class);
				arrayPlanetDTO.add(planetDTO);
				
			}
			
			return arrayPlanetDTO;
			
		}catch(Exception e) {
			
			throw new Exception();
			
		}
	}
	
	@Transactional
	public PlanetDTO post(PlanetDTO planetDTO) throws Exception {
		
		Planet planet = new Planet();
		ModelMapper mapper = new ModelMapper();
		
		try {
			
			planet = mapper.map(planetDTO, Planet.class);
			planet = planetRepository.save(planet);
			
			return mapper.map(planet, PlanetDTO.class);
			
		}catch(Exception e) {
			
			throw new Exception();
			
		}
		
	}
	
	@Transactional
	public PlanetDTO put(int id, PlanetDTO planetDTO) throws Exception{
		
		Optional<Planet> optional = planetRepository.findById(id);
		try {
			
			planetDTO.setId(optional.get().getId());
			
			Planet planet = new Planet();
			ModelMapper mapper = new ModelMapper();
			planet = mapper.map(planetDTO, Planet.class);
			planet = planetRepository.save(planet);
			
			return mapper.map(planet, PlanetDTO.class);
			
		}catch(Exception e) {
			
			throw new Exception();
			
		}
	}
	
	@Transactional
	public boolean delete(int id) throws Exception {
		
		try {
			
			if(planetRepository.existsById(id)) {
				
				planetRepository.deleteById(id);
				return true;
				
			}else {
				
				throw new Exception();
				
			}
		}catch(Exception e) {
			
			throw new Exception();
			
		}
		
	}
	
}
