package com.sdia.resourcesservice.mappers;

import com.sdia.resourcesservice.Dtos.ResourceClient;
import com.sdia.resourcesservice.entity.Resource;
import com.sdia.resourcesservice.enums.ResourceType;

public class ResourceMappers {
    public static Resource resouceClientToResource(ResourceClient resourceClient){
        return Resource.builder()
                .name(resourceClient.getName())
                .type(ResourceType.valueOf(resourceClient.getType()))
                .build();
    }
    public static ResourceClient resourceToResourceClient(Resource resource){
        return ResourceClient.builder()
                .name(resource.getName())
                .type(resource.getType().toString())
                .build();
    }
}
