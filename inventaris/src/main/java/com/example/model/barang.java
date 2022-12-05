package com.example.model;

public class barang {
    private String kode_barang;
    private String tanggal_beli;
    private String nama_barang;
    private String kondisi_barang;
    private String is_deleted;
    private String id_pj;

    public String getId_pj(){
        return id_pj;
    }
    public void setId_pj(String id_pj){
        this.id_pj = id_pj;
    }

    public void setKode_barang(String kode_barang){
        this.kode_barang = kode_barang;
    }
    public String getKode_barang(){
        return kode_barang;
    }
    public void setTanggal_beli(String tanggal_beli){
        this.tanggal_beli = tanggal_beli;
    }
    public String getTanggal_beli(){
        return tanggal_beli;
    }
    public void setNama_barang(String nama_barang){
        this.nama_barang = nama_barang;
    }
    public String getNama_barang(){
        return nama_barang;
    }
    public void setKondisi_barang(String kondisi_barang){
        this.kondisi_barang = kondisi_barang;
    }
    public String getKondisi_barang(){
        return kondisi_barang;
    }
    public void setIs_deleted(String is_deleted){
        this.is_deleted = is_deleted;
    }
    public String getIs_deleted(){
        return is_deleted;
    }
}
