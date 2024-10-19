package com.example.demo.CommandeDetails;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface CommandeDetailsRepo extends JpaRepository<CommandeDetails , Integer> {
    @Query(value = "SELECT * FROM commande_details WHERE user_id = :idUser ", nativeQuery = true)
    List<CommandeDetails> findCommandeDetailsByUserId(@Param("idUser") int id) ; 
}
