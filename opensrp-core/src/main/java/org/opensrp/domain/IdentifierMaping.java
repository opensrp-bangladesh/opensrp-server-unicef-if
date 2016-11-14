package org.opensrp.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.codehaus.jackson.annotate.JsonProperty;
import org.ektorp.support.TypeDiscriminator;
import org.motechproject.model.MotechBaseDataObject;


@TypeDiscriminator("doc.type === 'IdentifierMaping'")
public class IdentifierMaping extends MotechBaseDataObject {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@JsonProperty
	private String genId;	
	@JsonProperty
	private String entityId;	
	public IdentifierMaping(){
		
	}
	public IdentifierMaping(String genId,String entityId){
		this.genId = genId;
		this.entityId = entityId;
	}
	

	public String getGenId() {
		return genId;
	}
	public void setGenId(String genId) {
		this.genId = genId;
	}
	
	public String getEntityId() {
		return entityId;
	}
	public void setEntityId(String entityId) {
		this.entityId = entityId;
	}
	@Override
	public boolean equals(Object o) {
		return EqualsBuilder.reflectionEquals(this, o, "id", "revision");
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this, "id", "revision");
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
