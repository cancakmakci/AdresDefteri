/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.adresdefteri.db.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Can
 */
@Entity
@Table(catalog = "adresdefteri", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Telefon.findAll", query = "SELECT t FROM Telefon t")
    , @NamedQuery(name = "Telefon.findByTelId", query = "SELECT t FROM Telefon t WHERE t.telId = :telId")
    , @NamedQuery(name = "Telefon.findByTelno", query = "SELECT t FROM Telefon t WHERE t.telno = :telno")})
public class Telefon implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tel_id", nullable = false)
    private Integer telId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "telno", nullable = false, length = 15)
    private String telno;
    @JoinColumn(name = "kisi_id", referencedColumnName = "kisi_id", nullable = false)
    @ManyToOne(optional = false)
    private Kisi kisiId;

    public Telefon() {
    }

    public Telefon(Integer telId) {
        this.telId = telId;
    }

    public Telefon(Integer telId, String telno) {
        this.telId = telId;
        this.telno = telno;
    }

    public Integer getTelId() {
        return telId;
    }

    public void setTelId(Integer telId) {
        this.telId = telId;
    }

    public String getTelno() {
        return telno;
    }

    public void setTelno(String telno) {
        this.telno = telno;
    }

    public Kisi getKisiId() {
        return kisiId;
    }

    public void setKisiId(Kisi kisiId) {
        this.kisiId = kisiId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (telId != null ? telId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Telefon)) {
            return false;
        }
        Telefon other = (Telefon) object;
        if ((this.telId == null && other.telId != null) || (this.telId != null && !this.telId.equals(other.telId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return telno;
    }
    
}
