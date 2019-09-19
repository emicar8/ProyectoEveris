package api.everis.main;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import api.everis.main.DTO.PlanetDTO;
import api.everis.main.Entity.Planet;
import api.everis.main.Repository.PlanetRepository;
import api.everis.main.Service.PlanetService;

@SpringBootTest(classes = PlanetService.class)
@RunWith(SpringRunner.class)
public class PlanetServiceTest {

	private Planet planetPrueba1, planetPrueba2;
	private List<Planet> planetsPrueba = new ArrayList<>();
	
    @Autowired
    PlanetService planetService;

    @MockBean
    private PlanetRepository planetRepository;

    
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		planetPrueba1 = new Planet("prueba1", 1, null);
		planetPrueba2 = new Planet("prueba2", 2, null);
		planetsPrueba.add(planetPrueba1);
		planetsPrueba.add(planetPrueba2);
		
		when(planetRepository.findById(1)).thenReturn(Optional.of(planetPrueba1));
		when(planetRepository.findById(2)).thenReturn(Optional.of(planetPrueba2));
		when(planetRepository.findAll()).thenReturn(planetsPrueba);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetOne() throws Exception  {
		PlanetDTO planetDTO = planetService.getOne(1);
		assertThat(planetPrueba1).isEqualToComparingFieldByField(planetDTO);
	}
	
	@Test(expected = Exception.class)
	public void testGetOneException() throws Exception  {
		planetService.getOne(100);
	}


	@Test
	public void testGetAll() throws Exception {
		List<PlanetDTO> planetsDTO = planetService.getAll();
		int i=0;
		for(Planet planet : planetsPrueba) {
			assertThat(planet).isEqualToComparingFieldByField(planetsDTO.get(i));
			i++;
		}
	}
}
