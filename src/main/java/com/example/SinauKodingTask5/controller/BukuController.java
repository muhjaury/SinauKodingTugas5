package com.example.SinauKodingTask5.controller;

import com.example.SinauKodingTask5.entity.Buku;
import com.example.SinauKodingTask5.service.BukuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/buku")
public class BukuController {
    @Autowired
    BukuService bukuService;


    //Create
    @PostMapping
    public Buku createBuku(@RequestBody Buku buku){
        return bukuService.createBuku(buku);
    }

    //Read
    @GetMapping
    public List<Buku> findAllBuku(){
        return bukuService.findAllBuku();
    }

    @GetMapping(value = "np")
    public List<Buku> findByNamaOrPenulisContaining(@RequestParam(value = "nama", required = false) String nama, @RequestParam(value = "penulis", required = false) String penulis){
        return bukuService.findByNamaOrPenulis(nama,penulis);
    }

    //Update
    @PutMapping(value = "{id}")
    public Buku updateBukuById(@RequestBody Buku buku, @PathVariable int id){
        return bukuService.updateBukuById(buku, id);
    }

    //Delete
    @DeleteMapping(value = "{id}")
    public Boolean deleteBukuById(@PathVariable int id){
        return bukuService.deleteBukuById(id);
    }
}
