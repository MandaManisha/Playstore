package com.store.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.store.entity.Owner;

public interface OwnerRepository extends JpaRepository<Owner, Long> {

    Optional<Owner> findByOwneremail(String owneremail);

    Optional<Owner> findByOwnername(String ownername);
    
    Boolean existsByOwnername(String ownername);

    Boolean existsByOwneremail(String owneremail);
}
