
package com.terapico.pim.levelncategory;
//import com.terapico.pim.EntityNotFoundException;
import com.terapico.pim.PimException;
import com.terapico.pim.Message;
import java.util.List;

public class LevelNCategoryManagerException extends PimException {
	private static final long serialVersionUID = 1L;
	public LevelNCategoryManagerException(String string) {
		super(string);
	}
	public LevelNCategoryManagerException(Message message) {
		super(message);
	}
	public LevelNCategoryManagerException(List<Message> messageList) {
		super(messageList);
	}

}


