package tecnica.com.prueba.Modelo;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
public class Company {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @JoinColumn(name="BRAND_ID")
    private Long BRAND_ID;

    @JoinColumn(name="NAME_COMPANY")
    private String NAME_COMPANY;

    public Company(){}

    public Company(Long BRAND_ID, String NAME_COMPANY){
        this.BRAND_ID=BRAND_ID;
        this.NAME_COMPANY=NAME_COMPANY;
    }
}
