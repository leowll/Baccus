/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import model.Shop;
import dao.ShopDAO;

/**
 *
 * @author leo
 */
@Named
@SessionScoped
public class BackingBean implements Serializable {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    private List shopList;
    private Shop shop;
    private String id;

    @PersistenceUnit
    EntityManagerFactory emf;

    @EJB
    private ShopDAO shopDAO;
    
    

    public String showShop() {
        shop = shopDAO.findById(id);
        return "shopinfo";
    }

    public String showShopList() {
        shopList = shopDAO.findAll();
        return "shoplist";
    }

    public String createShop() {
        if (shopDAO.create(shop)) {
            return showShopList();
        } else {
            return "error.xhtml";
        }
    }

    public String deleteShop(String id) {
        System.out.println("Id:" + id);
        Shop shopToBeDeleted = shopDAO.findById(id);
        if (shopDAO.delete(shopToBeDeleted)) {
            return showShopList();
        } else {
            return "error.xhtml";
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the shopList
     */
    public List<Shop> getShopList() {
        return shopList;
    }

    /**
     * @param shopList the shopList to set
     */
    public void setShopList(ArrayList<Shop> shopList) {
        this.shopList = shopList;
    }

    /**
     * @return the shop
     */
    public Shop getShop() {
        return shop;
    }

    /**
     * @param shop the shop to set
     */
    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public ShopDAO getShopDAO() {
        return shopDAO;
    }

    public void setShopDAO(ShopDAO shopDAO) {
        this.shopDAO = shopDAO;
    }

    @PostConstruct
    public void init() {
        shop = new Shop();
        shopList = new ArrayList<>();
    }

}
