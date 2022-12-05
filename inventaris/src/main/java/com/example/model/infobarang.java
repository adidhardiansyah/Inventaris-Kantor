package com.example.model;

public class infobarang {
    private String kode_barang;
    private String tanggal_beli;
    private String nama_barang;
    private String kondisi_barang;
    private String is_deleted;
    private String nip_pj;
    private String nama_pj;

    public String getKode_barang(){
        return kode_barang;
    }
    public void setKode_barang(String kode_barang){
        this.kode_barang = kode_barang;
    }
    public String getTanggal_beli(){
        return tanggal_beli;
    }
    public void setTanggal_beli(String tanggal_beli){
        this.tanggal_beli = tanggal_beli;
    }
    public String getNama_barang(){
        return nama_barang;
    }
    public void setNama_barang(String nama_barang){
        this.nama_barang = nama_barang;
    }
    public String getKondisi_barang(){
        return kondisi_barang;
    }
    public void setKondisi_barang(String kondisi_barang){
        this.kondisi_barang = kondisi_barang;
    }
    public String getNip_pj(){
        return nip_pj;
    }
    public void setNip_pj(String nip_pj){
        this.nip_pj = nip_pj;
    }
    public String getNama_pj(){
        return nama_pj;
    }
    public void setNama_pj(String nama_pj){
        this.nama_pj = nama_pj;
    }
    public String getIs_deleted(){
        return is_deleted;
    }
    public void setIs_deleted(String is_deleted){
        this.is_deleted = is_deleted;
    }
}
