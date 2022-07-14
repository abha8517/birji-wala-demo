package com.example.birjiwalademo.controller;

import com.example.birjiwalademo.entity.Component;
import com.example.birjiwalademo.service.ComponentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ComponentController {
    private ComponentService componentService;

    public ComponentController(ComponentService componentService) {
        this.componentService = componentService;
    }

    @RequestMapping(value = "/addComponent", method = RequestMethod.POST)
    public Component addNewComponent(@RequestBody Component component) {
        return componentService.saveComponent(component);
    }

    @RequestMapping(value = "/getAllComponent", method = RequestMethod.GET)
    public List<Component> getAllComponents() {
        return componentService.getComponent();
    }

    @RequestMapping(value = "/getComponent/{cname}", method = RequestMethod.GET)
    public Component getComponentByID(@PathVariable String cname) {
        return componentService.getComponentById(cname);
    }
}
