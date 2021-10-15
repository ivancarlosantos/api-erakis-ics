package com.erakis_ics.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.erakis_ics.api.entity.Login;

/*  
 * @author by: icarlos 
 */

@Repository
public interface LoginRepository extends JpaRepository<Login, Long> {

}
