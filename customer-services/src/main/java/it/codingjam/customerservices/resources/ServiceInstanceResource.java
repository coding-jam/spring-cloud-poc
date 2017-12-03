package it.codingjam.customerservices.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
public class ServiceInstanceResource {

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/available-services")
    public List<ServiceInstance> getServiceInstances() {
        return this.discoveryClient.getServices().stream()
                .map(this.discoveryClient::getInstances)
                .flatMap(Collection::stream)
                .collect(toList());
    }
}
