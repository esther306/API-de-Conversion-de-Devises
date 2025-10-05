package ExchangeRate.currency.currency;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.web.bind.annotation.*;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path ="/Conversion")
public class CurrencyController {

    private final CurrencyService currencyService;
    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @PostMapping(path ="/{src_currency}/{target_currency}/{amount}")
    @Operation(
            summary = "Convert currency",
            description = "Convert a given amount from one currency to another using real-time exchange rates"
    )
    public double  getConvertedAmount(
            @Parameter(description = "Source currency (e.g., EUR)") @PathVariable String src_currency,
            @Parameter(description = "Target currency (e.g., USD)") @PathVariable String target_currency,
            @Parameter(description = "Amount to convert") @PathVariable double amount
    ) {

        return currencyService.getCurrency(src_currency,
                target_currency, amount);

    }
}
