package api.everis.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import api.everis.DTO.PlanetDTO;
import api.everis.Service.PlanetService;

@Controller
@RestController
@RequestMapping(path = "api/v1/planets")
public class PlanetController {
	
	private PlanetService planetService;

	public PlanetController(PlanetService planetService) {
		this.planetService = planetService;
	}
	
	@GetMapping("/{id}")
	@Transactional
	public ResponseEntity getOne(@PathVariable int id) {
		
		try {
			PlanetDTO planetDTO = planetService.getOne(id);
			return ResponseEntity.status(HttpStatus.OK).body(planetDTO);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\": \"Error. Please check the ID, and try again later.\"}");
		}
		
	}
	
	@GetMapping("/")
	@Transactional
	public ResponseEntity getAll() {
		
		try {
			List<PlanetDTO> arrayPlanetDTO = planetService.getAll();
			return ResponseEntity.status(HttpStatus.OK).body(arrayPlanetDTO);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\": \"Error. Please try again later.\"}");
		}
		
	}
	
	@PostMapping("/")
	@Transactional
	public ResponseEntity post(@RequestBody PlanetDTO planetDTO) {
		
		try {
			return ResponseEntity.status(HttpStatus.OK).body(planetService.post(planetDTO));
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\": \"Error. Please check the BODY request, and try again later.\"}");
		}
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity put(@PathVariable int id, @RequestBody PlanetDTO planetDTO) {
		
		try {
			return ResponseEntity.status(HttpStatus.OK).body(planetService.put(id, planetDTO));
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\": \"Error. Please check the ID or BODY request, and try again later.\"}");
		}
		
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity delete(@PathVariable int id) {
		
		try {
			planetService.delete(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("");
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\": \"Error. Please check the ID, and try again later.\"}");
		}
	}

}
