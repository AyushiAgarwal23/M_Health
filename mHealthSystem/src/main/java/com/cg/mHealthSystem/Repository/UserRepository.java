package com.cg.mHealthSystem.Repository;


import org.springframework.data.repository.CrudRepository;

import com.cg.mHealthSystem.entity.User;


/**
 * 
 * @author ayushranjan
 *
 *User Repository interface which extends CrudRepository 
 */
public interface UserRepository   extends CrudRepository<User,Integer>{

}
