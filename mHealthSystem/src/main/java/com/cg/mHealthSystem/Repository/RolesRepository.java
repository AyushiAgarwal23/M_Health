package com.cg.mHealthSystem.Repository;


import org.springframework.data.repository.CrudRepository;

import com.cg.mHealthSystem.entity.Roles;

/**
 * 
 * @author ayushranjan
 *
 * Roles Repository interface which extends CrudRepository 
 */

public interface RolesRepository  extends CrudRepository<Roles,Integer> {

}
