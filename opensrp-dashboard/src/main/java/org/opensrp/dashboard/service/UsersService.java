package org.opensrp.dashboard.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import org.codehaus.jackson.annotate.JsonProperty;
import org.opensrp.dashboard.dto.DashboardLocationDTO;
import org.opensrp.dashboard.dto.RoleDTO;
import org.opensrp.dashboard.dto.UserDTO;
import org.opensrp.dashboard.dto.SimplifiedLocation;
import org.opensrp.dashboard.dto.SimplifiedRole;
import org.opensrp.dashboard.dto.SimplifiedUser;
import org.opensrp.dashboard.domain.DashboardLocation;
import org.opensrp.dashboard.domain.LocationTag;
import org.opensrp.dashboard.domain.User;
import org.opensrp.dashboard.repository.AllDashboardLocations;
import org.opensrp.dashboard.repository.AllLocationTags;
import org.opensrp.dashboard.repository.AllUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

@Service
public class UsersService {
	
	private static Logger logger = LoggerFactory.getLogger(UsersService.class);
	
	private AllUser allUsers;
	private AllDashboardLocations allDashboardLocations;
	private AllLocationTags allLocationTags;
	
	private RoleService roleService;
	
	@Autowired
	public UsersService(AllUser allUsers, RoleService roleService, AllDashboardLocations allDashboardLocations, AllLocationTags allLocationTags) {
		this.allUsers = allUsers;
		this.roleService = roleService;
		this.allDashboardLocations = allDashboardLocations;
		this.allLocationTags = allLocationTags;
	}	
	
	public List<String> getPrivilegesOfAUser(String userName) {
		User userByUserName = allUsers.findUserByUserName(userName);
		if (userByUserName == null || userByUserName.getRoles() == null || userByUserName.getRoles().size() < 1)
			return null;
		else {
			Set<String> privileges = new HashSet<String>();
			for (int i = 0; i < userByUserName.getRoles().size(); i++) {
				logger.info("entered for role - " + userByUserName.getRoles().get(i).getName());
				List<String> roleSpecificPrivileges = roleService.getPrivilegesOfASpecificRole(userByUserName.getRoles()
				        .get(i).getId());
				if (roleSpecificPrivileges != null) {
					for (int j = 0; j < roleSpecificPrivileges.size(); j++) {
						privileges.add(roleSpecificPrivileges.get(j));
					}
				}
			}
			logger.info("privilege list constructed");
			return new ArrayList<String>(privileges);
		}
	}
	
	public String addUser(UserDTO userDTO) {
		logger.info("inside UserService.addUser");
		User userByUserName = allUsers.findUserByUserName(userDTO.getUserName());
		if (userByUserName == null) {
			logger.info("No Such User with given userName Found");
			try {
				User user = new User();
				//role.withUserName(roleDTO.getUserName());
				user.withStatus(userDTO.getStatus());
				user.withGivenName(userDTO.getGivenName());
				user.withFamilyName(userDTO.getFamilyName());
				user.withMiddleName(userDTO.getMiddleName());
				user.withContactNumber(userDTO.getContactNumber());
				user.withPersonalAddress(userDTO.getPersonalAddress());
				user.withEmail(userDTO.getEmail());
				StandardPasswordEncoder encoder = new StandardPasswordEncoder();
				//String encodedPassword = encoder.encode(userDTO.getPassword()); //new String(Base64.encode(userDTO.getPassword().getBytes()));
				user.withPassword(encoder.encode(userDTO.getPassword()));
				user.withUserName(userDTO.getUserName());
				user.withGender(userDTO.getGender());
				//parent, children, roles, locations
				SimplifiedUser parentDTO = userDTO.getParent();
				List<SimplifiedUser> childrenDTOs = userDTO.getChildren();
				List<SimplifiedRole> roleDTOs = userDTO.getRoles();
				//	
				SimplifiedUser parent = null;
				if (parentDTO != null) {
					parent = parentDTO;
					user.withParent(parent);
					logger.info("parent added in user.");
				}
				List<SimplifiedUser> children = new ArrayList<SimplifiedUser>();
				if (childrenDTOs != null ) {
					for (int i = 0; i < childrenDTOs.size(); i++) {
						children.add(childrenDTOs.get(i));
					}
					user.withChildren(children);
					logger.info("children added in user.");
				}
				List<SimplifiedRole> roles = new ArrayList<SimplifiedRole>();
				if (roleDTOs != null) {
					for (int i = 0; i < roleDTOs.size(); i++) {
						roles.add(roleDTOs.get(i));
					}
					user.withRoles(roles);
					logger.info("roles added in user.");
				}
				allUsers.add(user);
				return "1";
			}
			catch (Exception e) {
				return "0";
			}
		} else {
			logger.info("User with given userName already exists.");
			return "2";
		}
	}
	
	public String editUser(UserDTO userDTO) {
		//Role roles = allRoles.get(roleDTO.getRoleId() );  // null checking isn't done here, should be done rigorously on client-side
		User userByUserName = allUsers.findUserByUserName(userDTO.getUserName() == null ? "" : userDTO.getUserName());
		if (userByUserName != null) {
			try {
				
				if (userDTO.getStatus() != null) {
					userByUserName.withStatus(userDTO.getStatus());
				}
				if (userDTO.getGivenName() != null) {
					userByUserName.withGivenName(userDTO.getGivenName());
				}
				if (userDTO.getFamilyName() != null) {
					userByUserName.withFamilyName(userDTO.getFamilyName());
				}
				if (userDTO.getMiddleName() != null) {
					userByUserName.withMiddleName(userDTO.getMiddleName());
				}
				if (userDTO.getContactNumber() != null) {
					userByUserName.withContactNumber(userDTO.getContactNumber());
				}
				if (userDTO.getPersonalAddress() != null) {
					userByUserName.withPersonalAddress(userDTO.getPersonalAddress());
				}
				if (userDTO.getEmail() != null) {
					userByUserName.withEmail(userDTO.getEmail());
				}
				if (userDTO.getPassword() != null) {
					StandardPasswordEncoder encoder = new StandardPasswordEncoder();
					//String encodedPassword = new String(Base64.encode(userDTO.getPassword().getBytes()));
					userByUserName.withPassword(encoder.encode(userDTO.getPassword()));
				}
				if (userDTO.getGender() != null) {
					userByUserName.withGender(userDTO.getGender());
				}
				if (userDTO.getParent() != null) {
					userByUserName.withParent(userDTO.getParent());					
				}
				if (userDTO.getChildren() != null) {
					List<SimplifiedUser> childrenDTOs = userDTO.getChildren();
					List<SimplifiedUser> children = null;
					if (childrenDTOs != null ) {
						children = new ArrayList<SimplifiedUser>();
						for (int i = 0; i < childrenDTOs.size(); i++) {
							children.add(childrenDTOs.get(i));
						}
						userByUserName.withChildren(children);
						logger.info("children updated in user.");
					}
				}
				if (userDTO.getRoles() != null) {
					List<SimplifiedRole> roleDTOs = userDTO.getRoles();
					List<SimplifiedRole> roles = new ArrayList<SimplifiedRole>();
					if (roleDTOs != null ) {
						for (int i = 0; i < roleDTOs.size(); i++) {
							roles.add(roleDTOs.get(i));
						}
						userByUserName.withRoles(roles);
						logger.info("roles updated in user.");
					}
				}
				allUsers.update(userByUserName);
				
				return "1";
			}
			catch (Exception e) {
				return "0";
			}
		} else {
			return "2";
		}
	}
	

	public List<SimplifiedUser> getLeafUsersByLocation(String locationId){
		//System.out.println("request found for id- " + locationId);
		
		List<SimplifiedUser> leafUsers = new ArrayList<SimplifiedUser>();
		List<DashboardLocation> childrenLocations = allDashboardLocations.findChildrenLocations(locationId);
		DashboardLocation givenLocation = allDashboardLocations.get(locationId);		
		Queue<DashboardLocation> locationQueue = new LinkedList<DashboardLocation>();
		locationQueue.add(givenLocation);
		List<User> tempLeafUsers = null;		
		Set<String> leafUserIds = new HashSet<String>();
		
		//System.out.println("queue size before if- " + locationQueue.size() + " -- number of children " + childrenLocations.size());
		
		if(ifAllLocationsAreOfSameTag(childrenLocations) || headOfQueueIsUnit(locationQueue)){
			locationQueue = addLocationsInQueue(locationQueue, childrenLocations);
			//locationQueue.remove();
			while(!headOfQueueIsUnit(locationQueue)){	
				//System.out.println("oka");
				DashboardLocation tempD = locationQueue.remove();
				if(tempD.getId().equals(locationId)){
					tempD = locationQueue.remove();
				}
				childrenLocations = allDashboardLocations.findChildrenLocations(tempD.getId());
				//System.out.println("size of lcoation queue- " + locationQueue.size() + " -- " + tempD.getName()	+ " --found children- ");
				if(ifAllLocationsAreOfSameTag(childrenLocations)){
					locationQueue = addLocationsInQueue(locationQueue, childrenLocations);
				}
				else{
					System.out.println("return null for mismatch in locationTag." );
					return null;
				}
			}
			//System.out.println("number of units found- " + locationQueue.size());
			if(headOfQueueIsUnit(locationQueue)){
				while(!locationQueue.isEmpty()){
					tempLeafUsers = allUsers.findUsersByLocation(locationQueue.remove().getId());
					if(tempLeafUsers != null){
						for(User user: tempLeafUsers){
							if(!leafUserIds.contains(user.getUserName())){
								SimplifiedUser u = new SimplifiedUser();
								u.withUsername(user.getUserName());
								u.withId(user.getId());
								leafUsers.add(u);
								leafUserIds.add(user.getUserName());
							}							
						}
					}					
				}				
			}
		}
		else{
			return null;
		}
		
		return leafUsers;
	}
	
	public List<SimplifiedUser> getLeafUsersByUser(String userName){
		User givenUser = allUsers.findUserByUserName(userName);
		List<SimplifiedUser> leafUsers = new ArrayList<SimplifiedUser>();
		List<SimplifiedUser> tempLeafUsers = null;
		if(givenUser != null && givenUser.getLocation() != null && givenUser.getLocation().size() > 0){
			for(int i =0; i < givenUser.getLocation().size() ; i++){
				tempLeafUsers = getLeafUsersByLocation(givenUser.getLocation().get(i).getId());
				if(tempLeafUsers != null){
					for(int j = 0; j < tempLeafUsers.size(); j++){
						leafUsers.add(tempLeafUsers.get(j));
					}
				}
			}
		}
		else{
			return null;
		}
		return leafUsers;
	}
	
	public boolean headOfQueueIsUnit(Queue<DashboardLocation> queue){
		LocationTag tag = allLocationTags.get(queue.peek().getTagId() == null ? "" : queue.peek().getTagId()) ;
		if(tag.getName().equals("Unit")){
			return true;
		}
		return false;
	}
	
	public Queue<DashboardLocation> addLocationsInQueue(Queue<DashboardLocation> queue, List<DashboardLocation> locations){
		if(locations == null)
			return queue;
					
		for(DashboardLocation location : locations){
			queue.add(location);
		}
		return queue;
	}
	
	public boolean ifAllLocationsAreOfSameTag(List<DashboardLocation> locations){
		if(locations == null)
			return true;
		String tagId = locations.get(0).getTagId();
		for(int i = 1; i < locations.size(); i++){
			if(!tagId.equals(locations.get(i).getTagId())){
				return false;
			}
		}
		return true;
	}
	
	public List<SimplifiedUser> getAllUsers(){
		List<SimplifiedUser> allUsersDTO = new ArrayList<SimplifiedUser>();
		List<User> allUser = allUsers.getAll();
		if(allUser != null){
			for(int i = 0 ; i < allUser.size(); i++){
				SimplifiedUser userDTO = new SimplifiedUser();
				userDTO.withUsername(allUser.get(i).getUserName()); 
				userDTO.withId(allUser.get(i).getId());
				allUsersDTO.add(userDTO);
			}
		}
		return allUsersDTO;
	}
	
	public List<UserDTO> getAllUsersWithRoles(){
		List<UserDTO> allUsersDTO = new ArrayList<UserDTO>();
		List<User> allUser = allUsers.getAll();
		if(allUser != null){
			for(int i = 0 ; i < allUser.size(); i++){
				UserDTO userDTO = new UserDTO();
				userDTO.withUserName(allUser.get(i).getUserName()); 
				userDTO.withId(allUser.get(i).getId());
				userDTO.withRoles(allUser.get(i).getRoles());
				userDTO.withStatus(allUser.get(i).getStatus());
				allUsersDTO.add(userDTO);
			}
		}
		return allUsersDTO;
	}
	
	public List<SimplifiedUser> getUsersByRole(String roleId){
		List<SimplifiedUser> allUsersDTO = new ArrayList<SimplifiedUser>();
		List<User> allUser = allUsers.findUsersByRole(roleId);
		if(allUser != null){
			for(int i = 0 ; i < allUser.size(); i++){
				SimplifiedUser userDTO = new SimplifiedUser();
				userDTO.withUsername(allUser.get(i).getUserName()); 
				userDTO.withId(allUser.get(i).getId());
				allUsersDTO.add(userDTO);
			}
		}
		return allUsersDTO;
	}
	
	public UserDTO getUserByName(String userName) {
		User userByUserName = allUsers.findUserByUserName(userName);
		UserDTO userDTO =  new UserDTO();
		
		if (userByUserName == null) {			
			return null;
		} else {
			userDTO.withUserName(userByUserName.getUserName())
					.withGivenName(userByUserName.getGivenName() == null ? "" : userByUserName.getGivenName())
					.withFamilyName(userByUserName.getFamilyName() )
					.withMiddleName(userByUserName.getMiddleName())
					.withId(userByUserName.getId())
					.withStatus(userByUserName.getStatus())
					.withGender(userByUserName.getGender())
					.withEmail(userByUserName.getEmail())
					.withPersonalAddress(userByUserName.getPersonalAddress())
					.withContactNumber(userByUserName.getContactNumber())
					.withParent(userByUserName.getParent())
					.withChildren(userByUserName.getChildren())
					.withRoles(userByUserName.getRoles())
					.withLocation(userByUserName.getLocation());
					
			return userDTO;
		}
	}
	public List<SimplifiedRole> getRoleByUserName(String userName) {
		User userByUserName = allUsers.findUserByUserName(userName);
		UserDTO userDTO =  new UserDTO();		
		if (userByUserName == null) {			
			return null;
		} else {
			List<SimplifiedRole> roles = userByUserName.getRoles();
			
			for (SimplifiedRole simplifiedRole : roles) {
	            
            }
			return userByUserName.getRoles();					
			
		}
	}
	
	public String ifUserExists(String userName) {
		User userByUserName = allUsers.findUserByUserName(userName);
		logger.info("service returned -" + userName);
		if (userByUserName == null) {
			return "1";
		} else {
			return "2";
		}
	}
	
	public String assignLocation(UserDTO userDTO) {
		logger.info("inside UserService.assignLocation");
		User userByUserName = allUsers.findUserByUserName(userDTO.getUserName() == null ? "" : userDTO.getUserName());
		if (userByUserName != null) {
			try {			
				
				if (userDTO.getLocation() != null) {
					
					List<SimplifiedLocation> locationDTOs = userDTO.getLocation();
					List<SimplifiedLocation> locations = new ArrayList<SimplifiedLocation>();
					if (locationDTOs != null && locationDTOs.size() > 0) {
						for (int i = 0; i < locationDTOs.size(); i++) {
							locations.add(locationDTOs.get(i));
							//logger.info("location name - " + tempLocation.getName() + " - " + tempLocation.getId());
						}													
					}
					userByUserName.withLocation(locations);					
					logger.info("loactions updated for user - " + userByUserName.getUserName());
					
				}
				allUsers.update(userByUserName);
				
				return "1";
			}
			catch (Exception e) {
				return "0";
			}
		} else {
			return "2";
		}
	}
}
