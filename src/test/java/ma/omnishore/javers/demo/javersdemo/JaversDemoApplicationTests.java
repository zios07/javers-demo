package ma.omnishore.javers.demo.javersdemo;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ma.omnishore.javers.demo.domain.Brand;
import ma.omnishore.javers.demo.domain.Car;
import ma.omnishore.javers.demo.domain.Person;
import ma.omnishore.javers.demo.repository.BrandRepository;
import ma.omnishore.javers.demo.repository.CarRepository;
import ma.omnishore.javers.demo.repository.PersonRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JaversDemoApplicationTests {

	@Autowired
	BrandRepository brandRepo;

	@Autowired
	CarRepository carRepo;

	@Autowired
	PersonRepository personRepo;

//	@Autowired
//	OptionRepository optRepo;

	@Test
	// @Transactional
	public void test() {
		Brand brand1 = new Brand("BMW");
		Brand brand2 = new Brand("MERCEDES");
		Brand brand3 = new Brand("FIAT");
		brand1 = brandRepo.save(brand1);
		brand2 = brandRepo.save(brand2);
		brand3 = brandRepo.save(brand3);

//		Option option1 = new Option("CLIM");
//		Option option2 = new Option("AIRBAG");
//		Option option3 = new Option("GPS");
//		option1 = optRepo.save(option1);
//		option2 = optRepo.save(option2);
//		option3 = optRepo.save(option3);

		Car car1 = new Car(brand1);
		Car car2 = new Car(brand2);
		Car car3 = new Car(brand1);
		Car car4 = new Car(brand3);

		car1 = carRepo.save(car1);
		car2 = carRepo.save(car2);
		car3 = carRepo.save(car3);
		car4 = carRepo.save(car4);

		Person person = new Person("Zack", Arrays.asList(car1, car3));
		Person person2 = new Person("Mohammed", Arrays.asList(car2, car3, car4));
		Person person3 = new Person("Mehdi", Arrays.asList(car1));

		personRepo.save(person);
		personRepo.save(person2);
		personRepo.save(person3);

		List<Person> persons = personRepo.findAll();
		assertEquals(3, persons.size());

	}

}
