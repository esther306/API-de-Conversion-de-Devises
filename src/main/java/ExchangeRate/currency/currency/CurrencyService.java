package ExchangeRate.currency.currency;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class CurrencyService {

    private final WebClient  webClient;

    public CurrencyService(WebClient webclient) {
        this.webClient = webclient;
    }

    public double getCurrency(String source_currency, String target_currency, double amount) {
        String json = webClient.get()
                .uri("https://v6.exchangerate-api.com/v6/1d56f40c65d139346b616a38/pair/{source_currency}" +
                        "/{target_currency}/{rate}", source_currency, target_currency, amount)
                .retrieve()
                .bodyToMono(String.class)
                .block();
        ObjectMapper objectMapper = new ObjectMapper();
        double conversion_result = 0.0;

          try{
              JsonNode root = objectMapper.readTree(json);
              conversion_result = root.get("conversion_result").asDouble();

          }catch(Exception e){
              System.out.println(e.getMessage());
          }
        return conversion_result;
    }
}
