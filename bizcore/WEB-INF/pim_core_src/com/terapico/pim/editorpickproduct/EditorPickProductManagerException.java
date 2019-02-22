
package com.terapico.pim.editorpickproduct;
//import com.terapico.pim.EntityNotFoundException;
import com.terapico.pim.PimException;
import com.terapico.pim.Message;
import java.util.List;

public class EditorPickProductManagerException extends PimException {
	private static final long serialVersionUID = 1L;
	public EditorPickProductManagerException(String string) {
		super(string);
	}
	public EditorPickProductManagerException(Message message) {
		super(message);
	}
	public EditorPickProductManagerException(List<Message> messageList) {
		super(messageList);
	}

}


