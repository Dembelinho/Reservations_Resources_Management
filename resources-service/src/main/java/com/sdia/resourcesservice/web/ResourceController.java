package com.sdia.resourcesservice.web;

import com.sdia.resourcesservice.Dtos.ResourceClient;
import com.sdia.resourcesservice.entity.Resource;
import com.sdia.resourcesservice.mappers.ResourceMappers;
import com.sdia.resourcesservice.repository.ResourceRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @Slf4j @AllArgsConstructor //@CrossOrigin("*")
public class ResourceController {

    private ResourceRepository resourceRepository;

    @GetMapping(path = "/resources")
    public List<Resource> getAllResources(){
        List<Resource> resourceList = resourceRepository.findAll();
        return resourceList;
    }
    @GetMapping(path = "/resources/{id}")
    public Resource getResourceById(@PathVariable(name = "id") Long id){
        Resource resource = resourceRepository.findById(id).get();
        return resource;
    }
    @PostMapping("/resources/add")
        public Resource saveResource(@RequestBody ResourceClient resource){
        return resourceRepository.save(ResourceMappers.resouceClientToResource(resource));
    }
    @DeleteMapping("/resources/delete/{id}")
    public void deleteResource(@PathVariable(name = "id") Long id){
        resourceRepository.deleteById(id);
    }
}
