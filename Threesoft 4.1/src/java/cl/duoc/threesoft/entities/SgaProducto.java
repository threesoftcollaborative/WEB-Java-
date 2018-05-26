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
@Table(name = "SGA_PRODUCTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SgaProducto.findAll", query = "SELECT s FROM SgaProducto s")
    , @NamedQuery(name = "SgaProducto.findByIdProducto", query = "SELECT s FROM SgaProducto s WHERE s.idProducto = :idProducto")
    , @NamedQuery(name = "SgaProducto.findByNombre", query = "SELECT s FROM SgaProducto s WHERE s.nombre = :nombre")
    , @NamedQuery(name = "SgaProducto.findByPrecioCompra", query = "SELECT s FROM SgaProducto s WHERE s.precioCompra = :precioCompra")
    , @NamedQuery(name = "SgaProducto.findByPrecioVenta", query = "SELECT s FROM SgaProducto s WHERE s.precioVenta = :precioVenta")
    , @NamedQuery(name = "SgaProducto.findByStock", query = "SELECT s FROM SgaProducto s WHERE s.stock = :stock")
    , @NamedQuery(name = "SgaProducto.findByEstado", query = "SELECT s FROM SgaProducto s WHERE s.estado = :estado")})
public class SgaProducto implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PRODUCTO")
    private BigDecimal idProducto;
    @Size(max = 50)
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "PRECIO_COMPRA")
    private BigInteger precioCompra;
    @Column(name = "PRECIO_VENTA")
    private BigInteger precioVenta;
    @Column(name = "STOCK")
    private BigInteger stock;
    @Column(name = "ESTADO")
    private Character estado;
    @OneToMany(mappedBy = "idProducto")
    private List<SgaDetalleProducto> sgaDetalleProductoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProducto")
    private List<SgaDetalleOrdenCompra> sgaDetalleOrdenCompraList;
    @JoinColumn(name = "ID_MARCA", referencedColumnName = "ID_MARCA")
    @ManyToOne(optional = false)
    private SgaMarca idMarca;

    public SgaProducto() {
    }

    public SgaProducto(BigDecimal idProducto) {
        this.idProducto = idProducto;
    }

    public BigDecimal getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(BigDecimal idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigInteger getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(BigInteger precioCompra) {
        this.precioCompra = precioCompra;
    }

    public BigInteger getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(BigInteger precioVenta) {
        this.precioVenta = precioVenta;
    }

    public BigInteger getStock() {
        return stock;
    }

    public void setStock(BigInteger stock) {
        this.stock = stock;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    @XmlTransient
    public List<SgaDetalleProducto> getSgaDetalleProductoList() {
        return sgaDetalleProductoList;
    }

    public void setSgaDetalleProductoList(List<SgaDetalleProducto> sgaDetalleProductoList) {
        this.sgaDetalleProductoList = sgaDetalleProductoList;
    }

    @XmlTransient
    public List<SgaDetalleOrdenCompra> getSgaDetalleOrdenCompraList() {
        return sgaDetalleOrdenCompraList;
    }

    public void setSgaDetalleOrdenCompraList(List<SgaDetalleOrdenCompra> sgaDetalleOrdenCompraList) {
        this.sgaDetalleOrdenCompraList = sgaDetalleOrdenCompraList;
    }

    public SgaMarca getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(SgaMarca idMarca) {
        this.idMarca = idMarca;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProducto != null ? idProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SgaProducto)) {
            return false;
        }
        SgaProducto other = (SgaProducto) object;
        if ((this.idProducto == null && other.idProducto != null) || (this.idProducto != null && !this.idProducto.equals(other.idProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.duoc.threesoft.entities.SgaProducto[ idProducto=" + idProducto + " ]";
    }
    
}
