package com.example.SinauKodingTask5.controller;

import com.example.SinauKodingTask5.entity.Anggota;
import com.example.SinauKodingTask5.entity.Pinjam;
import com.example.SinauKodingTask5.response.Response;
import com.example.SinauKodingTask5.service.PinjamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pinjam")
public class PinjamController {
    @Autowired
    PinjamService pinjamService;

    //Create
    @PostMapping
    public Pinjam createPinjam(@RequestBody Pinjam pinjam){
        return pinjamService.createPinjam(pinjam);
    }

    //Read
    @GetMapping
    public Response selectAllPinjam(){
        return new Response(pinjamService.selectAllPinjam(), "Data berhasil ditampilkan", HttpStatus.OK);
    }

    //Update
    @PutMapping("/{id}")
    public Pinjam updatePinjamById(@RequestBody Pinjam param, @PathVariable int id){
        return pinjamService.updatePinjamById(param, id);
    }

    //Delete
    @DeleteMapping("/{id}")
    public String deletePinjamById(@PathVariable int id){
        if(pinjamService.deletePinjamById(id)) {
            return "Data berhasil dihapus";
        }else{
            return "Data gagal dihapus";
        }
    }
}
