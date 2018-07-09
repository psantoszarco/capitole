package com.project.multi.repository.custom;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import com.project.multi.entities.Users;


/**
 * The Class CustomProductRepositoryImpl.
 */
public class CustomUsersRepositoryImpl extends SimpleJpaRepository<Users, Integer> implements CustomUsersRepository{
	
	/** The entity information. */
	private final JpaEntityInformation<Users, Integer> entityInformation;
    
    /** The entity manager. */
    private final EntityManager entityManager;
	
	/**
	 * Instantiates a new custom letter repository impl.
	 *
	 * @param entityInformation the entity information
	 * @param entityManager the entity manager
	 */
	public CustomUsersRepositoryImpl(JpaEntityInformation<Users, Integer> entityInformation,
			EntityManager entityManager) {
		super(entityInformation, entityManager);
		
		this.entityInformation = entityInformation;
        this.entityManager = entityManager;
	}


}
