package org.opensrp.service;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.json.JSONException;
import org.json.JSONObject;
import org.opensrp.domain.Address;
import org.opensrp.domain.Client;
import org.opensrp.domain.IdentifierMaping;
import org.opensrp.repository.AllClients;
import org.opensrp.repository.IndetifierMapingRepository;
import org.opensrp.util.DateTimeTypeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Service
public class ClientService {
	
	private static Logger logger = Logger.getLogger(ClientService.class);
	
	private final AllClients allClients;
	
	private IndetifierMapingRepository bahmniIdRepository;
	
	@Autowired
	public ClientService(AllClients allClients, IndetifierMapingRepository bahmniIdRepository) {
		this.allClients = allClients;
		this.bahmniIdRepository = bahmniIdRepository;
	}
	
	public Client getByBaseEntityId(String baseEntityId) {
		return allClients.findByBaseEntityId(baseEntityId);
	}
	
	public List<Client> findAllClients() {
		return allClients.findAllClients();
	}
	
	public List<Client> findAllByIdentifier(String identifier) {
		return allClients.findAllByIdentifier(identifier);
	}
	
	public List<Client> findAllByIdentifier(String identifierType, String identifier) {
		return allClients.findAllByIdentifier(identifierType, identifier);
	}
	
	public List<Client> findAllByAttribute(String attributeType, String attribute) {
		return allClients.findAllByAttribute(attributeType, attribute);
	}
	
	public List<Client> findAllByMatchingName(String nameMatches) {
		return allClients.findAllByMatchingName(nameMatches);
	}
	
	public List<Client> findByCriteria(String nameLike, String gender, DateTime birthdateFrom, DateTime birthdateTo,
	                                   DateTime deathdateFrom, DateTime deathdateTo, String attributeType,
	                                   String attributeValue, String addressType, String country, String stateProvince,
	                                   String cityVillage, String countyDistrict, String subDistrict, String town,
	                                   String subTown, DateTime lastEditFrom, DateTime lastEditTo) {
		return allClients.findByCriteria(nameLike, gender, birthdateFrom, birthdateTo, deathdateFrom, deathdateTo,
		    attributeType, attributeValue, addressType, country, stateProvince, cityVillage, countyDistrict, subDistrict,
		    town, subTown, lastEditFrom, lastEditTo);//db.queryView(q.includeDocs(true), Client.class);
	}
	
	public List<Client> findByCriteria(String nameLike, String gender, DateTime birthdateFrom, DateTime birthdateTo,
	                                   DateTime deathdateFrom, DateTime deathdateTo, String attributeType,
	                                   String attributeValue, DateTime lastEditFrom, DateTime lastEditTo) {
		return allClients.findByCriteria(nameLike, gender, birthdateFrom, birthdateTo, deathdateFrom, deathdateTo,
		    attributeType, attributeValue, null, null, null, null, null, null, null, null, lastEditFrom, lastEditTo);
	}
	
	public List<Client> findByCriteria(String addressType, String country, String stateProvince, String cityVillage,
	                                   String countyDistrict, String subDistrict, String town, String subTown,
	                                   DateTime lastEditFrom, DateTime lastEditTo) {
		return allClients.findByCriteria(null, null, null, null, null, null, null, null, addressType, country,
		    stateProvince, cityVillage, countyDistrict, subDistrict, town, subTown, lastEditFrom, lastEditTo);
	}
	
	public List<Client> findByDynamicQuery(String query) {
		return allClients.findByDynamicQuery(query);
	}
	
	public Client addClient(Client client) {
		if (client.getBaseEntityId() == null) {
			throw new RuntimeException("No baseEntityId");
		}
		Client c = findClient(client);
		if (c != null) {
			throw new IllegalArgumentException(
			        "A client already exists with given list of identifiers. Consider updating data.[" + c + "]");
			
		}
		try {
			IdentifierMaping id = bahmniIdRepository.findByentityId(client.getBaseEntityId());
			client.addIdentifier("Bahmni Id", id.getGenId());
		}
		catch (Exception ee) {
			logger.info("Identifier :" + ee.getMessage());
		}
		client.setDateCreated(new Date());
		allClients.add(client);
		return client;
	}
	
	public Client findClient(Client client) {
		// find by auto assigned entity id
		System.out.println("getBaseEntityId:" + client.getBaseEntityId());
		Client c = allClients.findByBaseEntityId(client.getBaseEntityId());
		if (c != null) {
			return c;
		}
		
		//still not found!! search by generic identifiers
		
		try {
			for (String idt : client.getIdentifiers().keySet()) {
				System.out.println("client.getIdentifier(idt):" + client.getIdentifier(idt));
				List<Client> cl = allClients.findAllByIdentifier(client.getIdentifier(idt));
				System.out.println("Client String:" + cl.get(0).getId() + "Size:" + cl.size());
				if (cl.size() > 1) {
					//return cl.get(0); 
					throw new IllegalArgumentException("Multiple clients with identifier type " + idt + " and ID "
					        + client.getIdentifier(idt) + " exist.");
				} else if (cl.size() != 0) {
					return cl.get(0);
				}
			}
		}
		catch (Exception e) {
			logger.info("MM:" + e.getStackTrace());
			return c;
		}
		
		return c;
	}
	
	public Client find(String uniqueId) {
		// find by document id
		Client c = allClients.findByBaseEntityId(uniqueId);
		if (c != null) {
			return c;
		}
		
		// if not found find if it is in any identifiers TODO refactor it later
		List<Client> cl = allClients.findAllByIdentifier(uniqueId);
		if (cl.size() > 1) {
			throw new IllegalArgumentException("Multiple clients with identifier " + uniqueId + " exist.");
		} else if (cl.size() != 0) {
			return cl.get(0);
		}
		
		return c;
	}
	
	public void updateClient(Client updatedClient) throws JSONException {
		// If update is on original entity
		if (updatedClient.isNew()) {
			throw new IllegalArgumentException(
			        "Client to be updated is not an existing and persisting domain object. Update database object instead of new pojo");
		}
		
		if (findClient(updatedClient) == null) {
			throw new IllegalArgumentException("No client found with given list of identifiers. Consider adding new!");
		}
		
		updatedClient.setDateEdited(new Date());
		allClients.update(updatedClient);
	}
	
	public Client mergeClient(Client updatedClient) {
		try {
			Client original = findClient(updatedClient);
			if (original == null) {
				throw new IllegalArgumentException("No client found with given list of identifiers. Consider adding new!");
			}
			
			Gson gs = new GsonBuilder().registerTypeAdapter(DateTime.class, new DateTimeTypeConverter()).create();
			JSONObject originalJo = new JSONObject(gs.toJson(original));
			
			JSONObject updatedJo = new JSONObject(gs.toJson(updatedClient));
			List<Field> fn = Arrays.asList(Client.class.getDeclaredFields());
			
			JSONObject mergedJson = new JSONObject();
			if (originalJo.length() > 0) {
				mergedJson = new JSONObject(originalJo, JSONObject.getNames(originalJo));
			}
			if (updatedJo.length() > 0) {
				for (Field key : fn) {
					String jokey = key.getName();
					if (updatedJo.has(jokey))
						mergedJson.put(jokey, updatedJo.get(jokey));
				}
				
				original = gs.fromJson(mergedJson.toString(), Client.class);
				
				for (Address a : updatedClient.getAddresses()) {
					if (original.getAddress(a.getAddressType()) == null)
						original.addAddress(a);
				}
				for (String k : updatedClient.getIdentifiers().keySet()) {
					original.addIdentifier(k, updatedClient.getIdentifier(k));
				}
				for (String k : updatedClient.getAttributes().keySet()) {
					original.addAttribute(k, updatedClient.getAttribute(k));
				}
			}
			logger.info("Original:" + original.toString());
			original.setDateEdited(new Date());
			allClients.update(original);
			return original;
		}
		catch (JSONException e) {
			throw new RuntimeException(e);
		}
	}
}
