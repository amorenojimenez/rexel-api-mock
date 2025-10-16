package fr.rexel.api.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.rexel.api.controller.dto.OrderRequestDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/api")
@Tag(name = "Resailer API", description = "Procurement set of endpoints")
public class ApiController {


    private static final Logger logger = LoggerFactory.getLogger(ApiController.class);
    private final ObjectMapper objectMapper = new ObjectMapper();

    @GetMapping("/stock")
    @Operation(summary = "Get stocks of a certain product")
    public Map<String, Object> getStock(@Parameter(description = "id of the product")  @RequestParam String productId) throws IOException {
        logger.info("getStock called {}", productId);
        ClassPathResource resource = new ClassPathResource("mock/stock.json");
        return objectMapper.readValue(resource.getInputStream(), new TypeReference<>() {});
    }

    @GetMapping("/prices")
    @Operation(summary = "Get current list of prices of a certain product")
    public Map<String, Object> getPrices(@Parameter(description = "id of the product")  @RequestParam String productId) throws IOException {
        logger.info("getPrices called {}", productId);
        ClassPathResource resource = new ClassPathResource("mock/prices.json");
        return objectMapper.readValue(resource.getInputStream(), new TypeReference<>() {});
    }

    @PostMapping("/order")
    @Operation(summary = "Request a new order")
    public Map<String, Object> postOrder(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Order request")
            @RequestBody OrderRequestDto orderRequestDto) throws IOException {
        logger.info("postOrder called {}", orderRequestDto);
        ClassPathResource resource = new ClassPathResource("mock/order.json");
        return objectMapper.readValue(resource.getInputStream(), new TypeReference<>() {});
    }

    @GetMapping("/quotes")
    @Operation(summary = "Get list of pending quotes")
    public Map<String, Object> getQuotes() throws IOException {
        logger.info("getQuotes called");
        ClassPathResource resource = new ClassPathResource("mock/quotes.json");
        return objectMapper.readValue(resource.getInputStream(), new TypeReference<>() {});
    }
}
