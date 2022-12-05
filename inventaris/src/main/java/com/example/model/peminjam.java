package com.example.model;

public class peminjam {
    private String nip_peminjam;
    private String kode_barang;
    private String tanggal_pinjam;
    private String nama_peminjam;
    private String domisili_peminjam;
    private String is_deleted;
    private String id_peminjam;

    public String getId_peminjam(){
        return id_peminjam;
    }
    public void setId_peminjam(String id_peminjam){
        this.id_peminjam = id_peminjam;
    }

    public String getNip_peminjam(){
        return nip_peminjam;
    }
    public void setNip_peminjam(String nip_peminjam){
        this.nip_peminjam = nip_peminjam;
    }
    public String getKode_barang(){
        return kode_barang;
    }
    public void setKode_barang(String kode_barang){
        this.kode_barang = kode_barang;
    }
    public String getTanggal_pinjam(){
        return tanggal_pinjam;
    }
    public void setTanggal_pinjam(String tanggal_pinjam){
        this.tanggal_pinjam = tanggal_pinjam;
    }
    public String getNama_peminjam(){
        return nama_peminjam;
    }
    public void setNama_peminjam(String nama_peminjam){
        this.nama_peminjam = nama_peminjam;
    }
    public String getDomisili_peminjam(){
        return domisili_peminjam;
    }
    public void setDomisili_peminjam(String domisili_peminjam){
        this.domisili_peminjam = domisili_peminjam;
    }
    public String getIs_deleted(){
        return is_deleted;
    }
    public void setIs_deleted(String is_deleted){
        this.is_deleted = is_deleted;
    }
}
