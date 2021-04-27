package com.example.MaintenanceRequest.View;
import com.example.MaintenanceRequest.ViewModel.CustServViewModel;

import com.example.MaintenanceRequest.View.CustomerRequestView;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.Route;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Route("")
public class MainView extends Div{


	private Div header;
	private CustServViewModel viewModel;
	
	
	
	public MainView(CustServViewModel viewModel) {
		
		this.viewModel = viewModel;
		addHeader();
		
		Tab CsrTab = new Tab("CSR Maintenance Request View");
		Div CsrPage = new CsrRequestView(viewModel);	

		Tab CustomerTab = new Tab("Customer Maintenance Request View");
		Div CustomerPage = new CustomerRequestView(viewModel);
		CsrPage.setVisible(false);


		Map<Tab, Component> tabsToPages = new HashMap<>();
		tabsToPages.put(CsrTab, CsrPage);
		tabsToPages.put(CustomerTab, CustomerPage);
		Tabs tabs = new Tabs(CsrTab, CustomerTab);
		Div pages = new Div(CsrPage, CustomerPage);

		tabs.addSelectedChangeListener(event -> {
		    tabsToPages.values().forEach(page -> page.setVisible(false));
		    Component selectedPage = tabsToPages.get(tabs.getSelectedTab());
		    selectedPage.setVisible(true);
		});

		add(tabs, pages);
		
		
		
		
	}
	
	private void addHeader()
	{
		this.header = new Div();
		HorizontalLayout headerLayout = new HorizontalLayout();
		
		Image i = new Image("https://i.ibb.co/P60D1bV/logo.png", "Maintenance Request System logo");
		i.setWidth(5f, Unit.PERCENTAGE);
		i.setHeight(5f, Unit.PERCENTAGE);
		i.setAlt("Maintenance Request System logo");
		
		headerLayout.add(i);
		headerLayout.add(new H1("Maintenance Request System"));
		headerLayout.setAlignItems(Alignment.CENTER);
		this.header.add(headerLayout);
		this.header.setWidthFull();
		add(this.header);
	}
	
	
}
