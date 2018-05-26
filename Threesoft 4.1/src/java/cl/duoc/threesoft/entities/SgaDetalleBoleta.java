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
@Table(name = "SGA_DETALLE_BOLETA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SgaDetalleBoleta.findAll", query = "SELECT s FROM SgaDetalleBoleta s")
    , @NamedQuery(name = "SgaDetalleBoleta.findByIdDetalleBoleta", query = "SELECT s FROM SgaDetalleBoleta s WHERE s.idDetalleBoleta = :idDetalleBoleta")
    , @NamedQuery(name = "SgaDetalleBoleta.findByPrecioVenta", query = "SELECT s FROM SgaDetalleBoleta s WHERE s.precioVenta = :precioVenta")})
public class SgaDetalleBoleta implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_DETALLE_BOLETA")
    private BigDecimal idDetalleBoleta;
    @Column(name = "PRECIO_VENTA")
    private BigInteger precioVenta;
    @JoinColumn(name = "ID_BOLETA", referencedColumnName = "ID_BOLETA")
    @ManyToOne(optional = false)
    private SgaBoleta idBoleta;
    @JoinColumn(name = "COD_BARRA", referencedColumnName = "COD_BARRA")
    @ManyToOne
    private SgaDetalleProducto codBarra;

    public SgaDetalleBoleta() {
    }

    public SgaDetalleBoleta(BigDecimal idDetalleBoleta) {
        this.idDetalleBoleta = idDetalleBoleta;
    }

    public BigDecimal getIdDetalleBoleta() {
        return idDetalleBoleta;
    }

    public void setIdDetalleBoleta(BigDecimal idDetalleBoleta) {
        this.idDetalleBoleta = idDetalleBoleta;
    }

    public BigInteger getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(BigInteger precioVenta) {
        this.precioVenta = precioVenta;
    }

    public SgaBoleta getIdBoleta() {
        return idBoleta;
    }

    public void setIdBoleta(SgaBoleta idBoleta) {
        this.idBoleta = idBoleta;
    }

    public SgaDetalleProducto getCodBarra() {
        return codBarra;
    }

    public void setCodBarra(SgaDetalleProducto codBarra) {
        this.codBarra = codBarra;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalleBoleta != null ? idDetalleBoleta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SgaDetalleBoleta)) {
            return false;
        }
        SgaDetalleBoleta other = (SgaDetalleBoleta) object;
        if ((this.idDetalleBoleta == null && other.idDetalleBoleta != null) || (this.idDetalleBoleta != null && !this.idDetalleBoleta.equals(other.idDetalleBoleta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.duoc.threesoft.entities.SgaDetalleBoleta[ idDetalleBoleta=" + idDetalleBoleta + " ]";
    }
    
}
