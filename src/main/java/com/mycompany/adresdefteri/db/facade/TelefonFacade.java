/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.adresdefteri.db.facade;

import com.mycompany.adresdefteri.db.entity.Telefon;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Can
 */
@Stateless
public class TelefonFacade extends AbstractFacade<Telefon> {

    @PersistenceContext(unitName = "com.mycompany_AdresDefteri_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TelefonFacade() {
        super(Telefon.class);
    }
    
}
