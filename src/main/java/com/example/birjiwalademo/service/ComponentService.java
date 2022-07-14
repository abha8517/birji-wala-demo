package com.example.birjiwalademo.service;

import com.example.birjiwalademo.entity.Component;
import com.example.birjiwalademo.repository.ComponentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComponentService {
    private final ComponentRepository componentRepository;

    public ComponentService(ComponentRepository componentRepository) {
        this.componentRepository = componentRepository;
    }

    public Component saveComponent(Component component) {
        return componentRepository.save(component);
    }

    public List<Component> getComponent() {
        return componentRepository.findAll();
    }

    public Component getComponentById(String cname) {
        if (componentRepository.findById(cname).isPresent()) {
            return componentRepository.findById(cname).get();
        } else return null;
    }
}
