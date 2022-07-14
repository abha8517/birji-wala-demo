package com.example.birjiwalademo.controller;

import com.example.birjiwalademo.DTO.PriceDTO;
import com.example.birjiwalademo.entity.Price;
import com.example.birjiwalademo.service.ComponentService;
import com.example.birjiwalademo.service.PriceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PriceController {
    private PriceService priceService;
    private ComponentService componentService;

    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }

    @RequestMapping(value = "/addPrice", method = RequestMethod.POST)
    public Price addNewComponent(@RequestBody PriceDTO priceDTO) {
        return priceService.savePrice(priceDTO);
    }

    @RequestMapping(value = "/getAllPrice", method = RequestMethod.GET)
    public List<Price> getAllPrice() {
        return priceService.getAllPrices();
    }

    @RequestMapping(value = "/getPrices/{cname}", method = RequestMethod.GET)
    public List<Price> getPriceByCname(@PathVariable String cname) {
        return priceService.findPricesByComponents(cname);
    }
}
