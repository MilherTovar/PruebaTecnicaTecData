package tecnica.com.prueba.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tecnica.com.prueba.Modelo.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
