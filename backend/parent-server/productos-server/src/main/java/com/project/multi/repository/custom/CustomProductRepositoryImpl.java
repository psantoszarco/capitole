package com.project.multi.repository.custom;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import com.project.multi.entities.Producto;


/**
 * The Class CustomProductRepositoryImpl.
 */
public class CustomProductRepositoryImpl extends SimpleJpaRepository<Producto, Integer> implements CustomProductRepository{
	
	/** The entity information. */
	private final JpaEntityInformation<Producto, Integer> entityInformation;
    
    /** The entity manager. */
    private final EntityManager entityManager;
	
	/**
	 * Instantiates a new custom letter repository impl.
	 *
	 * @param entityInformation the entity information
	 * @param entityManager the entity manager
	 */
	public CustomProductRepositoryImpl(JpaEntityInformation<Producto, Integer> entityInformation,
			EntityManager entityManager) {
		super(entityInformation, entityManager);
		
		this.entityInformation = entityInformation;
        this.entityManager = entityManager;
	}


}
