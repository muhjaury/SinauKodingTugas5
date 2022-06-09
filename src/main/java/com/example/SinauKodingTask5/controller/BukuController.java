package com.example.SinauKodingTask5.controller;

import com.example.SinauKodingTask5.entity.Buku;
import com.example.SinauKodingTask5.entity.dto.BukuDTO;
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
    public Response createBuku(@RequestBody BukuDTO buku){
        return new Response(bukuService.createBuku(buku), "Data berhasil ditambahkan", HttpStatus.OK);
    }

    //Read
    @GetMapping
    public Response findAllBuku(){
        return new Response(bukuService.findAllBuku(),"Data berhasil ditampilkan", bukuService.countByJudulContaining(null), HttpStatus.OK);
    }

    @GetMapping(value = "jp")
    public Response findByJudulContainingAndPenulisContaining(@RequestParam(value = "judul", required = false) String judul, @RequestParam(value = "penulis", required = false) String penulis){
        return new Response(bukuService.findByJudulContainingAndPenulisContaining(judul, penulis), "Data berhasil ditampilkan", bukuService.countByJudulContainingAndPenulisContaining(judul,penulis), HttpStatus.OK);
    }

//    Update
    @PutMapping(value = "{id}")
    public Response updateBukuById(@RequestBody BukuDTO buku, @PathVariable int id){
        return new Response(bukuService.updateBukuById(buku, id),"Data berhasil diubah",HttpStatus.OK);
    }

    //Delete
    @DeleteMapping(value = "{id}")
    public Response deleteBukuById(@PathVariable int id){
        if(bukuService.deleteBukuById(id)){
            return new Response(null,"Data berhasil dihapus",HttpStatus.OK);
        }else{
            return new Response(null,"Data gagal dihapus",HttpStatus.OK);
        }
    }
}
