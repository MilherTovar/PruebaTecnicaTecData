package tecnica.com.prueba.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tecnica.com.prueba.Modelo.Price;

import java.util.List;

public interface PriceRepository extends JpaRepository<Price,Long> {

    @Query(value = "select " +
            "pr.product_id," +
            "pr.description," +
            "co.brand_id companyId," +
            "co.name_company nameCompany," +
            "list.list_id listId," +
            "list.list_description listDescription," +
            "pr.start_date starDatePrice," +
            "pr.price price," +
            "cu.name_curr currency " +
            "from " +
            "price pr " +
            "left join price_x_list xlist on (xlist.product_id=pr.product_id) " +
            "left join list_price list on (list.list_id=xlist.list_id) " +
            "inner join curr cu on (cu.curr_id=pr.curr_id) " +
            "inner join company co on (co.brand_id=pr.brand_id)" +
            "where pr.start_date between ?1 and ?2", nativeQuery = true)
    List<Object[]>Consulta(String startDate,String endDate);
}
