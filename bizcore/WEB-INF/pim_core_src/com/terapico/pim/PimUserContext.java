package com.terapico.pim;

public interface PimUserContext extends UserContext{
    //define the domain specific user model
	String getLocaleKey(String subject);
	void setChecker(PimChecker checker);
	PimChecker getChecker();
}

