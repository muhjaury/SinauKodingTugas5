package com.example.SinauKodingTask5.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "buku")
@Setter
@Getter
public class Buku {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_buku")
    private Integer idBuku;

    @Column(name = "judul")
    private String judul;

    @Column(name = "penulis")
    private String penulis;

    @Column(name = "penerbit")
    private String penerbit;

    @Column(name = "tahun_terbit")
    private Date tahunTerbit;

    @Column(name = "jenis_buku")
    private String jenisBuku;

//    @OneToMany(mappedBy = "buku", fetch = FetchType.EAGER)
//    private List<Pinjam> pinjams = new ArrayList<>();
}
