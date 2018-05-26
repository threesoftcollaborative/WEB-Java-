/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.threesoft.entities;

import java.io.Serializable;
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
@Table(name = "SGA_DETALLE_PRODUCTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SgaDetalleProducto.findAll", query = "SELECT s FROM SgaDetalleProducto s")
    , @NamedQuery(name = "SgaDetalleProducto.findByCodBarra", query = "SELECT s FROM SgaDetalleProducto s WHERE s.codBarra = :codBarra")
    , @NamedQuery(name = "SgaDetalleProducto.findByFechaCaducidad", query = "SELECT s FROM SgaDetalleProducto s WHERE s.fechaCaducidad = :fechaCaducidad")
    , @NamedQuery(name = "SgaDetalleProducto.findByEstado", query = "SELECT s FROM SgaDetalleProducto s WHERE s.estado = :estado")})
public class SgaDetalleProducto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "COD_BARRA")
    private String codBarra;
    @Column(name = "FECHA_CADUCIDAD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCaducidad;
    @Column(name = "ESTADO")
    private Character estado;
    @JoinColumn(name = "ID_PRODUCTO", referencedColumnName = "ID_PRODUCTO")
    @ManyToOne
    private SgaProducto idProducto;
    @OneToMany(mappedBy = "codBarra")
    private List<SgaDetalleBoleta> sgaDetalleBoletaList;

    public SgaDetalleProducto() {
    }

    public SgaDetalleProducto(String codBarra) {
        this.codBarra = codBarra;
    }

    public String getCodBarra() {
        return codBarra;
    }

    public void setCodBarra(String codBarra) {
        this.codBarra = codBarra;
    }

    public Date getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(Date fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    public SgaProducto getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(SgaProducto idProducto) {
        this.idProducto = idProducto;
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
        hash += (codBarra != null ? codBarra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SgaDetalleProducto)) {
            return false;
        }
        SgaDetalleProducto other = (SgaDetalleProducto) object;
        if ((this.codBarra == null && other.codBarra != null) || (this.codBarra != null && !this.codBarra.equals(other.codBarra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.duoc.threesoft.entities.SgaDetalleProducto[ codBarra=" + codBarra + " ]";
    }
    
}
