package com.example.proj.rest;

import com.opensymphony.xwork2.ModelDriven;
import com.example.proj.model.*;
import java.util.*;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;

public class AccountsController implements ModelDriven<Object> {
    private static final long serialVersionUID = 1L;
    private Object model;
    private AccountsRepository accountsRepository = new AccountsRepository();
    private String id;
    private static Map<String, Accounts> map;
    Accounts account = new Accounts();

    
    {
        map = accountsRepository.findAllAccounts();
    }

    public HttpHeaders index() {
        model = map;
        return new DefaultHttpHeaders("index").disableCaching();
    }

    public HttpHeaders show() {
		model = accountsRepository.getAccountById(getId());
		return new DefaultHttpHeaders("show");
	}
    // mag error og dili butngan og public save accounts
    public HttpHeaders create() {
        accountsRepository.save(account);
        return new DefaultHttpHeaders("create");
    }

    public String getId() {
		return id;
	}

    public void setId(String id) {
		model = accountsRepository.getAccountById(id);
		this.id = id;
	}

    @Override
    public Object getModel() {
        return (model != null ? model : account);
    }
}