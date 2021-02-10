package com.app.service.Impl;

import com.app.service.MyService;

public class MyServiceImpl implements MyService {
	
	@Override
	public boolean isValidEvenNumber(int n) {
		
		return(n%2==0);
	}

}
