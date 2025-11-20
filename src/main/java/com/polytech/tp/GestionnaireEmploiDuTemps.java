package com.polytech.tp;

import java.util.ArrayList;
import java.util.List;

public class GestionnaireEmploiDuTemps implements Subject {
    private List<ICours> listeCours = new ArrayList<>();
    private List<Observer> listeObservateurs = new ArrayList<>();

    public void attach(Observer o) {
        listeObservateurs.add(o);
    }


    @Override
    public void detach(Observer o) {
        listeObservateurs.remove(o);
    }
    public void notifyObservers(String message) {
        for (Observer o : listeObservateurs) {
            o.update(message);
        }
    }
    public void ajouterCours(ICours cours) {
        this.listeCours.add(cours);
        System.out.println("Nouveau cours ajouté : " + cours.getDescription());
        // TODO: C'est ici qu'il faudrait notifier les étudiants (Observer pattern)
        notifyObservers(cours.getDescription());
    }


    public void modifierCours(ICours cours, String message) {
        // Logique de modification...
        for (ICours c : listeCours) {
            if (c.equals(cours)) {
                listeCours.remove(c);
                listeCours.add(cours);


                System.out.println("Cours modifié : " + message);
                // TODO: Notifier les observateurs ici aussi
                notifyObservers(cours.getDescription());

            }
        }
        System.out.println("cours non trouvé");
    }

    public void setChangement(String string) {
        // TODO Auto-generated method stub
        notifyObservers(string);

    }
}