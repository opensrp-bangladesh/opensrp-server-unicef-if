package org.opensrp.dashboard.dto;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.codehaus.jackson.annotate.JsonProperty;

public class UserDTO {
	
	@JsonProperty
	private String name;
	
	@JsonProperty
	private String id;
	
	@JsonProperty
	private String status;
	
	@JsonProperty
	private String given_name;
	
	@JsonProperty
	private String middle_name;
	
	@JsonProperty
	private String family_name;
	
	@JsonProperty
	private String contact_number;
	
	@JsonProperty
	private String personal_address;
	
	@JsonProperty
	private String email;
	
	@JsonProperty
	private String password;
	
	@JsonProperty
	private String user_name;
	
	@JsonProperty
	private String gender;
	
	@JsonProperty
	private SimplifiedUser parent;
	
	@JsonProperty
	private List<SimplifiedUser> children;
	
	@JsonProperty
	private List<SimplifiedRole> roles;
	
	@JsonProperty
	private List<SimplifiedLocation> location;
	
	@JsonProperty
	private Map<String, String> meta;
	
	@JsonProperty
	private String created_at;
	
	@JsonProperty
	private String updated_at;
	
	@JsonProperty
	private String created_by;
	
	@JsonProperty
	private String updated_by;
	
	public UserDTO(String name, String id, String status) {
		this.name = name;
		this.id = id;
		this.status = status;
	}
	
	public UserDTO() {
		
	}
	
	public UserDTO withLocation(List<SimplifiedLocation> locations) {
		this.location = locations;
		return this;
	}
	
	public UserDTO withName(String roleName) {
		this.name = roleName;
		return this;
	}
	
	public UserDTO withRoleId(String roleId) {
		this.id = roleId;
		return this;
	}
	
	public UserDTO withStatus(String status) {
		this.status = status;
		return this;
	}
	
	public UserDTO withUserName(String userName){
		this.user_name = userName;
		return this;
	}
	
	public UserDTO withGivenName(String givenName){
		this.given_name = givenName;
		return this;
	}
	
	public UserDTO withMiddleName(String middleName){
		this.middle_name = middleName;
		return this;
	}
	
	public UserDTO withFamilyName(String familyName){
		this.family_name = familyName;
		return this;
	}
	
	public UserDTO withContactNumber(String contactNumber){
		this.contact_number = contactNumber;
		return this;
	}
		
	public UserDTO withEmail(String email){
		this.email = email;
		return this;
	}
	
	public UserDTO withPersonalAddress(String address){
		this.personal_address = address;
		return this;
	}
	
	public UserDTO withGender(String gender){
		this.gender = gender;
		return this;
	}
	
	public UserDTO withParent(SimplifiedUser parent){
		this.parent = parent;
		return this;
	}
	
	public UserDTO withChildren(List<SimplifiedUser> children){
		this.children = children;
		return this;
	}
	
	public UserDTO withRoles(List<SimplifiedRole> roles){
		this.roles = roles;
		return this;
	}
	
	public UserDTO withId(String userId){
		this.id = userId;
		return this;
	}
	
	public String getName() {
		return name;
	}
	
	public String getId() {
		return id;
	}
	
	public String getStatus() {
		return status;
	}
	
	public String getGivenName() {
		return given_name;
	}
	
	public String getMiddleName() {
		return middle_name;
	}
	
	public String getFamilyName() {
		return family_name;
	}
	
	public String getContactNumber() {
		return contact_number;
	}
	
	public String getPersonalAddress() {
		return personal_address;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getGender() {
		return gender;
	}
	
	public SimplifiedUser getParent() {
		return parent;
	}
	
	public List<SimplifiedUser> getChildren() {
		return children;
	}
	
	public List<SimplifiedRole> getRoles() {
		return roles;
	}
	
	public String getUserName() {
		return user_name;
	}
	
	public List<SimplifiedLocation> getLocation() {
		return location;
	}
	
	@Override
	public boolean equals(Object o) {
		return EqualsBuilder.reflectionEquals(this, o);
	}
	
	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
}
