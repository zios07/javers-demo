/**
 * 
 */
package ma.omnishore.javers.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.omnishore.javers.demo.domain.Car;

/**
 * @author Zkaoukab
 *
 */
@Repository
//@JaversSpringDataAuditable
public interface CarRepository extends JpaRepository<Car, Long> {

}
