package cl.awakelab.sprint6.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "trabajador") //esto debe ir en minuscula o mayus?

public class Trabajador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_trabajador")
    private int idTrabajador;
    @Column
    private int run;
    @Column
    private String nombre;
    @Column (name = "apellido_1")
    private String apellido1;
    @Column (name = "apellido_2")
    private String apellido2;
    @Column
    private String email;
    //Relacion trabajador - inst. prevision
    @ManyToOne(optional = false, cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "id_inst_prevision")
    private InstitucionPrevision instPrevision;

    //Relacion trabajador - inst. salud
    @ManyToOne(optional = false, cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "id_inst_salud") //referencia hacia FK
    private InstitucionSalud instSalud;

    @Column
    private long telefono;

    //Relacion trabajador - liquidacion
    @OneToMany(mappedBy = "trabajador")
    private List<Liquidacion> liquidacionesTrabajador;

    @ManyToMany
    @JoinTable(name = "empl_trab",
            joinColumns = @JoinColumn(name = "id_empleador", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "id_trabajador", nullable = false))
    private List<Empleador> listaEmpleadores;




}
