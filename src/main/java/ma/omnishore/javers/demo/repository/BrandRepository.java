/**
 * 
 */
package ma.omnishore.javers.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.omnishore.javers.demo.domain.Brand;

/**
 * @author Zkaoukab
 *
 */
@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {

}
