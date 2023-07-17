package cl.awakelab.sprint6.entity;

import jakarta.persistence.*;

import jakarta.persistence.*;
import lombok.Data;

@Data @Entity @Table(name = "liquidacion") //va con minusculas

public class Liquidacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_liquidacion", nullable = false)
    private long idLiquidacion;



    @ManyToOne(optional = false, cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "id_trabajador")
    private Trabajador trabajador;

    @Column
    private String periodo;
    @Column(name = "sueldo_imponible")
    private int sueldoImponible;
    @Column(name = "sueldo_liquido")
    private int sueldoLiquido;

    //@Column(name = "id_inst_salud") /TODO: Borrar despues
    @ManyToOne(optional = false, cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "id_inst_salud")
    private InstitucionSalud idInstSalud;

    @Column(name = "monto_inst_salud")
    private int montoInstSalud;

    //@Column(name = "id_inst_prevsional") //TODO: Borrar despues de confirmacion
    @ManyToOne(optional = false, cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "id_inst_prevision")
    private InstitucionPrevision idInstPrevision;


    @Column(name = "monto_inst_previsional")
    private int montoInstPrevisional;
    @Column(name = "total_descuento")
    private int totalDescuento;
    @Column(name = "total_haberes")
    private int totalHaberes;
    @Column
    private int anticipo;

}
