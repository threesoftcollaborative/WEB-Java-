/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.threesoft.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "SGA_ALMACEN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SgaAlmacen.findAll", query = "SELECT s FROM SgaAlmacen s")
    , @NamedQuery(name = "SgaAlmacen.findByIdAlmacen", query = "SELECT s FROM SgaAlmacen s WHERE s.idAlmacen = :idAlmacen")
    , @NamedQuery(name = "SgaAlmacen.findByNombre", query = "SELECT s FROM SgaAlmacen s WHERE s.nombre = :nombre")
    , @NamedQuery(name = "SgaAlmacen.findByDireccion", query = "SELECT s FROM SgaAlmacen s WHERE s.direccion = :direccion")
    , @NamedQuery(name = "SgaAlmacen.findByEstado", query = "SELECT s FROM SgaAlmacen s WHERE s.estado = :estado")})
public class SgaAlmacen implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_ALMACEN")
    private BigDecimal idAlmacen;
    @Size(max = 50)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 50)
    @Column(name = "DIRECCION")
    private String direccion;
    @Column(name = "ESTADO")
    private Character estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAlmacen")
    private List<SgaCliente> sgaClienteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAlmacen")
    private List<SgaProveedor> sgaProveedorList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAlmacen")
    private List<SgaBoleta> sgaBoletaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAlmacen")
    private List<SgaUsuario> sgaUsuarioList;
    @JoinColumn(name = "ID_CATEGORIA", referencedColumnName = "ID_CATEGORIA")
    @ManyToOne(optional = false)
    private SgaCategoria idCategoria;
    @JoinColumn(name = "ID_COMUNA", referencedColumnName = "ID_COMUNA")
    @ManyToOne(optional = false)
    private SgaComuna idComuna;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAlmacen")
    private List<SgaOrdenCompra> sgaOrdenCompraList;

    public SgaAlmacen() {
    }

    public SgaAlmacen(BigDecimal idAlmacen) {
        this.idAlmacen = idAlmacen;
    }

    public BigDecimal getIdAlmacen() {
        return idAlmacen;
    }

    public void setIdAlmacen(BigDecimal idAlmacen) {
        this.idAlmacen = idAlmacen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    @XmlTransient
    public List<SgaCliente> getSgaClienteList() {
        return sgaClienteList;
    }

    public void setSgaClienteList(List<SgaCliente> sgaClienteList) {
        this.sgaClienteList = sgaClienteList;
    }

    @XmlTransient
    public List<SgaProveedor> getSgaProveedorList() {
        return sgaProveedorList;
    }

    public void setSgaProveedorList(List<SgaProveedor> sgaProveedorList) {
        this.sgaProveedorList = sgaProveedorList;
    }

    @XmlTransient
    public List<SgaBoleta> getSgaBoletaList() {
        return sgaBoletaList;
    }

    public void setSgaBoletaList(List<SgaBoleta> sgaBoletaList) {
        this.sgaBoletaList = sgaBoletaList;
    }

    @XmlTransient
    public List<SgaUsuario> getSgaUsuarioList() {
        return sgaUsuarioList;
    }

    public void setSgaUsuarioList(List<SgaUsuario> sgaUsuarioList) {
        this.sgaUsuarioList = sgaUsuarioList;
    }

    public SgaCategoria getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(SgaCategoria idCategoria) {
        this.idCategoria = idCategoria;
    }

    public SgaComuna getIdComuna() {
        return idComuna;
    }

    public void setIdComuna(SgaComuna idComuna) {
        this.idComuna = idComuna;
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
        hash += (idAlmacen != null ? idAlmacen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SgaAlmacen)) {
            return false;
        }
        SgaAlmacen other = (SgaAlmacen) object;
        if ((this.idAlmacen == null && other.idAlmacen != null) || (this.idAlmacen != null && !this.idAlmacen.equals(other.idAlmacen))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.duoc.threesoft.entities.SgaAlmacen[ idAlmacen=" + idAlmacen + " ]";
    }
    
}
