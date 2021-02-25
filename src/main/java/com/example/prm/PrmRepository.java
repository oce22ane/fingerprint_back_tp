package com.example.prm;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface PrmRepository extends CrudRepository<prm, Integer> {
    @Query(
            value = "SELECT count(*) as nb FROM prm p GROUP BY p.CC having nb>1",
            nativeQuery = true)
    List<Integer> findNbCollision();

    @Query(
            value = "SELECT count(*) as nb FROM prm p GROUP BY p.CC having nb<2",
            nativeQuery = true)
    List<Integer> findNbDiff();

    @Query(
            value = "SELECT count(*) as nb FROM prm p GROUP BY p.CC , p.fingerprint having nb>1",
            nativeQuery = true)
    List<Integer> findNbVraiCollision();

}