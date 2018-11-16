/**
 * 
 */
package ma.omnishore.javers.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.omnishore.javers.demo.domain.Car;
import ma.omnishore.javers.demo.repository.CarRepository;

/**
 * @author Zkaoukab
 *
 */

@RestController
@RequestMapping(value = "cars")
public class CarController {

	@Autowired
	private CarRepository repo;

	@GetMapping
	public List<Car> getAll() {
		return repo.findAll();
	}

	@GetMapping(value = "{id}")
	public Car getOne(@PathVariable Long id) {
		return repo.findOne(id);
	}
	
	@PostMapping
	public Car create(@RequestBody Car car) {
		return repo.save(car);
	}
	
	@PutMapping
	public Car update(@RequestBody Car car) {
		return repo.save(car);
	}

	@DeleteMapping(value = "{id}")
	public void deleteOne(@PathVariable Long id) {
		repo.delete(id);
	}

}
