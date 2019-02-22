package com.terapico.pim.brandfilter;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.terapico.pim.PimObjectPlainCustomSerializer;
public class BrandFilterSerializer extends PimObjectPlainCustomSerializer<BrandFilter>{

	@Override
	public void serialize(BrandFilter brandFilter, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, brandFilter, provider);
		
	}
}


