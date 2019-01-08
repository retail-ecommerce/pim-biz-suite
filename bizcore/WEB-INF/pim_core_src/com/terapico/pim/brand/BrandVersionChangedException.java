
package com.terapico.pim.brand;
import com.terapico.pim.EntityNotFoundException;

public class BrandVersionChangedException extends BrandManagerException {
	private static final long serialVersionUID = 1L;
	public BrandVersionChangedException(String string) {
		super(string);
	}


}


