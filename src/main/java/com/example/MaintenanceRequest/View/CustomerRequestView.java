package com.example.MaintenanceRequest.View;

import org.vaadin.crudui.crud.impl.GridCrud;

import com.example.MaintenanceRequest.Entity.MaintenanceRequest;
import com.example.MaintenanceRequest.ViewModel.CustServViewModel;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Route;

public class CustomerRequestView extends Div{

public CustomerRequestView(CustServViewModel service) {
		
		GridCrud<MaintenanceRequest> crud = new GridCrud<>(MaintenanceRequest.class, service);
		crud.getCrudFormFactory().setVisibleProperties("requestID", "date", "itemName", "itemAssetTag", "requestStatus", "description");
		crud.getGrid().setColumns("requestID", "date", "itemName", "itemAssetTag", "requestStatus", "description");
		
		add(crud);
		setSizeFull();
	}
	
}
