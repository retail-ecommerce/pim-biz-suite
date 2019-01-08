
package com.terapico.pim.sku;
import com.terapico.pim.EntityNotFoundException;
public class SkuNotFoundException extends EntityNotFoundException {
	private static final long serialVersionUID = 1L;
	public SkuNotFoundException(String string) {
		super(string);
	}

}

