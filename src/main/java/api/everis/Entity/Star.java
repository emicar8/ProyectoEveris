package api.everis.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity(name = "api_star")
public class Star extends Base{
	
	@Column(name = "star_name")
	private String name;
	
	@Column(name = "star_density")
	private int density;
	
	@OneToMany(mappedBy = "star")
	private List<Planet> planets = new ArrayList<>();
	
	public Star() {
	}
	
	public Star(String name, int density) {
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

}
