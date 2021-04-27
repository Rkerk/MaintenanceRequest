package com.example.MaintenanceRequest.Entity;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Document(collection = "Maintenance_Requests")
public class MaintenanceRequest {

	
		@Id
		private String id = null;
		
		@Indexed
		@Field("customerID")
	 	private String customerID;
	 
	 	@Indexed
	 	@Field("requestID")
	    private String requestID;
	 	
	 	@Indexed
	 	@Field("date")
	    private String date;
	 	
	 	@Indexed
	 	@Field("itemName")
	    private String itemName;
	 	
	 	@Indexed
	 	@Field("itemAssetTag")
	    private String itemAssetTag;
	 	
	 	@Indexed
	 	@Field("requestStatus")
	    private String requestStatus;
	 	
	 	@Indexed
	 	@Field("description")
	    private String description;

	   
	    public String getCustomerID() {
	        return customerID;
	    }
	    public void setCustomerID(String customerID) {
	        this.customerID = customerID;
	    }
	    public String getRequestID() {
	        return requestID;
	    }
	    public void setRequestID(String requestID) {
	        this.requestID = requestID;
	    }
	    public String getDate() {
	        return date;
	    }
	    public void setDate(String date) {
	        this.date = date;
	    }
	    public String getItemName() {
	        return itemName;
	    }
	    public void setItemName(String itemName) {
	        this.itemName = itemName;
	    }
	    public String getItemAssetTag() {
	        return itemAssetTag;
	    }
	    public void setItemAssetTag(String itemAssetTag) {
	        this.itemAssetTag = itemAssetTag;
	    }
	    public String getRequestStatus() {
	        return requestStatus;
	    }
	    public void setRequestStatus(String requestStatus) {
	        this.requestStatus = requestStatus;
	    }
	    public String getDescription() {
	        return description;
	    }
	    public void setDescription(String description) {
	        this.description = description;
	    }

}
