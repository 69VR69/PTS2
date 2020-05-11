package fr.iut.orsay.pts2.interfaces;

import java.util.HashMap;

import fr.iut.orsay.pts2.ressource.Ressource;

public interface TODO
    {
        //TODO: implementer le tableau suivant dans le batiment de production = cité (troupes,baitments...) + classe Cost
        /*
        HashMap<Object, ArrayList<Cost>> productionList = new HashMap<>();
        //DOC: https://stackoverflow.com/questions/19541582/storing-and-retrieving-arraylist-values-from-hashmap
        */
        //Class Cost:
        HashMap<Ressource, Integer> ressources = new HashMap<>();// <objet ressource, quantité>
        int time = 1; //nb de tours pour produire l'objet
    }
