package ii.microservices.breweryclient.clients;

import ii.microservices.breweryclient.models.BeerDTO;
import ii.microservices.breweryclient.models.CustomerDTO;
import jakarta.annotation.PostConstruct;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@Setter
@ConfigurationPropertiesBinding
@ConfigurationProperties(prefix = "ii.brewery", ignoreUnknownFields = false)
@Component
@NoArgsConstructor
public class BreweryClient{

    public final String BEER_PATH_V1 = "/api/v1/beer/";
    public final String CUSTOMER_PATH_V1 = "/api/v1/customer";
    private String apihost;

    private RestTemplate restTemplate;

    public BreweryClient(RestTemplateBuilder restTemplateBuilder){
        this.restTemplate = restTemplateBuilder.build();
    }
    @PostConstruct
    private void init() {
        restTemplate = new RestTemplate();
    }

    public BeerDTO getBeer(UUID beerId){
        return restTemplate.getForObject(apihost + BEER_PATH_V1 + beerId.toString(), BeerDTO.class);
    }

    public URI saveNewBeer(BeerDTO beerDTO){
        return restTemplate
                .postForLocation(apihost + BEER_PATH_V1+"/createBeer",beerDTO);
    }

    public void updateBeer(UUID beerId, BeerDTO beerDTO){
        restTemplate.put(apihost+BEER_PATH_V1+"/updateBeer/"+beerId.toString(),beerDTO);
    }

    public void deleteBeer(UUID beerId){
        restTemplate.delete(apihost+BEER_PATH_V1+"/deleteBeer/"+beerId);
    }

    public CustomerDTO getCustomer(UUID customerId){
        return restTemplate
                .getForObject(apihost+ CUSTOMER_PATH_V1+customerId.toString(),CustomerDTO.class);
    }

    public URI saveNewCustomer(CustomerDTO customerDTO){
        return restTemplate.postForLocation(apihost+CUSTOMER_PATH_V1+"/createCustomer",customerDTO);
    }

    public void updateCustomer(UUID customerId, CustomerDTO customerDTO){
        restTemplate.put(apihost+CUSTOMER_PATH_V1+"/updateCustomer/"+ customerId.toString(),customerDTO);
    }

    public void deleteCustomer(UUID customerId){
        restTemplate.delete(apihost+CUSTOMER_PATH_V1+"/deleteCustomer/"+customerId);
    }

}
