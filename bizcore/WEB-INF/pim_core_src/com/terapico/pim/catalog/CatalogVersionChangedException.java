
package com.terapico.pim.catalog;
import com.terapico.pim.EntityNotFoundException;

public class CatalogVersionChangedException extends CatalogManagerException {
	private static final long serialVersionUID = 1L;
	public CatalogVersionChangedException(String string) {
		super(string);
	}


}


