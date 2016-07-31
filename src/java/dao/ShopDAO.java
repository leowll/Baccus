/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Shop;

/**
 *
 * @author leo
 */
@Stateless
public class ShopDAO {
    @PersistenceContext
    private EntityManager em;
    
    public boolean create(Shop shop){
        em.persist(shop);
        return true;
    }
    
    public boolean delete(Shop shop){
        em.remove(shop);
        return true;
    }
    
    public List<Shop> findAll(){
        return (List<Shop>)em.createNamedQuery("Shop.findAll").getResultList();
    }
    
    public Shop findById(String id){
        return em.createNamedQuery("Shop.findByShopId",Shop.class)
                .setParameter("shopId", Integer.getInteger(id))
                .getResultList()
                .get(0);
    }
    
}
