package com.example.portailbackend.service;

import com.example.portailbackend.models.Demande;
import com.example.portailbackend.repository.DemandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DemandeService {

    @Autowired
    private DemandeRepository demandeRepository;


    public List<Demande> getDemandes() {
        return demandeRepository.findAll();
    }
    public Demande createDemande(Demande demande) {
        demande.setStatus("PENDING");
        demande.setCreationDate(new Date());
        demande.setLastUpdated(new Date());
        return demandeRepository.save(demande);
    }

    public List<Demande> getDemandesByUser(String username) {
        return demandeRepository.findByCreatedBy(username);
    }

    public List<Demande> getPendingDemandesForApprover(String role) {
        return demandeRepository.findByCurrentApprover(role);
    }

    public Demande updateDemandeStatus(Long demandeId, String status, String approver) {
        Demande demande = demandeRepository.findById(demandeId)
                .orElseThrow(() -> new RuntimeException("Demande not found!"));

        demande.setStatus(status);
        demande.setLastUpdated(new Date());
        if (status.equals("APPROVED") && "CHEF".equals(approver)) {
            demande.setCurrentApprover("RH");
        } else if (status.equals("APPROVED") && "RH".equals(approver)) {
            demande.setCurrentApprover(null); // Final approval
        } else if (status.equals("REJECTED")) {
            demande.setCurrentApprover("EMPLOYEE");
        }

        return demandeRepository.save(demande);
    }

}
