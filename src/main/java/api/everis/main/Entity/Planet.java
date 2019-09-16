package api.everis.main.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "api_planet")
public class Planet extends Base {
	
	@Column(name = "planet_name")
	private String name;
	
	@Column(name = "planet_size")
	private int size;
	
	@ManyToOne
	@JoinColumn(name = "Star.id")
	private Star star;	
	
	public Planet() {
	}

	public Planet(String name, int size, Star star) {
		this.name = name;
		this.size = size;
		this.star = star;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Star getStar() {
		return star;
	}

	public void setStar(Star star) {
		this.star = star;
	}
	
	
	
	
	
}
