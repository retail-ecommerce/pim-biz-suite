package com.terapico.pim.pricefilter;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.terapico.pim.PimObjectPlainCustomSerializer;
public class PriceFilterSerializer extends PimObjectPlainCustomSerializer<PriceFilter>{

	@Override
	public void serialize(PriceFilter priceFilter, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, priceFilter, provider);
		
	}
}


