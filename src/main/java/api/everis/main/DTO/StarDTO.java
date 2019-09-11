package api.everis.main.DTO;

import java.util.ArrayList;
import java.util.List;

public class StarDTO extends BaseDTO{
	
	private String name;
	private int density;
	private List<PlanetDTO> planets = new ArrayList<>();
	
	
	public StarDTO() {
	}
	
	public StarDTO(String name, int density) {
		this.name = name;
		this.density = density;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getDensity() {
		return density;
	}
	
	public void setDensity(int density) {
		this.density = density;
	}

	public List<PlanetDTO> getPlanets() {
		return planets;
	}

	public void setPlanets(List<PlanetDTO> planets) {
		this.planets = planets;
	}

}
