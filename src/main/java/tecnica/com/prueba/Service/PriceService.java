package tecnica.com.prueba.Service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tecnica.com.prueba.Controller.BusquedaController;
import tecnica.com.prueba.Repository.PriceRepository;
import tecnica.com.prueba.dto.ResultSearchDto;
import tecnica.com.prueba.dto.SearchParamsDto;

import javax.websocket.OnClose;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class PriceService {

    final static DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static final Logger logger= LogManager.getLogger(PriceService.class);
    @Autowired
    private PriceRepository priceRepository;
    public List<ResultSearchDto>getSearchByParam(SearchParamsDto request){
        LocalDateTime startDateSearch=request.getDateApplication().minusMonths(1);
        LocalDateTime endDateSearch=request.getDateApplication().plusMonths(1);
        String startDateSearchFormated=startDateSearch.format(dateFormat);
        String endDateSearchFormated=endDateSearch.format(dateFormat);
        List<Object[]>resultado;
        resultado=priceRepository.Consulta(startDateSearchFormated,endDateSearchFormated);
        List<ResultSearchDto>results=mapper(resultado);
        return results;
    }

    private List<ResultSearchDto>mapper(List<Object[]> data){
        List<ResultSearchDto> mapped=new ArrayList<>();
        Iterator itr=data.iterator();
        while(itr.hasNext()){
            Object[]obj=(Object[]) itr.next();
            ResultSearchDto resultSearchDto=new ResultSearchDto();
            resultSearchDto.setProductId(((BigInteger)obj[0]).longValue());
            resultSearchDto.setDescriptionPrice((String)obj[1]);
            resultSearchDto.setCompanyId(((BigInteger)obj[2]).longValue());
            resultSearchDto.setNameCompany((String)obj[3]);
            resultSearchDto.setListId(((BigInteger)obj[4]).longValue());
            resultSearchDto.setDescriptionList((String)obj[5]);
            resultSearchDto.setStartDate(((Timestamp) obj[6]).toLocalDateTime());
            resultSearchDto.setPrice(((Double) obj[7]).floatValue());
            resultSearchDto.setCurrency((String)obj[8]);
            mapped.add(resultSearchDto);
        }
        return mapped;
    }
}
