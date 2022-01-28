package br.com.sabrina.aws_project02.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.sabrina.aws_project02.model.ProductEventLogDto;
import br.com.sabrina.aws_project02.repository.ProductEventLogRepository;

@RestController
@RequestMapping("/api/events")
public class ProductEventLogController {

    private ProductEventLogRepository productEventLogRepository;

    @Autowired
    public ProductEventLogController(ProductEventLogRepository productEventLogRepository) {
        this.productEventLogRepository = productEventLogRepository;
    }

    @GetMapping
    public List<ProductEventLogDto> getAllEvents() {
        return StreamSupport
                .stream(productEventLogRepository.findAll().spliterator(), false)
                .map(ProductEventLogDto::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/{code}")
    public List<ProductEventLogDto> getEventsByCode(@PathVariable String code) {
        return StreamSupport
                .stream(productEventLogRepository.findAllByPk(code).spliterator(), false)
                .map(ProductEventLogDto::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/{code}/{event}")
    public List<ProductEventLogDto> getEventsByCodeAndEventType(@PathVariable String code, @PathVariable String event) {
        return StreamSupport
                .stream(productEventLogRepository.findAllByPkAndSkStartsWith(code, event).spliterator(), false)
                .map(ProductEventLogDto::new)
                .collect(Collectors.toList());
    }
    
}