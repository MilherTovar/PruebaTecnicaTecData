package tecnica.com.prueba.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tecnica.com.prueba.Modelo.Curr;

public interface CurrRepository extends JpaRepository<Curr, Long> {
}
