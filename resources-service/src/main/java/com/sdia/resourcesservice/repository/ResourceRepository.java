package com.sdia.resourcesservice.repository;

import com.sdia.resourcesservice.entity.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResourceRepository extends JpaRepository<Resource, Long>{
    Resource findByName(String name) ;
}
