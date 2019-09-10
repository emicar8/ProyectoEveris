package api.everis.DTO;

public class StarDTO extends BaseDTO{
	
	private String name;
	private int density;
	
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

}
