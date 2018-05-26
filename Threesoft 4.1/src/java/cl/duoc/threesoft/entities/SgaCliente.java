/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.threesoft.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Max
 */
@Entity
@Table(name = "SGA_CLIENTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SgaCliente.findAll", query = "SELECT s FROM SgaCliente s")
    , @NamedQuery(name = "SgaCliente.findByIdCliente", query = "SELECT s FROM SgaCliente s WHERE s.idCliente = :idCliente")
    , @NamedQuery(name = "SgaCliente.findByRut", query = "SELECT s FROM SgaCliente s WHERE s.rut = :rut")
    , @NamedQuery(name = "SgaCliente.findByNombre", query = "SELECT s FROM SgaCliente s WHERE s.nombre = :nombre")
    , @NamedQuery(name = "SgaCliente.findByApellido", query = "SELECT s FROM SgaCliente s WHERE s.apellido = :apellido")
    , @NamedQuery(name = "SgaCliente.findByTelefono", query = "SELECT s FROM SgaCliente s WHERE s.telefono = :telefono")
    , @NamedQuery(name = "SgaCliente.findByEmail", query = "SELECT s FROM SgaCliente s WHERE s.email = :email")
    , @NamedQuery(name = "SgaCliente.findByFechaNacimiento", query = "SELECT s FROM SgaCliente s WHERE s.fechaNacimiento = :fechaNacimiento")
    , @NamedQuery(name = "SgaCliente.findByDireccion", query = "SELECT s FROM SgaCliente s WHERE s.direccion = :direccion")
    , @NamedQuery(name = "SgaCliente.findByEstado", query = "SELECT s FROM SgaCliente s WHERE s.estado = :estado")})
public class SgaCliente implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_CLIENTE")
    private BigDecimal idCliente;
    @Size(max = 10)
    @Column(name = "RUT")
    private String rut;
    @Size(max = 50)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 50)
    @Column(name = "APELLIDO")
    private String apellido;
    @Column(name = "TELEFONO")
    private BigInteger telefono;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "FECHA_NACIMIENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaNacimiento;
    @Size(max = 50)
    @Column(name = "DIRECCION")
    private String direccion;
    @Column(name = "ESTADO")
    private Character estado;
    @JoinColumn(name = "ID_ALMACEN", referencedColumnName = "ID_ALMACEN")
    @ManyToOne(optional = false)
    private SgaAlmacen idAlmacen;
    @JoinColumn(name = "ID_COMUNA", referencedColumnName = "ID_COMUNA")
    @ManyToOne(optional = false)
    private SgaComuna idComuna;
    @OneToMany(mappedBy = "idCliente")
    private List<SgaBoleta> sgaBoletaList;

    public SgaCliente() {
    }

    public SgaCliente(BigDecimal idCliente) {
        this.idCliente = idCliente;
    }

    public BigDecimal getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(BigDecimal idCliente) {
        this.idCliente = idCliente;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public BigInteger getTelefono() {
        return telefono;
    }

    public void setTelefono(BigInteger telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    public SgaAlmacen getIdAlmacen() {
        return idAlmacen;
    }

    public void setIdAlmacen(SgaAlmacen idAlmacen) {
        this.idAlmacen = idAlmacen;
    }

    public SgaComuna getIdComuna() {
        return idComuna;
    }

    public void setIdComuna(SgaComuna idComuna) {
        this.idComuna = idComuna;
    }

    @XmlTransient
    public List<SgaBoleta> getSgaBoletaList() {
        return sgaBoletaList;
    }

    public void setSgaBoletaList(List<SgaBoleta> sgaBoletaList) {
        this.sgaBoletaList = sgaBoletaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCliente != null ? idCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SgaCliente)) {
            return false;
        }
        SgaCliente other = (SgaCliente) object;
        if ((this.idCliente == null && other.idCliente != null) || (this.idCliente != null && !this.idCliente.equals(other.idCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.duoc.threesoft.entities.SgaCliente[ idCliente=" + idCliente + " ]";
    }
    
}
