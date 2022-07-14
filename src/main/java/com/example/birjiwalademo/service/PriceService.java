package com.example.birjiwalademo.service;

import com.example.birjiwalademo.DTO.PriceDTO;
import com.example.birjiwalademo.entity.Component;
import com.example.birjiwalademo.entity.Price;
import com.example.birjiwalademo.repository.PriceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceService {
    private final PriceRepository priceRepository;
    private final ComponentService componentService;

    public PriceService(PriceRepository priceRepository, ComponentService componentService) {
        this.priceRepository = priceRepository;
        this.componentService = componentService;
    }

    public Price savePrice(PriceDTO priceDTO) {
        Component component = componentService.getComponentById(priceDTO.getCname());
        Price price = Price.builder().phash(priceDTO.getPhash()).price(priceDTO.getPrice()).component(component).build();
        component.getPname().add(price);
        componentService.saveComponent(component);
        return priceRepository.save(price);
    }

    public List<Price> getAllPrices() {
        return priceRepository.findAll();
    }

    public List<Price> findPricesByComponents(String cname) {
        return priceRepository.findByComponent(cname);
    }
}
