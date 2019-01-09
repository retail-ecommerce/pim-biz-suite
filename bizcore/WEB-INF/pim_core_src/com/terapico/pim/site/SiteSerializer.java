package com.terapico.pim.site;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.terapico.pim.PimObjectPlainCustomSerializer;
public class SiteSerializer extends PimObjectPlainCustomSerializer<Site>{

	@Override
	public void serialize(Site site, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, site, provider);
		
	}
}


