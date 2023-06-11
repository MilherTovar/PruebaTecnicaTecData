package tecnica.com.prueba.Modelo;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table
public class ListPrice {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @JoinColumn(name="LIST_ID")
    private Long LIST_ID;

    @JoinColumn(name="LIST_DESCRIPTION")
    private String LIST_DESCRIPTION;

    public ListPrice(){}
    public ListPrice(Long LIST_ID, String LIST_DESCRIPTION){
        this.LIST_ID=LIST_ID;
        this.LIST_DESCRIPTION=LIST_DESCRIPTION;
    }
}
