package com.example.portailbackend.repository;

import com.example.portailbackend.models.Demande;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DemandeRepository extends JpaRepository<Demande, Long> {
    List<Demande> findByCreatedBy(String createdBy);
    List<Demande> findByCurrentApprover(String currentApprover);

}
