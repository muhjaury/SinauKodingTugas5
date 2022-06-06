package com.example.SinauKodingTask5.controller;

import com.example.SinauKodingTask5.entity.Buku;
import com.example.SinauKodingTask5.response.Response;
import com.example.SinauKodingTask5.service.BukuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public Response findAllBuku(){
        return new Response(bukuService.findAllBuku(),"Data berhasil ditampilkan", HttpStatus.OK);
    }

    @GetMapping(value = "jp")
    public List<Buku> findByJudulContainingAndPenulisContaining(@RequestParam(value = "judul", required = false) String judul, @RequestParam(value = "penulis", required = false) String penulis){
        return bukuService.findByJudulContainingAndPenulisContaining(judul, penulis);
    }

    //Update
    @PutMapping(value = "{id}")
    public Buku updateBukuById(@RequestBody Buku buku, @PathVariable int id){
        return bukuService.updateBukuById(buku, id);
    }

    //Delete
    @DeleteMapping(value = "{id}")
    public String deleteBukuById(@PathVariable int id){
        if(bukuService.deleteBukuById(id)){
            return "Data berhasil dihapus";
        }else{
            return "Data gagal dihapus";
        }
    }
}
