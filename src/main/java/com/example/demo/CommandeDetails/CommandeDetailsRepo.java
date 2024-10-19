package com.example.demo.CommandeDetails;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CommandeDetailsRepo extends JpaRepository<CommandeDetails , Integer> {

}
