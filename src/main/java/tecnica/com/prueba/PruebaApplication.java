package tecnica.com.prueba;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import tecnica.com.prueba.Modelo.Company;
import tecnica.com.prueba.Modelo.Curr;
import tecnica.com.prueba.Modelo.ListPrice;
import tecnica.com.prueba.Modelo.Price;
import tecnica.com.prueba.Repository.CompanyRepository;
import tecnica.com.prueba.Repository.CurrRepository;
import tecnica.com.prueba.Repository.ListPriceRepository;
import tecnica.com.prueba.Repository.PriceRepository;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class PruebaApplication  {

	@Autowired
	private CurrRepository currRepository;
	@Autowired
	private CompanyRepository companyRepository;
	@Autowired
	private ListPriceRepository listPriceRepository;
	@Autowired
	private PriceRepository priceRepository;

	public static void main(String[] args) {
		SpringApplication.run(PruebaApplication.class, args);
	}

	@Bean
	InitializingBean initialDatabase(){
		return()->{
			Curr moneda=new Curr(1L,"Euros");
			Company company = new Company(1L,"ZARA");
			ListPrice listPrice=new ListPrice(1L,"Lista 1");
			moneda=currRepository.save(moneda);
			company=companyRepository.save(company);
			listPrice=listPriceRepository.save(listPrice);
			Price price1=new Price();
			price1.setBRAND_ID(company);
			price1.setPRICE(2.50f);
			price1.setPRIORITY(1);
			price1.setDESCRIPTION("Producto 1");
			price1.setCURR_ID(moneda);
			price1.setSTART_DATE(LocalDateTime.now());
			Set<ListPrice> listPrices=new HashSet<>();
			listPrices.add(listPrice);
			price1.setPRODUCT_LIST(listPrices);
			priceRepository.save(price1);
		};
	}
}