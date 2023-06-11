package tecnica.com.prueba.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ResultSearchDto {
    private Long productId;
    private String descriptionPrice;
    private Long companyId;
    private String nameCompany;
    private Long listId;
    private String descriptionList;
    private LocalDateTime startDate;
    private float price;
    private String currency;
}
