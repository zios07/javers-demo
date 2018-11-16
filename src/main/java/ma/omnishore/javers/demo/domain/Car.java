/**
 * 
 */
package ma.omnishore.javers.demo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Zkaoukab
 *
 */

@Entity
@Table(name = "TB_CAR")
public class Car {

	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	
	@ManyToOne
	private Brand brand;
	
//	@ManyToMany
//	private transient List<Option> options;

	public Car(Brand brand) {
		super();
		this.brand = brand;
//		this.options = options;
	}

	public Car(String name, Brand brand) {
		super();
		this.name = name;
		this.brand = brand;
	}

	public Car() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
