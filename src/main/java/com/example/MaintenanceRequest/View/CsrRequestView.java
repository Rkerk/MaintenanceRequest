package com.example.MaintenanceRequest.View;

import org.vaadin.crudui.crud.impl.GridCrud;

import com.example.MaintenanceRequest.Entity.MaintenanceRequest;
import com.example.MaintenanceRequest.ViewModel.CustServViewModel;
import com.vaadin.flow.component.html.Div;



public class CsrRequestView extends Div{

	public CsrRequestView(CustServViewModel viewModel) {
		
		GridCrud<MaintenanceRequest> crud = new GridCrud<>(MaintenanceRequest.class, viewModel);
		
		add(crud);
		
		setSizeFull();
		
	}
}
