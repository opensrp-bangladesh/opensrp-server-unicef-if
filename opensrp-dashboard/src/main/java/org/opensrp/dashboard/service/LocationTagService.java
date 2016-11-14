package org.opensrp.dashboard.service;

import java.util.ArrayList;
import java.util.List;

import org.ektorp.DocumentNotFoundException;
import org.opensrp.dashboard.dto.DashboardLocationDTO;
import org.opensrp.dashboard.dto.LocationTagDTO;
import org.opensrp.dashboard.dto.PrivilegeDTO;
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
public class LocationTagService {
	
	private static Logger logger = LoggerFactory.getLogger(LocationTagService.class);
	
	private AllLocationTags allLocationTags;
	
	@Autowired
	public LocationTagService(AllLocationTags allLocationTags) {
		this.allLocationTags = allLocationTags;
	}
	
	public String addLocationTag(LocationTagDTO locationTagDTO){
		if(allLocationTags.findLocationTagByName(locationTagDTO.getName()) == null){
			List<LocationTag> existingLocationTags = allLocationTags.getAll();
			LocationTag changeParentTag = null;
			
			LocationTag newLocationTag =  new LocationTag();
			newLocationTag.withName(locationTagDTO.getName());
			newLocationTag.withParentTagId(locationTagDTO.getParentTagId());
			allLocationTags.add(newLocationTag);
			
			// for inserting new locationTag within existing hierarchy			
			for(int i =0; i<existingLocationTags.size(); i++){
				if(existingLocationTags.get(i).getParentTagId().equals(locationTagDTO.getParentTagId())){
					changeParentTag = existingLocationTags.get(i);
					changeParentTag.withParentTagId(newLocationTag.getId());
					allLocationTags.update(changeParentTag);
					break;
				}
			}		
			
			return "1";
		}else{
			return "2";
		}
	}
	
	public String editLocationTag(LocationTagDTO locationTagDTO){
		LocationTag tagToEdit = null;
		try{
			tagToEdit = allLocationTags.get(locationTagDTO.getId());
		}catch(DocumentNotFoundException e){
			return "2";
		}	
		
		if(tagToEdit == null || allLocationTags.findLocationTagByName(locationTagDTO.getName()) != null){
			return "2";
		}else{
			tagToEdit.withName(locationTagDTO.getName());
			allLocationTags.update(tagToEdit);
			return "1";
		}
	}
	
	public String deleteLocationTag(String locationId){
		LocationTag tagToDelete = null;
		try{
			tagToDelete = allLocationTags.get(locationId);
		}catch(DocumentNotFoundException e){
			return "2";
		}		
			
		List<LocationTag> existingLocationTags = allLocationTags.getAll();
		LocationTag updateTag = null;
		for(int i = 0; i < existingLocationTags.size(); i++){
			if(existingLocationTags.get(i).getParentTagId().equals(tagToDelete.getId())){
				updateTag = existingLocationTags.get(i);
				updateTag.withParentTagId(tagToDelete.getParentTagId());
				allLocationTags.update(updateTag);
				break;
			}			
		}
		
		allLocationTags.remove(tagToDelete);
		
		return "1";		
	}
	
	public LocationTagDTO getLocationTag(String locationTagName){
		List<LocationTag> locationTags = allLocationTags.getAll();
		LocationTagDTO locationTagDTO = null;
		
		for(int i = 0; i < locationTags.size(); i++ ){
			if(locationTags.get(i).getName().equals(locationTagName)){
				locationTagDTO = new LocationTagDTO(); 
			    locationTagDTO.withId(locationTags.get(i).getId());
			    locationTagDTO.withName(locationTags.get(i).getName());
			    locationTagDTO.withParentTagId(locationTags.get(i).getParentTagId());
			    break;
			}
		}
		
		return locationTagDTO;
	}
	
	public List<LocationTagDTO> getAllLocationTags(){
		List<LocationTag> locationTags = allLocationTags.getAll();
		List<LocationTagDTO> locationTagDTOs = new ArrayList<LocationTagDTO>();
		
		for(int i = 0; i < locationTags.size(); i++ ){
				LocationTagDTO locationTagDTO = new LocationTagDTO(); 
			    locationTagDTO.withId(locationTags.get(i).getId());
			    locationTagDTO.withName(locationTags.get(i).getName());
			    locationTagDTO.withParentTagId(locationTags.get(i).getParentTagId());
			    locationTagDTOs.add(locationTagDTO);
		}
		
		return locationTagDTOs;
	}
}
