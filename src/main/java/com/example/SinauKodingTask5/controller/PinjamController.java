package com.example.SinauKodingTask5.controller;

import com.example.SinauKodingTask5.entity.Anggota;
import com.example.SinauKodingTask5.entity.Pinjam;
import com.example.SinauKodingTask5.entity.dto.PinjamDTO;
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
    public Response createPinjam(@RequestBody PinjamDTO pinjam){
        return new Response(pinjamService.createPinjam(pinjam), "Data berhasil ditambahkan", HttpStatus.OK);
    }

    //Read
    @GetMapping
    public Response selectAllPinjam(){
        return new Response(pinjamService.selectAllPinjam(), "Data berhasil ditampilkan", pinjamService.countByIdContaining(null), HttpStatus.OK);
    }

    //Update
    @PutMapping("/{id}")
    public Response updatePinjamById(@RequestBody PinjamDTO param, @PathVariable int id){
        return new Response(pinjamService.updatePinjamById(param, id),"Data berhasil diubah", HttpStatus.OK);
    }

    //Delete
    @DeleteMapping("/{id}")
    public Response deletePinjamById(@PathVariable int id){
        if(pinjamService.deletePinjamById(id)) {
            return new Response(null,"Data berhasil dihapus", HttpStatus.OK);
        }else{
            return new Response(null,"Data gagal dihapus", HttpStatus.OK);
        }
    }
}
