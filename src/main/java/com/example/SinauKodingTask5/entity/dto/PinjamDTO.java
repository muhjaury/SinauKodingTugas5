package com.example.SinauKodingTask5.entity.dto;

import com.example.SinauKodingTask5.entity.Anggota;
import com.example.SinauKodingTask5.entity.Buku;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PinjamDTO {

    private Anggota anggota;
    private Buku buku;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date tglPinjam;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date tglKembali;

}
