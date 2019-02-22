package com.terapico.pim.editorpickproduct;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.terapico.pim.PimObjectPlainCustomSerializer;
public class EditorPickProductSerializer extends PimObjectPlainCustomSerializer<EditorPickProduct>{

	@Override
	public void serialize(EditorPickProduct editorPickProduct, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, editorPickProduct, provider);
		
	}
}


