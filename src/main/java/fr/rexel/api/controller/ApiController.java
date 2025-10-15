package fr.rexel.api.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ApiController {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @GetMapping("/stock")
    public Map<String, Object> getStock() throws IOException {
        ClassPathResource resource = new ClassPathResource("mock/stock.json");
        return objectMapper.readValue(resource.getInputStream(), new TypeReference<>() {});
    }

    @GetMapping("/prices")
    public Map<String, Object> getPrices() throws IOException {
        ClassPathResource resource = new ClassPathResource("mock/prices.json");
        return objectMapper.readValue(resource.getInputStream(), new TypeReference<>() {});
    }

    @GetMapping("/order")
    public Map<String, Object> postOrder() throws IOException {
        ClassPathResource resource = new ClassPathResource("mock/order.json");
        return objectMapper.readValue(resource.getInputStream(), new TypeReference<>() {});
    }

    @GetMapping("/quotes")
    public Map<String, Object> getQuotes() throws IOException {
        ClassPathResource resource = new ClassPathResource("mock/quotes.json");
        return objectMapper.readValue(resource.getInputStream(), new TypeReference<>() {});
    }
}
