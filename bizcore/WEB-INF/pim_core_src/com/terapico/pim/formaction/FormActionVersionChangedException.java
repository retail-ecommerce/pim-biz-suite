
package com.terapico.pim.formaction;
import com.terapico.pim.EntityNotFoundException;

public class FormActionVersionChangedException extends FormActionManagerException {
	private static final long serialVersionUID = 1L;
	public FormActionVersionChangedException(String string) {
		super(string);
	}


}


