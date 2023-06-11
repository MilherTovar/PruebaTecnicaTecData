package tecnica.com.prueba.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SearchParamsDto {
    private LocalDateTime dateApplication;
    private Long productId;
    private Long brandId;
}