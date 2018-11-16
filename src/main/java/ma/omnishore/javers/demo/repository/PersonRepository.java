/**
 * 
 */
package ma.omnishore.javers.demo.repository;

import javax.transaction.Transactional;

import org.javers.spring.annotation.JaversSpringDataAuditable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.omnishore.javers.demo.domain.Person;

/**
 * @author Zkaoukab
 *
 */
@Repository
@Transactional
@JaversSpringDataAuditable
public interface PersonRepository extends JpaRepository<Person, Long> {

}
