package com.example.model;

public class pjbarang {
    private String kode_barang;
    private String nip_pj;
    private String nama_pj;
    private String is_deleted;
    private String id_pj;

    public String getId_pj(){
        return id_pj;
    }
    public void setId_pj(String id_pj){
        this.id_pj = id_pj;
    }
    
    public String getNip_pj(){
        return nip_pj;
    }
    public void setNip_pj(String nip_pj){
        this.nip_pj = nip_pj;
    }
    public String getKode_barang(){
        return kode_barang;
    }
    public void setKode_barang(String kode_barang){
        this.kode_barang = kode_barang;
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
