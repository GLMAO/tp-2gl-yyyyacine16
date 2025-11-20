package com.polytech.tp;

import java.util.ArrayList;
import java.util.List;

public class GestionnaireEmploiDuTemps {
    private List<ICours> listeCours = new ArrayList<>();
    private List<Observer> listeObservateurs = new ArrayList<>();
    public void ajouterCours(ICours cours) {
        this.listeCours.add(cours);
        System.out.println("Nouveau cours ajouté : " + cours.getDescription());
        // TODO: C'est ici qu'il faudrait notifier les étudiants (Observer pattern)
        for(Observer o : listeObservateurs) {
            o.update("Nouveau cours ajouté : " + cours.getDescription());
        }
    }

    public void modifierCours(ICours cours, String message) {
        // Logique de modification...
        for (ICours c : listeCours) {
            if (c.equals(cours)) {
                listeCours.remove(c);
                listeCours.add(cours);


        System.out.println("Cours modifié : " + message);
        // TODO: Notifier les observateurs ici aussi
        for(Observer o : listeObservateurs) {
            o.update("Cours modifié : " + cours.getDescription());
        }

            }
        }
       System.out.println("cours non trouvé");
    }

    public void setChangement(String string) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setChangement'");
    }
}