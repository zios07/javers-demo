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

import ma.omnishore.javers.demo.domain.Person;
import ma.omnishore.javers.demo.repository.PersonRepository;

/**
 * @author Zkaoukab
 *
 */

@RestController
@RequestMapping(value = "persons")
public class PersonController {

	@Autowired
	private PersonRepository repo;

	@GetMapping
	public List<Person> getAll() {
		return repo.findAll();
	}

	@GetMapping(value = "{id}")
	public Person getOne(@PathVariable Long id) {
		return repo.findOne(id);
	}
	
	@PostMapping
	public Person create(@RequestBody Person person) {
		return repo.save(person);
	}
	
	@PutMapping
	public Person update(@RequestBody Person person) {
		return repo.save(person);
	}

	@DeleteMapping(value = "{id}")
	public void deleteOne(@PathVariable Long id) {
		repo.delete(id);
	}

}
