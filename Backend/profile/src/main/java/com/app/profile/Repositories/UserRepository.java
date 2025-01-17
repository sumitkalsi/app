package com.app.profile.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.profile.Models.User;


@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	
	  @Query("SELECT u FROM User u WHERE u.email = :email" )
	    Optional<User> findUserByEmail(@Param("email") String email);

}
