/*****************************************************************************
 * FILE NAME   : ICredentialRepository.java
 * VERSION     : 1.0
 * AUTHOR      : avijit
 * DATE        : Aug 24, 2017
 * DESCRIPTION : together-server
 ****************************************************************************/
package com.avijit.together.database.repository;

import com.avijit.together.core.model.Credential;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * @author avijit
 *
 */
@Repository("iCredentialRepository")
public interface ICredentialRepository extends PagingAndSortingRepository<Credential, UUID> {
	/**
	 * @param username
	 * @return
	 */
	Credential findByUsername(String username);
}