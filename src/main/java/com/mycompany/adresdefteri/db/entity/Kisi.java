/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.adresdefteri.db.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Can
 */
@Entity
@Table(catalog = "adresdefteri", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Kisi.findAll", query = "SELECT k FROM Kisi k")
    , @NamedQuery(name = "Kisi.findByKisiId", query = "SELECT k FROM Kisi k WHERE k.kisiId = :kisiId")
    , @NamedQuery(name = "Kisi.findByAd", query = "SELECT k FROM Kisi k WHERE k.ad = :ad")
    , @NamedQuery(name = "Kisi.findBySoyad", query = "SELECT k FROM Kisi k WHERE k.soyad = :soyad")
    , @NamedQuery(name = "Kisi.findByAdres", query = "SELECT k FROM Kisi k WHERE k.adres = :adres")
    , @NamedQuery(name = "Kisi.findByEmail", query = "SELECT k FROM Kisi k WHERE k.email = :email")})
public class Kisi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "kisi_id", nullable = false)
    private Integer kisiId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(nullable = false, length = 15)
    private String ad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(nullable = false, length = 15)
    private String soyad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(nullable = false, length = 50)
    private String adres;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(nullable = false, length = 40)
    private String email;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "kisiId", fetch = FetchType.EAGER)
    private List<Telefon> telefonList;

    public Kisi() {
    }

    @PrePersist
    private void prePersistMethod(){
        for(Telefon tel: telefonList){
            tel.setKisiId(this);
        }
    }

    @PreUpdate
    private void preUpdateMethod(){
        for(Telefon tel: telefonList){
            tel.setKisiId(this);
        }
    }
    
    
    public Kisi(Integer kisiId) {
        this.kisiId = kisiId;
    }

    public Kisi(Integer kisiId, String ad, String soyad, String adres, String email) {
        this.kisiId = kisiId;
        this.ad = ad;
        this.soyad = soyad;
        this.adres = adres;
        this.email = email;
    }

    public Integer getKisiId() {
        return kisiId;
    }

    public void setKisiId(Integer kisiId) {
        this.kisiId = kisiId;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @XmlTransient
    public List<Telefon> getTelefonList() {
        return telefonList;
    }

    public void setTelefonList(List<Telefon> telefonList) {
        this.telefonList = telefonList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (kisiId != null ? kisiId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Kisi)) {
            return false;
        }
        Kisi other = (Kisi) object;
        if ((this.kisiId == null && other.kisiId != null) || (this.kisiId != null && !this.kisiId.equals(other.kisiId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.adresdefteri.db.entity.Kisi[ kisiId=" + kisiId + " ]";
    }
    
}
