package api.everis.main.DTO;

public class PlanetDTO extends BaseDTO{
	
	private String name;
	private int size;
	private StarDTO star;
	
	public PlanetDTO() {
	}
	
	public PlanetDTO(String name, int size, StarDTO star) {
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

	public StarDTO getStar() {
		return star;
	}

	public void setStar(StarDTO star) {
		this.star = star;
	}
	
	

}
