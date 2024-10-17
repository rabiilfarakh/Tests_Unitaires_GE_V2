package dao;


import entity.JobApp;

import java.util.List;
import java.util.Optional;

public interface GenericDao<T, ID> {

    /**
     * Enregistre une entité dans la base de données.
     *
     * @param entity l'entité à enregistrer
     * @return
     */
    void save(T entity);

    /**
     * Met à jour une entité dans la base de données.
     *
     * @param entity l'entité à mettre à jour
     */
    void update(T entity);

    /**
     * Supprime une entité de la base de données.
     *
     * @param entity l'entité à supprimer
     */
    void delete(T entity);

    /**
     * Recherche une entité par son identifiant.
     *
     * @param id l'identifiant de l'entité
     * @return un Optional contenant l'entité si trouvée, sinon vide
     */
    Optional<T> findById(ID id);

    /**
     * Récupère toutes les entités.
     *
     * @return une liste de toutes les entités
     */
    List<T> findAll();

}