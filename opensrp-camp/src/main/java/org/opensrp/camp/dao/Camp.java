package org.opensrp.camp.dao;


import java.util.Set;

import org.codehaus.jackson.annotate.JsonProperty;
import org.ektorp.docref.CascadeType;
import org.ektorp.docref.DocumentReferences;
import org.ektorp.docref.FetchType;
import org.ektorp.support.TypeDiscriminator;
import org.motechproject.model.MotechBaseDataObject;



@TypeDiscriminator("doc.type === 'Camp'")
public class Camp extends MotechBaseDataObject {
	
	/**
     * 
     */
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("session_name")
	private String session_name;
	
	@JsonProperty("session_location")
	private String session_location;
	
	@JsonProperty("total_hh")
	private String total_hh;
	
	@JsonProperty("total_population")
	private String total_population;
	
	@JsonProperty("total_adolescent")
	private String total_adolescent;
	
	@JsonProperty("total_women")
	private String total_women;
	
	@JsonProperty("total_child0")
	private String total_child0;
	
	@JsonProperty("total_child1")
	private String total_child1;
	
	@JsonProperty("total_child2")
	private String total_child2;
	@JsonProperty("health_assistant")
	private String health_assistant;	
	@JsonProperty("contact")
	private String contact;
	@JsonProperty("created_at")
	private String created_at;
	@JsonProperty("created_by")
	private String created_by;
	
		
	@DocumentReferences(fetch = FetchType.LAZY, descendingSortOrder = true, orderBy = "date", backReference = "session_id")
	private Set<CampDate> camp_dates;
	
    
    public Camp() {
	    // TODO Auto-generated constructor stub
    }


	public Camp(String session_name, String session_location, String total_hh, String total_population,
        String total_adolescent, String total_women, String total_child0, String total_child1, String total_child2,
        String health_assistant, String contact, String created_at, String created_by, Set<CampDate> camp_dates) {
	    super();
	    this.session_name = session_name;
	    this.session_location = session_location;
	    this.total_hh = total_hh;
	    this.total_population = total_population;
	    this.total_adolescent = total_adolescent;
	    this.total_women = total_women;
	    this.total_child0 = total_child0;
	    this.total_child1 = total_child1;
	    this.total_child2 = total_child2;
	    this.health_assistant = health_assistant;
	    this.contact = contact;
	    this.created_at = created_at;
	    this.created_by = created_by;
	    this.camp_dates = camp_dates;
    }


	
    public String getSession_name() {
    	return session_name;
    }


	
    public String getSession_location() {
    	return session_location;
    }


	
    public String getTotal_hh() {
    	return total_hh;
    }


	
    public String getTotal_population() {
    	return total_population;
    }


	
    public String getTotal_adolescent() {
    	return total_adolescent;
    }


	
    public String getTotal_women() {
    	return total_women;
    }


	
    public String getTotal_child0() {
    	return total_child0;
    }


	
    public String getTotal_child1() {
    	return total_child1;
    }


	
    public String getTotal_child2() {
    	return total_child2;
    }


	
    public String getHealth_assistant() {
    	return health_assistant;
    }


	
    public String getContact() {
    	return contact;
    }


	
    public String getCreated_at() {
    	return created_at;
    }


	
    public String getCreated_by() {
    	return created_by;
    }


	
    public Set<CampDate> getCamp_dates() {
    	return camp_dates;
    }


	
    public void setSession_name(String session_name) {
    	this.session_name = session_name;
    }


	
    public void setSession_location(String session_location) {
    	this.session_location = session_location;
    }


	
    public void setTotal_hh(String total_hh) {
    	this.total_hh = total_hh;
    }


	
    public void setTotal_population(String total_population) {
    	this.total_population = total_population;
    }


	
    public void setTotal_adolescent(String total_adolescent) {
    	this.total_adolescent = total_adolescent;
    }


	
    public void setTotal_women(String total_women) {
    	this.total_women = total_women;
    }


	
    public void setTotal_child0(String total_child0) {
    	this.total_child0 = total_child0;
    }


	
    public void setTotal_child1(String total_child1) {
    	this.total_child1 = total_child1;
    }


	
    public void setTotal_child2(String total_child2) {
    	this.total_child2 = total_child2;
    }


	
    public void setHealth_assistant(String health_assistant) {
    	this.health_assistant = health_assistant;
    }


	
    public void setContact(String contact) {
    	this.contact = contact;
    }


	
    public void setCreated_at(String created_at) {
    	this.created_at = created_at;
    }


	
    public void setCreated_by(String created_by) {
    	this.created_by = created_by;
    }


	
    public void setCamp_dates(Set<CampDate> camp_dates) {
    	this.camp_dates = camp_dates;
    }


	@Override
    public String toString() {
	    return "Camp [session_name=" + session_name + ", session_location=" + session_location + ", total_hh=" + total_hh
	            + ", total_population=" + total_population + ", total_adolescent=" + total_adolescent + ", total_women="
	            + total_women + ", total_child0=" + total_child0 + ", total_child1=" + total_child1 + ", total_child2="
	            + total_child2 + ", health_assistant=" + health_assistant + ", contact=" + contact + ", created_at="
	            + created_at + ", created_by=" + created_by + ", camp_dates=" + camp_dates + "]";
    }


	@Override
    public int hashCode() {
	    final int prime = 31;
	    int result = 1;
	    result = prime * result + ((camp_dates == null) ? 0 : camp_dates.hashCode());
	    result = prime * result + ((contact == null) ? 0 : contact.hashCode());
	    result = prime * result + ((created_at == null) ? 0 : created_at.hashCode());
	    result = prime * result + ((created_by == null) ? 0 : created_by.hashCode());
	    result = prime * result + ((health_assistant == null) ? 0 : health_assistant.hashCode());
	    result = prime * result + ((session_location == null) ? 0 : session_location.hashCode());
	    result = prime * result + ((session_name == null) ? 0 : session_name.hashCode());
	    result = prime * result + ((total_adolescent == null) ? 0 : total_adolescent.hashCode());
	    result = prime * result + ((total_child0 == null) ? 0 : total_child0.hashCode());
	    result = prime * result + ((total_child1 == null) ? 0 : total_child1.hashCode());
	    result = prime * result + ((total_child2 == null) ? 0 : total_child2.hashCode());
	    result = prime * result + ((total_hh == null) ? 0 : total_hh.hashCode());
	    result = prime * result + ((total_population == null) ? 0 : total_population.hashCode());
	    result = prime * result + ((total_women == null) ? 0 : total_women.hashCode());
	    return result;
    }


	@Override
    public boolean equals(Object obj) {
	    if (this == obj)
		    return true;
	    if (obj == null)
		    return false;
	    if (getClass() != obj.getClass())
		    return false;
	    Camp other = (Camp) obj;
	    if (camp_dates == null) {
		    if (other.camp_dates != null)
			    return false;
	    } else if (!camp_dates.equals(other.camp_dates))
		    return false;
	    if (contact == null) {
		    if (other.contact != null)
			    return false;
	    } else if (!contact.equals(other.contact))
		    return false;
	    if (created_at == null) {
		    if (other.created_at != null)
			    return false;
	    } else if (!created_at.equals(other.created_at))
		    return false;
	    if (created_by == null) {
		    if (other.created_by != null)
			    return false;
	    } else if (!created_by.equals(other.created_by))
		    return false;
	    if (health_assistant == null) {
		    if (other.health_assistant != null)
			    return false;
	    } else if (!health_assistant.equals(other.health_assistant))
		    return false;
	    if (session_location == null) {
		    if (other.session_location != null)
			    return false;
	    } else if (!session_location.equals(other.session_location))
		    return false;
	    if (session_name == null) {
		    if (other.session_name != null)
			    return false;
	    } else if (!session_name.equals(other.session_name))
		    return false;
	    if (total_adolescent == null) {
		    if (other.total_adolescent != null)
			    return false;
	    } else if (!total_adolescent.equals(other.total_adolescent))
		    return false;
	    if (total_child0 == null) {
		    if (other.total_child0 != null)
			    return false;
	    } else if (!total_child0.equals(other.total_child0))
		    return false;
	    if (total_child1 == null) {
		    if (other.total_child1 != null)
			    return false;
	    } else if (!total_child1.equals(other.total_child1))
		    return false;
	    if (total_child2 == null) {
		    if (other.total_child2 != null)
			    return false;
	    } else if (!total_child2.equals(other.total_child2))
		    return false;
	    if (total_hh == null) {
		    if (other.total_hh != null)
			    return false;
	    } else if (!total_hh.equals(other.total_hh))
		    return false;
	    if (total_population == null) {
		    if (other.total_population != null)
			    return false;
	    } else if (!total_population.equals(other.total_population))
		    return false;
	    if (total_women == null) {
		    if (other.total_women != null)
			    return false;
	    } else if (!total_women.equals(other.total_women))
		    return false;
	    return true;
    }
    
	
}
