package com.store.service;

import java.util.List;

import com.store.dto.OwnerDTO;
import com.store.dto.ReviewDTO;
import com.store.entity.Owner;

public interface OwnerService {

	public List<Owner> getAllOwners();

	public Owner getOwnerById(Long ownerid);

	public Owner createOwner(Owner owner);

	public Owner updateOwner(Long ownerid, Owner ownerDetails);

	void deleteOwner(Long ownerid);

	public OwnerDTO getOwnerDataWithUserData(Long ownerid);
	
	public Long getDownloadCount(Long appId);
	
	public List<ReviewDTO> getReviews(Long appId);
	
	public void notifyOwner(Long ownerid, Long appId, String message);
	
}
