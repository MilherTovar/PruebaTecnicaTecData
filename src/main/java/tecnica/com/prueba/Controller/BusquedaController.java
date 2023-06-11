package tecnica.com.prueba.Controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tecnica.com.prueba.Service.PriceService;
import tecnica.com.prueba.dto.ResultSearchDto;
import tecnica.com.prueba.dto.SearchParamsDto;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/search")
public class BusquedaController {

    private static final Logger logger= LogManager.getLogger(BusquedaController.class);

    @Autowired
    private PriceService priceService;

    @GetMapping("searchByParam")
    public ResponseEntity<?>getSearchByParam(@RequestBody SearchParamsDto searchParamsDto){
        try{
            List<ResultSearchDto> data=priceService.getSearchByParam(searchParamsDto);
            return new ResponseEntity<>(data, HttpStatus.OK);
        }
        catch (Exception e){
            logger.error("Error: "+e.getMessage());
            return new ResponseEntity<>("Error "+e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
