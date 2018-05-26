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
@Table(name = "SGA_COMUNA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SgaComuna.findAll", query = "SELECT s FROM SgaComuna s")
    , @NamedQuery(name = "SgaComuna.findByIdComuna", query = "SELECT s FROM SgaComuna s WHERE s.idComuna = :idComuna")
    , @NamedQuery(name = "SgaComuna.findByComuna", query = "SELECT s FROM SgaComuna s WHERE s.comuna = :comuna")
    , @NamedQuery(name = "SgaComuna.findByEstado", query = "SELECT s FROM SgaComuna s WHERE s.estado = :estado")})
public class SgaComuna implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_COMUNA")
    private BigDecimal idComuna;
    @Size(max = 50)
    @Column(name = "COMUNA")
    private String comuna;
    @Column(name = "ESTADO")
    private Character estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idComuna")
    private List<SgaCliente> sgaClienteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idComuna")
    private List<SgaProveedor> sgaProveedorList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idComuna")
    private List<SgaAlmacen> sgaAlmacenList;

    public SgaComuna() {
    }

    public SgaComuna(BigDecimal idComuna) {
        this.idComuna = idComuna;
    }

    public BigDecimal getIdComuna() {
        return idComuna;
    }

    public void setIdComuna(BigDecimal idComuna) {
        this.idComuna = idComuna;
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
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
    public List<SgaAlmacen> getSgaAlmacenList() {
        return sgaAlmacenList;
    }

    public void setSgaAlmacenList(List<SgaAlmacen> sgaAlmacenList) {
        this.sgaAlmacenList = sgaAlmacenList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idComuna != null ? idComuna.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SgaComuna)) {
            return false;
        }
        SgaComuna other = (SgaComuna) object;
        if ((this.idComuna == null && other.idComuna != null) || (this.idComuna != null && !this.idComuna.equals(other.idComuna))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.duoc.threesoft.entities.SgaComuna[ idComuna=" + idComuna + " ]";
    }
    
}
