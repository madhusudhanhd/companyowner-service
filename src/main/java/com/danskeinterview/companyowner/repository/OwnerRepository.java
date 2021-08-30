package com.danskeinterview.companyowner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.danskeinterview.companyowner.entity.Owner;


@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long>{

}
