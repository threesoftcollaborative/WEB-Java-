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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Max
 */
@Entity
@Table(name = "SGA_ORDEN_COMPRA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SgaOrdenCompra.findAll", query = "SELECT s FROM SgaOrdenCompra s")
    , @NamedQuery(name = "SgaOrdenCompra.findByIdOrdenCompra", query = "SELECT s FROM SgaOrdenCompra s WHERE s.idOrdenCompra = :idOrdenCompra")
    , @NamedQuery(name = "SgaOrdenCompra.findByFechaOrdenCompra", query = "SELECT s FROM SgaOrdenCompra s WHERE s.fechaOrdenCompra = :fechaOrdenCompra")
    , @NamedQuery(name = "SgaOrdenCompra.findByFechaRecepcion", query = "SELECT s FROM SgaOrdenCompra s WHERE s.fechaRecepcion = :fechaRecepcion")
    , @NamedQuery(name = "SgaOrdenCompra.findByTotal", query = "SELECT s FROM SgaOrdenCompra s WHERE s.total = :total")
    , @NamedQuery(name = "SgaOrdenCompra.findByEstado", query = "SELECT s FROM SgaOrdenCompra s WHERE s.estado = :estado")})
public class SgaOrdenCompra implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_ORDEN_COMPRA")
    private BigDecimal idOrdenCompra;
    @Column(name = "FECHA_ORDEN_COMPRA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaOrdenCompra;
    @Column(name = "FECHA_RECEPCION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRecepcion;
    @Column(name = "TOTAL")
    private BigInteger total;
    @Column(name = "ESTADO")
    private Character estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idOrdenCompra")
    private List<SgaDetalleOrdenCompra> sgaDetalleOrdenCompraList;
    @JoinColumn(name = "ID_ALMACEN", referencedColumnName = "ID_ALMACEN")
    @ManyToOne(optional = false)
    private SgaAlmacen idAlmacen;
    @JoinColumn(name = "ID_PROVEEDOR", referencedColumnName = "ID_PROVEEDOR")
    @ManyToOne
    private SgaProveedor idProveedor;
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID_USUARIO")
    @ManyToOne(optional = false)
    private SgaUsuario idUsuario;

    public SgaOrdenCompra() {
    }

    public SgaOrdenCompra(BigDecimal idOrdenCompra) {
        this.idOrdenCompra = idOrdenCompra;
    }

    public BigDecimal getIdOrdenCompra() {
        return idOrdenCompra;
    }

    public void setIdOrdenCompra(BigDecimal idOrdenCompra) {
        this.idOrdenCompra = idOrdenCompra;
    }

    public Date getFechaOrdenCompra() {
        return fechaOrdenCompra;
    }

    public void setFechaOrdenCompra(Date fechaOrdenCompra) {
        this.fechaOrdenCompra = fechaOrdenCompra;
    }

    public Date getFechaRecepcion() {
        return fechaRecepcion;
    }

    public void setFechaRecepcion(Date fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    public BigInteger getTotal() {
        return total;
    }

    public void setTotal(BigInteger total) {
        this.total = total;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    @XmlTransient
    public List<SgaDetalleOrdenCompra> getSgaDetalleOrdenCompraList() {
        return sgaDetalleOrdenCompraList;
    }

    public void setSgaDetalleOrdenCompraList(List<SgaDetalleOrdenCompra> sgaDetalleOrdenCompraList) {
        this.sgaDetalleOrdenCompraList = sgaDetalleOrdenCompraList;
    }

    public SgaAlmacen getIdAlmacen() {
        return idAlmacen;
    }

    public void setIdAlmacen(SgaAlmacen idAlmacen) {
        this.idAlmacen = idAlmacen;
    }

    public SgaProveedor getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(SgaProveedor idProveedor) {
        this.idProveedor = idProveedor;
    }

    public SgaUsuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(SgaUsuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrdenCompra != null ? idOrdenCompra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SgaOrdenCompra)) {
            return false;
        }
        SgaOrdenCompra other = (SgaOrdenCompra) object;
        if ((this.idOrdenCompra == null && other.idOrdenCompra != null) || (this.idOrdenCompra != null && !this.idOrdenCompra.equals(other.idOrdenCompra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.duoc.threesoft.entities.SgaOrdenCompra[ idOrdenCompra=" + idOrdenCompra + " ]";
    }
    
}
