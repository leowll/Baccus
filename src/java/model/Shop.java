/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "shop")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Shop.findAll", query = "SELECT s FROM Shop s"),
    @NamedQuery(name = "Shop.findByShopName", query = "SELECT s FROM Shop s WHERE s.shopName = :shopName"),
    @NamedQuery(name = "Shop.findByShopAddress1", query = "SELECT s FROM Shop s WHERE s.shopAddress1 = :shopAddress1"),
    @NamedQuery(name = "Shop.findByShopAddress2", query = "SELECT s FROM Shop s WHERE s.shopAddress2 = :shopAddress2"),
    @NamedQuery(name = "Shop.findByShopUrl", query = "SELECT s FROM Shop s WHERE s.shopUrl = :shopUrl"),
    @NamedQuery(name = "Shop.findByShopId", query = "SELECT s FROM Shop s WHERE s.shopId = :shopId")
})
public class Shop implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 50)
    @Column(name = "shop_name")
    private String shopName;
    @Size(max = 50)
    @Column(name = "shop_address1")
    private String shopAddress1;
    @Size(max = 50)
    @Column(name = "shop_address2")
    private String shopAddress2;
    @Size(max = 100)
    @Column(name = "shop_url")
    private String shopUrl;
    
    @Id
    @Column(name = "shop_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer shopId;

    public Shop() {
    }

    public Shop(Integer shopId) {
        this.shopId = shopId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopAddress1() {
        return shopAddress1;
    }

    public void setShopAddress1(String shopAddress1) {
        this.shopAddress1 = shopAddress1;
    }

    public String getShopAddress2() {
        return shopAddress2;
    }

    public void setShopAddress2(String shopAddress2) {
        this.shopAddress2 = shopAddress2;
    }

    public String getShopUrl() {
        return shopUrl;
    }

    public void setShopUrl(String shopUrl) {
        this.shopUrl = shopUrl;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (shopId != null ? shopId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Shop)) {
            return false;
        }
        Shop other = (Shop) object;
        if ((this.shopId == null && other.shopId != null) || (this.shopId != null && !this.shopId.equals(other.shopId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Shop[ shopId=" + shopId + " ]";
    }
    
}
