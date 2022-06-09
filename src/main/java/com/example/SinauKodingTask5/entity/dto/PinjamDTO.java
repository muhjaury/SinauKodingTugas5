package com.example.SinauKodingTask5.entity.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PinjamDTO {

    private String anggota;
    private String buku;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date tglPinjam;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date tglKembali;

}
