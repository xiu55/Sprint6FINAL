package cl.awakelab.sprint6.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Fetch;

import java.util.List;

@Data
@Entity
@Table(name = "empleador")

public class Empleador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empleador")
    private int idEmpleador;
    @Column
    private int run;
    @Column
    private String nombre;
    @Column (name = "apellido_1")
    private String apellido1;
    @Column (name = "apellido_2")
    private String apellido2;
    @Column
    private String direccion;
    @Column
    private String email;

    //Relacion usuario
    //@Column (name = "id_usuario")
    //@ManyToOne(optional = false,cascade = CascadeType.ALL,fetch = FetchType.EAGER) //Quizas deba cambiar a  @ManyToOne(optional = false, fetch = FetchType.EAGER)
    //TODO: El @ManytoOne que esta arriba es el original, probe el que esta aca pero parece no funcionar REVISAR!!
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_usuario",nullable = false) //nombre hace refeceneria a la tabla que es FK
    private Usuario usuario;
    //private int idUsuario;

    @Column
    private long telefono;

    @ManyToMany(mappedBy = "listaEmpleadores")
    private List<Trabajador> listaTrabajadores;



}
