package tecnica.com.prueba.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tecnica.com.prueba.Modelo.ListPrice;

public interface ListPriceRepository extends JpaRepository<ListPrice,Long> {
}
