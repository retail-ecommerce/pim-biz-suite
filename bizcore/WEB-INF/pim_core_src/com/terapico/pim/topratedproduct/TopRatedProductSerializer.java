package com.terapico.pim.topratedproduct;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.terapico.pim.PimObjectPlainCustomSerializer;
public class TopRatedProductSerializer extends PimObjectPlainCustomSerializer<TopRatedProduct>{

	@Override
	public void serialize(TopRatedProduct topRatedProduct, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, topRatedProduct, provider);
		
	}
}


