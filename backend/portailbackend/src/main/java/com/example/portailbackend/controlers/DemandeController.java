package com.example.portailbackend.controlers;


import com.example.portailbackend.models.Demande;
import com.example.portailbackend.service.DemandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/demandes")
public class DemandeController {


    @Autowired
    private DemandeService demandeService;

    @PostMapping("/create")
    public ResponseEntity<Demande> createDemande(@RequestBody Demande demande) {
        Demande createdDemande = demandeService.createDemande(demande);
        return ResponseEntity.ok(createdDemande);
    }

    @GetMapping("/user/{username}")
    public ResponseEntity<List<Demande>> getDemandesByUser(@PathVariable String username) {
        return ResponseEntity.ok(demandeService.getDemandesByUser(username));
    }
    @GetMapping("/demandes")
    public ResponseEntity<List<Demande>> getAllUsers() {
        return ResponseEntity.ok(demandeService.getDemandes());
    }

    @GetMapping("/approver/{role}")
    public ResponseEntity<List<Demande>> getPendingDemandes(@PathVariable String role) {
        return ResponseEntity.ok(demandeService.getPendingDemandesForApprover(role));
    }

    @PatchMapping("/{id}/update-status")
    public ResponseEntity<Demande> updateDemandeStatus(
            @PathVariable Long id,
            @RequestBody Demande updateRequest) {

        Demande updatedDemande = demandeService.updateDemandeStatus(id, updateRequest.getStatus(), updateRequest.getCurrentApprover());
        return ResponseEntity.ok(updatedDemande);
    }

}
