
package com.terapico.pim.sku;
import com.terapico.pim.EntityNotFoundException;

public class SkuVersionChangedException extends SkuManagerException {
	private static final long serialVersionUID = 1L;
	public SkuVersionChangedException(String string) {
		super(string);
	}


}


