/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.adresdefteri.bean;

import com.mycompany.adresdefteri.db.entity.Kisi;
import com.mycompany.adresdefteri.db.entity.Telefon;
import com.mycompany.adresdefteri.db.facade.KisiFacade;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Can
 */

@SessionScoped
@ManagedBean(name = "index")
public class Index implements Serializable{

    @EJB
    private KisiFacade kisiFacade=new KisiFacade();
    
    
    
    private Kisi kisi = new Kisi();
    private Telefon tel = new Telefon();
    
    public Index(){
        
    }

    public Kisi getKisi() {
        return kisi;
    }

    public void setKisi(Kisi kisi) {
        this.kisi = kisi;
    }

    public Telefon getTel() {
        return tel;
    }

    public void setTel(Telefon tel) {
        this.tel = tel;
    }
    
    public void kisiKaydet(){
        List<Telefon> telefonList = new ArrayList<>();
        telefonList.add(tel);
        kisi.setTelefonList(telefonList);

        this.kisiFacade.create(this.kisi);
        this.kisi=new Kisi();
    }
    
    public List<Kisi> liste() {
        return this.kisiFacade.findAll();
    }
    
    public void sil(Kisi kisi){
        this.kisiFacade.remove(kisi);
    }
    
    public String guncelle(Kisi kisi){
        this.kisi=kisi;
        return "guncelle";
    }
    
    public String guncelle(){
        
        this.kisiFacade.edit(this.kisi);
        this.kisi=new Kisi();
        return "arama";
    }
}
