package com.valtech.training.restapis.services;

import java.util.List;

import com.valtech.training.restapis.entities.Owner;
import com.valtech.training.restapis.vos.OwnerVO;

public interface OwnerService {

	List<OwnerVO> getOwners();

	OwnerVO getOwner(long id);

	OwnerVO udateOwner(OwnerVO owner, long id);

	OwnerVO createOwner(OwnerVO owner);

	void deleteOwner(long id);

	OwnerVO addWatchesToOwner(long id, List<Long> watches);


}