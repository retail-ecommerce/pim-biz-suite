
package com.terapico.pim.newproduct;
import com.terapico.pim.EntityNotFoundException;
public class NewProductNotFoundException extends EntityNotFoundException {
	private static final long serialVersionUID = 1L;
	public NewProductNotFoundException(String string) {
		super(string);
	}

}

