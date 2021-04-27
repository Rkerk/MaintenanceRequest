package com.example.MaintenanceRequest.ViewModel;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.vaadin.crudui.crud.CrudListener;

import com.example.MaintenanceRequest.Entity.MaintenanceRequest;
import com.example.MaintenanceRequest.Model.CustServModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

@RestController
@Repository
public class CustServViewModel implements CrudListener<MaintenanceRequest>{
	private final CustServModel repository;
	
	    public CustServViewModel(CustServModel repository) {
	    	this.repository = repository;
	    }

	    @Override

	    public Collection<MaintenanceRequest> findAll() {

	        return repository.findAll();

	    }

	    @Override

	    public MaintenanceRequest add(MaintenanceRequest MaintenanceRequest) {

	        return repository.insert(MaintenanceRequest);
	    }

	    @Override

	    public MaintenanceRequest update(MaintenanceRequest MaintenanceRequest) {
	        return repository.save(MaintenanceRequest);
	    }
	    
	    @Override
	    public void delete(MaintenanceRequest MaintenanceRequest) {
	        repository.delete(MaintenanceRequest);
	    }
	    
	    
	    @GetMapping("/getReqID")
		public Collection<String> getReqID(@RequestParam(value = "assetTags[]", defaultValue = "") String[] assetTags){
			
			ArrayList<MaintenanceRequest> requests = new ArrayList<MaintenanceRequest> (this.findAll());
			ArrayList<String> found = new ArrayList<String>();
			
			
			for(MaintenanceRequest r: requests) {
				if(Arrays.stream(assetTags).anyMatch(assetTag -> assetTag.equals(r.getItemAssetTag()))) {
					found.add(r.getRequestID());
				}
			}
			
			return found;
		}
		
		@GetMapping("/getCustReq")
		public Collection<MaintenanceRequest> getCustReq(@RequestParam(value = "customerID[]", defaultValue = "") String[] customerID){
			
			ArrayList<MaintenanceRequest> requests = new ArrayList<MaintenanceRequest> (this.findAll());
			ArrayList<MaintenanceRequest> found = new ArrayList<MaintenanceRequest>();
			
			
			for(MaintenanceRequest r: requests) {
				if(Arrays.stream(customerID).anyMatch(CustomerID -> CustomerID.equals(r.getCustomerID()))) {
					found.add(r);
				}
			}
			
			return found;
		}
}
