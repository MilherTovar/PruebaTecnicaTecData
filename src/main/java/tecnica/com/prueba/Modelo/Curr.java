package tecnica.com.prueba.Modelo;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
public class Curr {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @JoinColumn(name="CURR_ID")
    private Long CURR_ID;

    @JoinColumn(name="NAME_CURR")
    private String NAME_CURR;

    public Curr(long CURR_ID, String NAME_CURR) {
        this.CURR_ID=CURR_ID;
        this.NAME_CURR=NAME_CURR;
    }

    public Curr() {}
}
