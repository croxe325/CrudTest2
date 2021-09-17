package com.fikri.CrudTest2.model;

import javax.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue (strategy= GenerationType.AUTO)
    private Integer id;
    private String nama_barang;
    private String qty;
    private String harga;
    @Lob
    private String image;



    @Version
    @Column (name ="optVersion", columnDefinition = "integer DEFAULT 0")
    private Integer version;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNama_barang() {
        return nama_barang;
    }

    public void setNama_barang(String nama_barang) {
        this.nama_barang = nama_barang;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }


    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}

