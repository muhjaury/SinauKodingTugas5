package com.example.SinauKodingTask5.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "pinjam")
@Getter
@Setter
public class Pinjam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pinjam")
    private Integer idPinjam;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_anggota", nullable = false)
    private Anggota anggota;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_buku", nullable = false)
    private Buku buku;

    @Column(name = "tgl_pinjam")
    private Date tglPinjam;

    @Column(name = "tgl_kembali")
    private Date tglKembali;
}
