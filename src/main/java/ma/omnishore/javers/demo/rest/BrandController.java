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

import ma.omnishore.javers.demo.domain.Brand;
import ma.omnishore.javers.demo.repository.BrandRepository;

/**
 * @author Zkaoukab
 *
 */

@RestController
@RequestMapping(value = "brands")
public class BrandController {

	@Autowired
	private BrandRepository repo;

	@GetMapping
	public List<Brand> getAll() {
		return repo.findAll();
	}

	@GetMapping(value = "{id}")
	public Brand getOne(@PathVariable Long id) {
		return repo.findOne(id);
	}
	
	@PostMapping
	public Brand create(@RequestBody Brand brand) {
		return repo.save(brand);
	}
	
	@PutMapping
	public Brand update(@RequestBody Brand brand) {
		return repo.save(brand);
	}

	@DeleteMapping(value = "{id}")
	public void deleteOne(@PathVariable Long id) {
		repo.delete(id);
	}

}
