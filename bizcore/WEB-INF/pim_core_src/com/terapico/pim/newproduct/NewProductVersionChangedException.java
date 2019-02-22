
package com.terapico.pim.newproduct;
import com.terapico.pim.EntityNotFoundException;

public class NewProductVersionChangedException extends NewProductManagerException {
	private static final long serialVersionUID = 1L;
	public NewProductVersionChangedException(String string) {
		super(string);
	}


}


