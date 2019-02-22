
package com.terapico.pim.pricefilter;
//import com.terapico.pim.EntityNotFoundException;
import com.terapico.pim.PimException;
import com.terapico.pim.Message;
import java.util.List;

public class PriceFilterManagerException extends PimException {
	private static final long serialVersionUID = 1L;
	public PriceFilterManagerException(String string) {
		super(string);
	}
	public PriceFilterManagerException(Message message) {
		super(message);
	}
	public PriceFilterManagerException(List<Message> messageList) {
		super(messageList);
	}

}


