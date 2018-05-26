/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.threesoft.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Max
 */
@Entity
@Table(name = "SGA_PROVEEDOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SgaProveedor.findAll", query = "SELECT s FROM SgaProveedor s")
    , @NamedQuery(name = "SgaProveedor.findByIdProveedor", query = "SELECT s FROM SgaProveedor s WHERE s.idProveedor = :idProveedor")
    , @NamedQuery(name = "SgaProveedor.findByNombre", query = "SELECT s FROM SgaProveedor s WHERE s.nombre = :nombre")
    , @NamedQuery(name = "SgaProveedor.findByRut", query = "SELECT s FROM SgaProveedor s WHERE s.rut = :rut")
    , @NamedQuery(name = "SgaProveedor.findByFono", query = "SELECT s FROM SgaProveedor s WHERE s.fono = :fono")
    , @NamedQuery(name = "SgaProveedor.findByEmail", query = "SELECT s FROM SgaProveedor s WHERE s.email = :email")
    , @NamedQuery(name = "SgaProveedor.findByDireccion", query = "SELECT s FROM SgaProveedor s WHERE s.direccion = :direccion")
    , @NamedQuery(name = "SgaProveedor.findByEstado", query = "SELECT s FROM SgaProveedor s WHERE s.estado = :estado")})
public class SgaProveedor implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PROVEEDOR")
    private BigDecimal idProveedor;
    @Size(max = 50)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 10)
    @Column(name = "RUT")
    private String rut;
    @Column(name = "FONO")
    private BigInteger fono;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "EMAIL")
    private String email;
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
    @OneToMany(mappedBy = "idProveedor")
    private List<SgaMarca> sgaMarcaList;
    @OneToMany(mappedBy = "idProveedor")
    private List<SgaOrdenCompra> sgaOrdenCompraList;

    public SgaProveedor() {
    }

    public SgaProveedor(BigDecimal idProveedor) {
        this.idProveedor = idProveedor;
    }

    public BigDecimal getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(BigDecimal idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public BigInteger getFono() {
        return fono;
    }

    public void setFono(BigInteger fono) {
        this.fono = fono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
    public List<SgaMarca> getSgaMarcaList() {
        return sgaMarcaList;
    }

    public void setSgaMarcaList(List<SgaMarca> sgaMarcaList) {
        this.sgaMarcaList = sgaMarcaList;
    }

    @XmlTransient
    public List<SgaOrdenCompra> getSgaOrdenCompraList() {
        return sgaOrdenCompraList;
    }

    public void setSgaOrdenCompraList(List<SgaOrdenCompra> sgaOrdenCompraList) {
        this.sgaOrdenCompraList = sgaOrdenCompraList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProveedor != null ? idProveedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SgaProveedor)) {
            return false;
        }
        SgaProveedor other = (SgaProveedor) object;
        if ((this.idProveedor == null && other.idProveedor != null) || (this.idProveedor != null && !this.idProveedor.equals(other.idProveedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.duoc.threesoft.entities.SgaProveedor[ idProveedor=" + idProveedor + " ]";
    }
    
}
