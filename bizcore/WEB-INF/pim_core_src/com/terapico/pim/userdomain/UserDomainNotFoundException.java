
package com.terapico.pim.userdomain;
import com.terapico.pim.EntityNotFoundException;
public class UserDomainNotFoundException extends EntityNotFoundException {
	private static final long serialVersionUID = 1L;
	public UserDomainNotFoundException(String string) {
		super(string);
	}

}

