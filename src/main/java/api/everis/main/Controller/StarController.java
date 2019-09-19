package api.everis.main.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.everis.main.DTO.StarDTO;
import api.everis.main.Service.StarService;

@Controller
@RestController
@RequestMapping(path = "api/v1/stars")
public class StarController {
	
	private StarService starService;

	public StarController(StarService starService) {
		this.starService = starService;
	}
	
	@GetMapping("/{id}")
	@CrossOrigin(origins = "*")
	@Transactional
	public ResponseEntity getOne(@PathVariable int id) {
		
		try {
			StarDTO starDTO = starService.getOne(id);
			return ResponseEntity.status(HttpStatus.OK).body(starDTO);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\": \"Error. Please try again later.\"}");
		}
		
	}
	
	@GetMapping("/")
	@CrossOrigin(origins = "*")
	@Transactional
	public ResponseEntity getAll() {
		
		try {
			List<StarDTO> arrayStarDTO = starService.getAll();
			return ResponseEntity.status(HttpStatus.OK).body(arrayStarDTO);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\": \"Error. Please check the ID, and try again later.\"}");
		}
		
	}
	
	@PostMapping("/")
	@CrossOrigin(origins = "*")
	@Transactional
	public ResponseEntity post(@RequestBody StarDTO starDTO) {
		
		try {
			return ResponseEntity.status(HttpStatus.OK).body(starService.post(starDTO));
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\": \"Error. Please check the BODY request, and try again later.\"}");
		}
	}
	
	@PutMapping("/{id}")
	@CrossOrigin(origins = "*")
	@Transactional
	public ResponseEntity put(@PathVariable int id, @RequestBody StarDTO starDTO) {
		
		try {
			return ResponseEntity.status(HttpStatus.OK).body(starService.put(id, starDTO));
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\": \"Error. Please check the ID or BODY request, and try again later.\"}");
		}
		
	}
	
	@DeleteMapping("/{id}")
	@CrossOrigin(origins = "*")
	@Transactional
	public ResponseEntity delete(@PathVariable int id) {
		
		try {
			starService.delete(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("");
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\": \"Error. Please check the ID or BODY request, and try again later.\"}");
		}
	}

}
