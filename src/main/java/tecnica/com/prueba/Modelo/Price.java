package tecnica.com.prueba.Modelo;


import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@Entity
@Table
public class Price {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="PRODUCT_ID")
    private Long PRODUCT_ID;

    @Column(name="DESCRIPTION")
    private String DESCRIPTION;

    @ManyToOne
    @JoinColumn(name="BRAND_ID")
    private Company BRAND_ID;

    @Column(name="START_DATE")
    private LocalDateTime START_DATE;
    @Column(name="END_DATE")
    private LocalDateTime END_DATE;

    @ManyToMany
    @JoinTable(
            name="PRICE_X_LIST",
            joinColumns = @JoinColumn(name="PRODUCT_ID",referencedColumnName = "PRODUCT_ID"),
            inverseJoinColumns = @JoinColumn(name="LIST_ID",referencedColumnName = "LIST_ID")
    )
    Set<ListPrice> PRODUCT_LIST;

    @Column(name="PRIORITY")
    private Integer PRIORITY;
    @Column(name="PRICE")
    private float PRICE;

    @ManyToOne
    @JoinColumn(name="CURR_ID")
    private Curr CURR_ID;
}
