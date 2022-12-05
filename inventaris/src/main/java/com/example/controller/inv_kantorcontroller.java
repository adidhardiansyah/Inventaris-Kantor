// MahasiswaController.java
package com.example.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.model.barang;
import com.example.model.infobarang;
import com.example.model.peminjam;
import com.example.model.peminjaman;
import com.example.model.pjbarang;
import com.example.model.user;

@Controller
public class inv_kantorcontroller {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/home")
    public String index(Model model) {
        String sql = "SELECT * FROM PEMINJAMAN";
        List<peminjaman> listPinjam = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(peminjaman.class));
        model.addAttribute("listpinjam", listPinjam);
        return "index";
    }

    @GetMapping("/info")
    public String info(Model model) {
        String sql = "SELECT * FROM INFOBARANG";
        List<infobarang> Listbarang = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(infobarang.class));
        model.addAttribute("listbarang", Listbarang);
        String sql2 = "SELECT * FROM PJ_BARANG WHERE IS_DELETED = 'n'";
        List<pjbarang> ListPj = jdbcTemplate.query(sql2,
                BeanPropertyRowMapper.newInstance(pjbarang.class));
        model.addAttribute("listpj", ListPj);
        return "info";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getUser() {
        return "login";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String login(@ModelAttribute(name = "user") user user, Model model) {
        String username = user.getUsername();
        String password = user.getPassword();
        try {
            String sql = "SELECT * FROM USERS WHERE USERNAME = ?";
            user asli = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(user.class), username);
            model.addAttribute("asli", asli);
            String passasli = asli.getPassword();
            if (password.equals(passasli)) {
                return "redirect:/home";
            }
        } catch (EmptyResultDataAccessException e) {
            // TODO: handle exception
            model.addAttribute("invalidCredentials", true);
        }
        model.addAttribute("invalidCredentials", true);
        return "login";
    }

    @GetMapping("/addpeminjaman")
    public String add(Model model) {
        return "addpeminjaman";
    }

    @RequestMapping(value ="/addpeminjaman", method = RequestMethod.POST)
    public String addpeminjaman(peminjam peminjam) {
        String sql = "INSERT INTO PEMINJAM (nama_peminjam, nip_peminjam, domisili_peminjam, tanggal_pinjam, kode_barang, is_deleted) VALUES (?, ?, ?, ?, ?, 'n')";
        jdbcTemplate.update(sql, peminjam.getNama_peminjam(), peminjam.getNip_peminjam(), peminjam.getDomisili_peminjam(),
        peminjam.getTanggal_pinjam(), peminjam.getKode_barang());
        return "redirect:/home";
    }

    @GetMapping("/addbarang")
    public String addbarang(Model model) {
        return "addbarang";
    }

    @RequestMapping(value ="/addbarang", method = RequestMethod.POST)
    public String addbarang(barang barang) {
        String sql = "INSERT INTO BARANG (kode_barang, tanggal_beli, nama_barang, kondisi_barang, id_pj, is_deleted) VALUES (?, ?, ?, ?, ?, 'n')";
        jdbcTemplate.update(sql, barang.getKode_barang(), barang.getTanggal_beli(), barang.getNama_barang(), barang.getKondisi_barang(), barang.getId_pj());
        return "redirect:/info";
    }

    @GetMapping("/addpj")
    public String addpj(Model model) {
        return "addpj";
    }

    @RequestMapping(value ="/addpj", method = RequestMethod.POST)
    public String addpj(pjbarang pj) {
        String sql = "INSERT INTO PJ_BARANG (id_pj, nama_pj, nip_pj, is_deleted) VALUES (?, ?, ?,'n')";
        jdbcTemplate.update(sql, pj.getId_pj(), pj.getNama_pj(), pj.getNip_pj());
        return "redirect:/info";
    }

    @GetMapping("/editpeminjaman/{nip_peminjam}")
    public String edit(@PathVariable("nip_peminjam") String nip_peminjam, Model model) {
        String sql = "SELECT * FROM PEMINJAM WHERE NIP_PEMINJAM = ?";
        peminjam peminjam = jdbcTemplate.queryForObject(sql,
                BeanPropertyRowMapper.newInstance(peminjam.class), nip_peminjam);
        model.addAttribute("peminjam", peminjam);
        return "editpeminjaman";
    }

    @PostMapping("/editpeminjaman")
    public String editpeminjam(peminjam peminjam) {
        String sql = "UPDATE PEMINJAM SET NAMA_PEMINJAM = ?, NIP_PEMINJAM = ?, DOMISILI_PEMINJAM = ?, TANGGAL_PINJAM = ? WHERE KODE_BARANG = ?";
        jdbcTemplate.update(sql, peminjam.getNama_peminjam(), peminjam.getNip_peminjam(), peminjam.getDomisili_peminjam(), peminjam.getTanggal_pinjam(), peminjam.getKode_barang());
        return "redirect:/info";
    }

    @GetMapping("/editpj/{id_pj}")
    public String editpj(@PathVariable("id_pj") String id_pj, Model model) {
        String sql = "SELECT * FROM PJ_BARANG WHERE ID_PJ = ?";
        pjbarang pj = jdbcTemplate.queryForObject(sql,
                BeanPropertyRowMapper.newInstance(pjbarang.class), id_pj);
        model.addAttribute("pj", pj);
        return "editpj";
    }

    @PostMapping("/editpj")
    public String editpj(pjbarang pjbarang) {
        String sql = "UPDATE PJ_BARANG SET NAMA_PJ = ?, NIP_PJ = ? WHERE ID_PJ = ?";
        jdbcTemplate.update(sql, pjbarang.getNama_pj(), pjbarang.getNip_pj(), pjbarang.getId_pj());
        return "redirect:/info";
    }

    @GetMapping("/deletepeminjam/{nip_peminjam}")
    public String deletepeminjam(@PathVariable("nip_peminjam") String nip_peminjam) {
        String sql = "DELETE PEMINJAM WHERE NIP_PEMINJAM = ?";
        jdbcTemplate.update(sql, nip_peminjam);
        return "redirect:/home";
    }



    @GetMapping("/harddeletepj/{id_pj}")
    public String harddeletepj(@PathVariable("id_pj") String id_pj) {
        String sql = "DELETE PJ_BARANG WHERE ID_PJ = ?";
        jdbcTemplate.update(sql, id_pj);
        return "redirect:/info";
    }
    
    
    @GetMapping("/trashpj")
    public String trashpj(Model model) {
        String sql = "SELECT * FROM PJ_BARANG WHERE IS_DELETED = 'y'";
        List<pjbarang> deletedList = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(pjbarang.class));
        model.addAttribute("deletedlist", deletedList);
        return "trashpj";
    }

    @GetMapping("/softdeletepj/{id_pj}")
    public String softdeletepj(@PathVariable("id_pj") String id_pj) {
        String sql = "UPDATE PJ_BARANG SET IS_DELETED = 'y' WHERE ID_PJ = ?";
        jdbcTemplate.update(sql, id_pj);
        return "redirect:/info";
    }

    @GetMapping("/restorepj/{id_pj}")
    public String restorepj(@PathVariable("id_pj") String id_pj) {
        String sql = "UPDATE PJ_BARANG SET IS_DELETED = 'n' WHERE ID_PJ = ?";
        jdbcTemplate.update(sql, id_pj);
        return "redirect:/info";
    }
    
    // @GetMapping("/indexdetail/{id_minat}")
    // public String indexdetails(@PathVariable("id_minat") String id_minat, Model model) {
    //     String sql = "SELECT * FROM ANGGOTA WHERE ID_MINAT=? AND DELETED='n'";
    //     List<peminjaman> detailList = jdbcTemplate.query(sql,
    //             BeanPropertyRowMapper.newInstance(peminjaman.class), id_minat);
    //     model.addAttribute("detaillist", detailList);
    //     return "indexdetail";
    // }

    // @GetMapping("/indexdetailadmin/{id_minat}")
    // public String indexdetailadmin(@PathVariable("id_minat") String id_minat, Model model) {
    //     String sql = "SELECT * FROM ANGGOTA WHERE ID_MINAT=?  AND DELETED='n'";
    //     List<peminjaman> detailList = jdbcTemplate.query(sql,
    //             BeanPropertyRowMapper.newInstance(peminjaman.class), id_minat);
    //     model.addAttribute("detaillist", detailList);
    //     return "indexdetailadmin";
    // }

    @RequestMapping("/searchid")
    public String hasilsearch(@PathParam("id_search") String id_search, Model model) {
        String sql = "SELECT * FROM PEMINJAMAN WHERE LOWER (NAMA_BARANG) LIKE CONCAT(CONCAT ('%', ?), '%')";
        List<peminjaman> detailSearch = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(peminjaman.class), id_search);
        model.addAttribute("detailsearch", detailSearch);
        return ("searchid");
    }

    // @RequestMapping("/searchidadmin")
    // public String hasilsearchadmin(@PathParam("id_search") String id_search, Model model) {
    //     String sql = "SELECT * FROM ANGGOTA WHERE LOWER (NAMA_ANGGOTA) LIKE CONCAT(CONCAT ('%', ?), '%')";
    //     List<peminjaman> detailSearch = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(peminjaman.class), id_search);
    //     model.addAttribute("detailsearch", detailSearch);
    //     return ("searchid");
    // }


}

