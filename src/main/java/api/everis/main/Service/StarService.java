package api.everis.main.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import api.everis.main.DTO.StarDTO;
import api.everis.main.Entity.Star;
import api.everis.main.Repository.StarRepository;

@Service
public class StarService {
	
	private StarRepository starRepository;

	public StarService(StarRepository starRepository) {
		this.starRepository = starRepository;
	}
	
	@Transactional
	public StarDTO getOne(int id) throws Exception {
		
		Optional<Star> optional = starRepository.findById(id);
		
		try {
			
			Star star = optional.get();
			ModelMapper mapper = new ModelMapper();
			return mapper.map(star, StarDTO.class);
			
		}catch(Exception e) {
			
			throw new Exception();
		}
		
	}
	
	@Transactional
	public List<StarDTO> getAll() throws Exception {
		
		List<Star> stars = starRepository.findAll();
		List<StarDTO> arrayStarDTO = new ArrayList<>();
		ModelMapper mapper = new ModelMapper();
		
		try {
			
			for(Star star : stars) {
				
				StarDTO starDTO = mapper.map(star, StarDTO.class);
				arrayStarDTO.add(starDTO);
			}
			
			return arrayStarDTO;
			
		}catch (Exception e) {
			
			throw new Exception();
			
		}
	}
	
	@Transactional
	public StarDTO post(StarDTO starDTO) throws Exception {
		
		ModelMapper mapper = new ModelMapper();
		
		try {
			
			Star star = mapper.map(starDTO, Star.class);
			star = starRepository.save(star);
			return mapper.map(star, StarDTO.class);
			
		}catch(Exception e) {
			
			throw new Exception();
		}
	}
	
	@Transactional
	public StarDTO put(int id, StarDTO starDTO) throws Exception {
		
		Optional<Star> optional = starRepository.findById(id);
		Star star = new Star();
		
		try {
			
			starDTO.setId(optional.get().getId());
			ModelMapper mapper = new ModelMapper();
			star = mapper.map(starDTO, Star.class);
			star = starRepository.save(star);
			return mapper.map(star, StarDTO.class);
			
		}catch(Exception e) {
			
			throw new Exception();
		}
		
	}
	
	@Transactional
	public boolean delete(int id) throws Exception {
		
		try {
			
			if(starRepository.existsById(id)) {
				
				starRepository.deleteById(id);
				return true;
				
			}else {
				
				throw new Exception();
				
			}
			
		}catch(Exception e) {
			
			throw new Exception();
			
		}
	}
	

}
