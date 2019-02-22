package com.terapico.pim.newproduct;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.terapico.pim.PimObjectPlainCustomSerializer;
public class NewProductSerializer extends PimObjectPlainCustomSerializer<NewProduct>{

	@Override
	public void serialize(NewProduct newProduct, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, newProduct, provider);
		
	}
}


