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
@Table(name = "SGA_BOLETA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SgaBoleta.findAll", query = "SELECT s FROM SgaBoleta s")
    , @NamedQuery(name = "SgaBoleta.findByIdBoleta", query = "SELECT s FROM SgaBoleta s WHERE s.idBoleta = :idBoleta")
    , @NamedQuery(name = "SgaBoleta.findByFechaBoleta", query = "SELECT s FROM SgaBoleta s WHERE s.fechaBoleta = :fechaBoleta")
    , @NamedQuery(name = "SgaBoleta.findByTotal", query = "SELECT s FROM SgaBoleta s WHERE s.total = :total")
    , @NamedQuery(name = "SgaBoleta.findByEstado", query = "SELECT s FROM SgaBoleta s WHERE s.estado = :estado")})
public class SgaBoleta implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_BOLETA")
    private BigDecimal idBoleta;
    @Column(name = "FECHA_BOLETA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaBoleta;
    @Column(name = "TOTAL")
    private BigInteger total;
    @Column(name = "ESTADO")
    private Character estado;
    @JoinColumn(name = "ID_ALMACEN", referencedColumnName = "ID_ALMACEN")
    @ManyToOne(optional = false)
    private SgaAlmacen idAlmacen;
    @JoinColumn(name = "ID_CLIENTE", referencedColumnName = "ID_CLIENTE")
    @ManyToOne
    private SgaCliente idCliente;
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID_USUARIO")
    @ManyToOne(optional = false)
    private SgaUsuario idUsuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idBoleta")
    private List<SgaDetalleBoleta> sgaDetalleBoletaList;

    public SgaBoleta() {
    }

    public SgaBoleta(BigDecimal idBoleta) {
        this.idBoleta = idBoleta;
    }

    public BigDecimal getIdBoleta() {
        return idBoleta;
    }

    public void setIdBoleta(BigDecimal idBoleta) {
        this.idBoleta = idBoleta;
    }

    public Date getFechaBoleta() {
        return fechaBoleta;
    }

    public void setFechaBoleta(Date fechaBoleta) {
        this.fechaBoleta = fechaBoleta;
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

    public SgaAlmacen getIdAlmacen() {
        return idAlmacen;
    }

    public void setIdAlmacen(SgaAlmacen idAlmacen) {
        this.idAlmacen = idAlmacen;
    }

    public SgaCliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(SgaCliente idCliente) {
        this.idCliente = idCliente;
    }

    public SgaUsuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(SgaUsuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @XmlTransient
    public List<SgaDetalleBoleta> getSgaDetalleBoletaList() {
        return sgaDetalleBoletaList;
    }

    public void setSgaDetalleBoletaList(List<SgaDetalleBoleta> sgaDetalleBoletaList) {
        this.sgaDetalleBoletaList = sgaDetalleBoletaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBoleta != null ? idBoleta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SgaBoleta)) {
            return false;
        }
        SgaBoleta other = (SgaBoleta) object;
        if ((this.idBoleta == null && other.idBoleta != null) || (this.idBoleta != null && !this.idBoleta.equals(other.idBoleta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.duoc.threesoft.entities.SgaBoleta[ idBoleta=" + idBoleta + " ]";
    }
    
}
