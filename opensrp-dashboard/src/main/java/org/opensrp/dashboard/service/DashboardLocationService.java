package org.opensrp.dashboard.service;

import java.util.ArrayList;
import java.util.List;

import org.ektorp.DocumentNotFoundException;
import org.opensrp.dashboard.dto.DashboardLocationDTO;
import org.opensrp.dashboard.dto.DashboardLocationInfoDTO;
import org.opensrp.dashboard.dto.DashboardLocationInfoDTONew;
import org.opensrp.dashboard.dto.PrivilegeDTO;
import org.opensrp.dashboard.dto.SimplifiedUser;
import org.opensrp.dashboard.dto.UnitDashboardLocationInfo;
import org.opensrp.dashboard.domain.DashboardLocation;
import org.opensrp.dashboard.domain.LocationTag;
import org.opensrp.dashboard.domain.Privilege;
import org.opensrp.dashboard.repository.AllDashboardLocations;
import org.opensrp.dashboard.repository.AllLocationTags;
import org.opensrp.dashboard.repository.AllPrivileges;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DashboardLocationService {
	
	private static Logger logger = LoggerFactory.getLogger(DashboardLocationService.class);
	
	private AllDashboardLocations allDashboardLocations;
	private AllLocationTags allLocationTags;
	
	@Autowired
	public DashboardLocationService(AllDashboardLocations allDashboardLocations, AllLocationTags allLocationTags) {
		this.allDashboardLocations = allDashboardLocations;
		this.allLocationTags = allLocationTags;
	}
	
	public String addDashboardLocation(DashboardLocationDTO locationDTO){
		if(locationDTO.getName() == null || locationDTO.getParentId() == null 
				|| locationDTO.getParentName() == null || locationDTO.getTagId() == null){
			return "2";
		}
		DashboardLocation parentDashboardLocation = null;
		LocationTag locationTagOfNewLocation = null;
		LocationTag locationTagForUnit = null;
		try{
			parentDashboardLocation = allDashboardLocations.get(locationDTO.getParentId());
			locationTagOfNewLocation = allLocationTags.get(locationDTO.getTagId());
		}catch(DocumentNotFoundException e){
			return "3";  // "3" stands for parentNotFound
		}	
		
		if(locationTagOfNewLocation != null && parentDashboardLocation != null && 
				locationTagOfNewLocation.getParentTagId().equals(parentDashboardLocation.getTagId())){
			
			//for every ward 8 units will be created by default 
			if(locationTagOfNewLocation.getName().equals("Ward")){
				String[] unitNames = {"Unit One", "Unit Two", "Unit Three", "Unit Four", "Unit Five", "Unit Six", "Unit Seven", "Unit Eight"};
				try{
					locationTagForUnit = allLocationTags.findLocationTagByName("Unit");
				}catch(DocumentNotFoundException e){
					return "3";  // "3" stands for parentNotFound
				}
				
				if(locationTagForUnit != null){
					DashboardLocation newDashboardLocation = new DashboardLocation();
					newDashboardLocation.withName(locationDTO.getName());
					newDashboardLocation.withParentName(locationDTO.getParentName());
					newDashboardLocation.withParentId(locationDTO.getParentId());
					newDashboardLocation.withTagId(locationDTO.getTagId());
					allDashboardLocations.add(newDashboardLocation);
					
					for(int i = 0; i < unitNames.length; i++){
						DashboardLocation newUnit = new DashboardLocation();
						newUnit.withName(unitNames[i]);
						newUnit.withParentName(locationDTO.getName());
						newUnit.withParentId(newDashboardLocation.getId());
						newUnit.withTagId(locationTagForUnit.getId());
						allDashboardLocations.add(newUnit);
					}
				}
				else{
					return "2";
				}
				
			}
			else{
				DashboardLocation newDashboardLocation = new DashboardLocation();
				newDashboardLocation.withName(locationDTO.getName());
				newDashboardLocation.withParentName(locationDTO.getParentName());
				newDashboardLocation.withParentId(locationDTO.getParentId());
				newDashboardLocation.withTagId(locationDTO.getTagId());
				allDashboardLocations.add(newDashboardLocation);
			}
			
			return "1";
		}
		else{
			return "2";
		}	
	}
	
	public String editDashboardLocation(DashboardLocationDTO locationDTO){
		if(locationDTO.getName() == null || locationDTO.getParentId() == null 
				|| locationDTO.getParentName() == null || locationDTO.getTagId() == null){
			return "2";
		}
		DashboardLocation dashboardLocationToEdit = null;
		DashboardLocation parentDashboardLocation = null;
		LocationTag locationTagOfEditLocation = null;
		try{
			dashboardLocationToEdit = allDashboardLocations.get(locationDTO.getId());
			parentDashboardLocation = allDashboardLocations.get(locationDTO.getParentId());
			locationTagOfEditLocation = allLocationTags.get(locationDTO.getTagId());
		}catch(DocumentNotFoundException e){
			return "3";
		}		
		if(dashboardLocationToEdit != null && parentDashboardLocation != null && locationTagOfEditLocation != null &&
				locationTagOfEditLocation.getParentTagId().equals(parentDashboardLocation.getTagId())){
			dashboardLocationToEdit.withName(locationDTO.getName());
			dashboardLocationToEdit.withParentName(locationDTO.getParentName());
			dashboardLocationToEdit.withParentId(locationDTO.getParentId());
			dashboardLocationToEdit.withTagId(locationDTO.getTagId());
			allDashboardLocations.update(dashboardLocationToEdit);
			return "1";
		}
		else{
			return "2";
		}		
	}
	
	public String deleteDashboardLocation(String locationId){
		DashboardLocation dashboardLocationToDelete = null;
		try{
			dashboardLocationToDelete = allDashboardLocations.get(locationId);
		}catch(DocumentNotFoundException e){
			return "3";
		}	
		if(dashboardLocationToDelete != null){
			allDashboardLocations.remove(dashboardLocationToDelete);
			return "1";
		}
		else{
			return "2";
		}	
	}
	
	public DashboardLocationDTO getDashboardLocation(String locationId){
		DashboardLocation dashboardLocation = null;
		try{
			dashboardLocation = allDashboardLocations.get(locationId);
		}catch(DocumentNotFoundException e){
			return null;
		}
		
		if(dashboardLocation != null){
			DashboardLocationDTO locationDTO = new DashboardLocationDTO();
			locationDTO.withId(dashboardLocation.getId());
			locationDTO.withName(dashboardLocation.getName());
			locationDTO.withParentId(dashboardLocation.getParentId());
			locationDTO.withParentname(dashboardLocation.getName());
			locationDTO.withTagId(dashboardLocation.getTagId());
			return locationDTO;
		}
		else{
			return null;
		}
	}
	
	public List<DashboardLocationDTO> getChildrenLocations(String parentDashboardLocationId){
		List<DashboardLocation> childrenLocations = allDashboardLocations.findChildrenLocations(parentDashboardLocationId);
		List<DashboardLocationDTO> childrenLocationDTOs = new ArrayList<DashboardLocationDTO>();
		
		if(childrenLocations != null){
			for(int i =0; i < childrenLocations.size(); i++){
				DashboardLocationDTO newDashboardLocationDTO = new DashboardLocationDTO();
				newDashboardLocationDTO.withId(childrenLocations.get(i).getId());
				newDashboardLocationDTO.withName(childrenLocations.get(i).getName());
				newDashboardLocationDTO.withTagId(childrenLocations.get(i).getTagId());
				childrenLocationDTOs.add(newDashboardLocationDTO);
			}			
		}
		
		return childrenLocationDTOs;
	}
	
	public List<DashboardLocationDTO> getDashboardLocationsByParentAndTag(String parentDashboardLocationId, String tagId){
		List<DashboardLocation> locationsByParentAndTag = allDashboardLocations.findLocationsByParentAndTag(parentDashboardLocationId, tagId);
		List<DashboardLocationDTO> locationDTOsByParentAndTag = new ArrayList<DashboardLocationDTO>();
		
		if(locationsByParentAndTag != null){
			for(int i =0; i < locationsByParentAndTag.size(); i++){
				DashboardLocationDTO newDashboardLocationDTO = new DashboardLocationDTO();
				newDashboardLocationDTO.withId(locationsByParentAndTag.get(i).getId());
				newDashboardLocationDTO.withName(locationsByParentAndTag.get(i).getName());
				newDashboardLocationDTO.withTagId(locationsByParentAndTag.get(i).getTagId());
				locationDTOsByParentAndTag.add(newDashboardLocationDTO);
			}			
		}
		
		return locationDTOsByParentAndTag;
	}
	
	public List<DashboardLocationDTO> getDashboardLocationsByTag(String tagId){
		List<DashboardLocation> locationsByTag = allDashboardLocations.findLocationsByTag(tagId);
		List<DashboardLocationDTO> locationDTOsByTag = new ArrayList<DashboardLocationDTO>();
		
		if(locationsByTag != null){
			for(int i =0; i < locationsByTag.size(); i++){
				DashboardLocationDTO newDashboardLocationDTO = new DashboardLocationDTO();
				newDashboardLocationDTO.withId(locationsByTag.get(i).getId());
				newDashboardLocationDTO.withName(locationsByTag.get(i).getName());
				newDashboardLocationDTO.withTagId(locationsByTag.get(i).getTagId());
				locationDTOsByTag.add(newDashboardLocationDTO);
			}			
		}
		
		return locationDTOsByTag;
	}
	
	public DashboardLocationDTO getDashboardLocationById(String locationId){
		DashboardLocation locationById = allDashboardLocations.get(locationId);
		DashboardLocationDTO locationByIdDTO = new DashboardLocationDTO();
		
		if(locationById != null){
			locationByIdDTO.withId(locationById.getId());
			locationByIdDTO.withName(locationById.getName());
			locationByIdDTO.withTagId(locationById.getTagId());
			locationByIdDTO.withParentname(locationById.getParentName());
			locationByIdDTO.withParentId(locationById.getParentId());
		}
		
		return locationByIdDTO;
	}
	
	public DashboardLocationInfoDTONew getDashboardLocationInfoNew(String locationId){
		DashboardLocationInfoDTONew info = new DashboardLocationInfoDTONew();
		DashboardLocation locationById = allDashboardLocations.get(locationId);
		DashboardLocationDTO parentLocation = null;
		
		if(locationById != null && locationById.getParentId() != null && locationById.getParentId().length() > 1 
				&& locationById.getTagId() != null){			
			String currentTag = allLocationTags.get(locationById.getTagId()).getName();
			info.setTagName(currentTag);
			
			while(!currentTag.equals("Country")){
				UnitDashboardLocationInfo unitLocation = new UnitDashboardLocationInfo();
				unitLocation.setTagName(currentTag);
				unitLocation.setCurrentSelection(convertLocationToDTO(locationById));
				List<DashboardLocationDTO> ownSiblings = null;
				try{
					ownSiblings = convertLocationToDTOList(allDashboardLocations.findChildrenLocations(locationById.getParentId())) ;
					parentLocation = convertLocationToDTO(allDashboardLocations.get(locationById.getParentId()));
				}catch(DocumentNotFoundException e){
					return null;
				}
				unitLocation.setOwnSiblings(ownSiblings);
				unitLocation.setParentSelection(parentLocation);
				info.setLocations(unitLocation);
				
				try{
					locationById = allDashboardLocations.get(locationById.getParentId());
				}catch(DocumentNotFoundException e){
					return null;
				}
				
				currentTag = allLocationTags.get(locationById.getTagId()).getName();				
			}		
		}
		else{
			return null;
		}
		
		return info;
	}	
	
	public DashboardLocationInfoDTO getDashboardLocationInfo(String locationId){
		DashboardLocation locationById = allDashboardLocations.get(locationId);
		DashboardLocationInfoDTO locationInfoDTO = new DashboardLocationInfoDTO();	
		
		if(locationById != null && locationById.getParentId() != null && locationById.getParentId().length() > 1 
				&& locationById.getTagId() != null){			
			String currentTag = allLocationTags.get(locationById.getTagId()).getName();
			locationInfoDTO.setTagName(currentTag);
			String currentParentId = null;
			
			List<DashboardLocationDTO> ownSiblings = convertLocationToDTOList(allDashboardLocations.findChildrenLocations(locationById.getParentId())) ;
			locationInfoDTO.setOwnSiblings(ownSiblings);
			
			if(currentTag.equals("Division")){
				currentParentId = locationById.getParentId();
				DashboardLocation currentParent = allDashboardLocations.get(currentParentId);
				DashboardLocationDTO currentParentDTO = null;
				
				if(currentParent != null){
					currentParentDTO = convertLocationToDTO(currentParent);
					
					locationInfoDTO = locationInfoDTO.setMember(currentTag, currentParentDTO, null);						
				}
			}
			else{
				while(!currentTag.equals("Division")){
					currentParentId = locationById.getParentId();
					DashboardLocation currentParent = allDashboardLocations.get(currentParentId);
					DashboardLocationDTO currentParentDTO = null;
					List<DashboardLocation> parentSiblings = null;
					List<DashboardLocationDTO> parentSiblingsDTOs = null;
					if(currentParent != null){
						currentParentDTO = convertLocationToDTO(currentParent);
						parentSiblings = allDashboardLocations.findChildrenLocations(currentParent.getParentId());
						parentSiblingsDTOs = convertLocationToDTOList(parentSiblings);
						
						locationInfoDTO = locationInfoDTO.setMember(currentTag, currentParentDTO, parentSiblingsDTOs);				
						
						currentTag = allLocationTags.get(currentParent.getTagId()).getName();
						locationById = currentParent;						
					}
					else{
						break;
					}
				}
			}
			
		}
		
		return locationInfoDTO;
	}
	
	public List<DashboardLocationDTO> getChildrenLocationsOfRoot(){
		DashboardLocation rootLocation = allDashboardLocations.findDashboardLocationByName("Bangladesh");
		List<DashboardLocation> childrenOfRoot = allDashboardLocations.findChildrenLocations(rootLocation.getId());
		List<DashboardLocationDTO> locationDTOs = new ArrayList<DashboardLocationDTO>();
		
		if(childrenOfRoot != null){
			for(int i =0; i < childrenOfRoot.size(); i++){
				DashboardLocationDTO newDashboardLocationDTO = new DashboardLocationDTO();
				newDashboardLocationDTO.withId(childrenOfRoot.get(i).getId());
				newDashboardLocationDTO.withName(childrenOfRoot.get(i).getName());
				newDashboardLocationDTO.withTagId(childrenOfRoot.get(i).getTagId());
				newDashboardLocationDTO.withParentId(childrenOfRoot.get(i).getParentId());
				newDashboardLocationDTO.withParentname(childrenOfRoot.get(i).getParentName());
				locationDTOs.add(newDashboardLocationDTO);
			}			
		}
		
		return locationDTOs;
	}
	
	public List<DashboardLocationDTO> getUpazillas(){
		List<LocationTag> tags = allLocationTags.getAll();
		String idForUpazillaTag = "";
		for(LocationTag tag :tags){
			if(tag.getName().equals("Upazilla")){
				idForUpazillaTag = tag.getId();
			}
		}
		
		List<DashboardLocation> upazillas = allDashboardLocations.findLocationsByTag(idForUpazillaTag);
		List<DashboardLocationDTO> upazillaDTOs = new ArrayList<DashboardLocationDTO>();
		
		if(upazillas != null){
			for(int i =0; i < upazillas.size(); i++){
				DashboardLocationDTO newDashboardLocationDTO = new DashboardLocationDTO();
				newDashboardLocationDTO.withId(upazillas.get(i).getId());
				newDashboardLocationDTO.withName(upazillas.get(i).getName());
				upazillaDTOs.add(newDashboardLocationDTO);
			}			
		}
		
		return upazillaDTOs;
	}
	public List<DashboardLocationDTO> getLocationByTagName(String tagName){
		List<LocationTag> tags = allLocationTags.getAll();
		String idForUpazillaTag = "";
		for(LocationTag tag :tags){
			if(tag.getName().equals(tagName)){
				idForUpazillaTag = tag.getId();
			}
		}
		
		List<DashboardLocation> upazillas = allDashboardLocations.findLocationsByTag(idForUpazillaTag);
		List<DashboardLocationDTO> upazillaDTOs = new ArrayList<DashboardLocationDTO>();
		
		if(upazillas != null){
			for(int i =0; i < upazillas.size(); i++){
				DashboardLocationDTO newDashboardLocationDTO = new DashboardLocationDTO();
				newDashboardLocationDTO.withId(upazillas.get(i).getId());
				newDashboardLocationDTO.withName(upazillas.get(i).getName());
				upazillaDTOs.add(newDashboardLocationDTO);
			}			
		}
		
		return upazillaDTOs;
	}
	
	public String ifLocationColliding(){
		return "";
	}
	
	public DashboardLocationDTO convertLocationToDTO(DashboardLocation location){
		DashboardLocationDTO locationDTO = new DashboardLocationDTO();
		if(location == null)
			return null;
		locationDTO.withId(location.getId());
		locationDTO.withName(location.getName());
		locationDTO.withTagId(location.getTagId());
		locationDTO.withParentId(location.getParentId());
		locationDTO.withParentname(location.getParentName());
		
		return locationDTO;
	}
	
	public List<DashboardLocationDTO> convertLocationToDTOList(List<DashboardLocation> location){
		List<DashboardLocationDTO> locationDTO = new  ArrayList<DashboardLocationDTO>();
		DashboardLocationDTO singleLocationDTO = null;
		if(location == null)
			return null;
		
		for(int i = 0; i < location.size(); i++){
			singleLocationDTO = new DashboardLocationDTO();
			singleLocationDTO.withId(location.get(i).getId());
			singleLocationDTO.withName(location.get(i).getName());
			singleLocationDTO.withTagId(location.get(i).getTagId());
			singleLocationDTO.withParentId(location.get(i).getParentId());
			singleLocationDTO.withParentname(location.get(i).getParentName());
			
			locationDTO.add(singleLocationDTO);
		}
		
		
		return locationDTO;
	}
}
