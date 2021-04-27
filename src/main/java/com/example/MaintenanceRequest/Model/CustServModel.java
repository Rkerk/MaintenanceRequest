package com.example.MaintenanceRequest.Model;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.MaintenanceRequest.Entity.MaintenanceRequest;

public interface CustServModel extends MongoRepository<MaintenanceRequest, String>{

}
