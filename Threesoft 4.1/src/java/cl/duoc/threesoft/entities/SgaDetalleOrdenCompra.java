/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.threesoft.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Max
 */
@Entity
@Table(name = "SGA_DETALLE_ORDEN_COMPRA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SgaDetalleOrdenCompra.findAll", query = "SELECT s FROM SgaDetalleOrdenCompra s")
    , @NamedQuery(name = "SgaDetalleOrdenCompra.findByIdDetalleOrdenCompra", query = "SELECT s FROM SgaDetalleOrdenCompra s WHERE s.idDetalleOrdenCompra = :idDetalleOrdenCompra")
    , @NamedQuery(name = "SgaDetalleOrdenCompra.findByCantidad", query = "SELECT s FROM SgaDetalleOrdenCompra s WHERE s.cantidad = :cantidad")
    , @NamedQuery(name = "SgaDetalleOrdenCompra.findByPrecioCompra", query = "SELECT s FROM SgaDetalleOrdenCompra s WHERE s.precioCompra = :precioCompra")})
public class SgaDetalleOrdenCompra implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_DETALLE_ORDEN_COMPRA")
    private BigDecimal idDetalleOrdenCompra;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CANTIDAD")
    private BigInteger cantidad;
    @Column(name = "PRECIO_COMPRA")
    private BigInteger precioCompra;
    @JoinColumn(name = "ID_ORDEN_COMPRA", referencedColumnName = "ID_ORDEN_COMPRA")
    @ManyToOne(optional = false)
    private SgaOrdenCompra idOrdenCompra;
    @JoinColumn(name = "ID_PRODUCTO", referencedColumnName = "ID_PRODUCTO")
    @ManyToOne(optional = false)
    private SgaProducto idProducto;

    public SgaDetalleOrdenCompra() {
    }

    public SgaDetalleOrdenCompra(BigDecimal idDetalleOrdenCompra) {
        this.idDetalleOrdenCompra = idDetalleOrdenCompra;
    }

    public SgaDetalleOrdenCompra(BigDecimal idDetalleOrdenCompra, BigInteger cantidad) {
        this.idDetalleOrdenCompra = idDetalleOrdenCompra;
        this.cantidad = cantidad;
    }

    public BigDecimal getIdDetalleOrdenCompra() {
        return idDetalleOrdenCompra;
    }

    public void setIdDetalleOrdenCompra(BigDecimal idDetalleOrdenCompra) {
        this.idDetalleOrdenCompra = idDetalleOrdenCompra;
    }

    public BigInteger getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigInteger cantidad) {
        this.cantidad = cantidad;
    }

    public BigInteger getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(BigInteger precioCompra) {
        this.precioCompra = precioCompra;
    }

    public SgaOrdenCompra getIdOrdenCompra() {
        return idOrdenCompra;
    }

    public void setIdOrdenCompra(SgaOrdenCompra idOrdenCompra) {
        this.idOrdenCompra = idOrdenCompra;
    }

    public SgaProducto getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(SgaProducto idProducto) {
        this.idProducto = idProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalleOrdenCompra != null ? idDetalleOrdenCompra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SgaDetalleOrdenCompra)) {
            return false;
        }
        SgaDetalleOrdenCompra other = (SgaDetalleOrdenCompra) object;
        if ((this.idDetalleOrdenCompra == null && other.idDetalleOrdenCompra != null) || (this.idDetalleOrdenCompra != null && !this.idDetalleOrdenCompra.equals(other.idDetalleOrdenCompra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.duoc.threesoft.entities.SgaDetalleOrdenCompra[ idDetalleOrdenCompra=" + idDetalleOrdenCompra + " ]";
    }
    
}
