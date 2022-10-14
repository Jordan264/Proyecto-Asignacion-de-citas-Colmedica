/**
* Package with which the persistence of the repositories is accessed
**/
package com.eps.Appointments.persistance.repositories;
/**
* Imports org.springframework
*/
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
/**
* Imports com.eps
*/
import com.eps.Appointments.persistance.entities.Certificate;
/**
* interface with name CertificateRepository which comes from CrudRepository<Certificate, Integer>
*/
@Repository
public interface CertificateRepository extends CrudRepository<Certificate, Integer> {

}
