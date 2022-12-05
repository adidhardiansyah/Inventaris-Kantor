package com.example.model;

public class peminjaman {
    private String nip_peminjam;
    private String kode_barang;
    private String tanggal_pinjam;
    private String nama_peminjam;
    private String domisili_peminjam;
    private String tanggal_beli;
    private String nama_barang;
    private String kondisi_barang;

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
}