package com.sdia.reservationsservice.feign;

import com.sdia.reservationsservice.model.Resource;
import com.sdia.reservationsservice.security.FeignAdapter;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "resources-service" ,configuration = FeignAdapter.class)
public interface ResourceFeignClient {
    @GetMapping(path = "/resources")
    @CircuitBreaker(name = "resources", fallbackMethod = "getDefaultResources")
    List<Resource> getAllResources();

    @GetMapping(path = "/resources/{id}")
    @CircuitBreaker(name = "resourcesService", fallbackMethod = "getDefaultResource")
    Resource getResourceById(@PathVariable(name = "id") Long id);

    default List<Resource> getDefaultResources() {
        return List.of();
    }
    default Resource getDefaultResource(Long id,Exception e){
        return Resource.builder()
                .id(id)
                .name("defaultName for => "+id)
                .type("defaultType for => "+id)
                .build();
    }
}
