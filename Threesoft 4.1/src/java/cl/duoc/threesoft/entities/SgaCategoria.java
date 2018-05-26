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
@Table(name = "SGA_CATEGORIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SgaCategoria.findAll", query = "SELECT s FROM SgaCategoria s")
    , @NamedQuery(name = "SgaCategoria.findByIdCategoria", query = "SELECT s FROM SgaCategoria s WHERE s.idCategoria = :idCategoria")
    , @NamedQuery(name = "SgaCategoria.findByDescripcion", query = "SELECT s FROM SgaCategoria s WHERE s.descripcion = :descripcion")
    , @NamedQuery(name = "SgaCategoria.findByEstado", query = "SELECT s FROM SgaCategoria s WHERE s.estado = :estado")})
public class SgaCategoria implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_CATEGORIA")
    private BigDecimal idCategoria;
    @Size(max = 50)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Column(name = "ESTADO")
    private Character estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCategoria")
    private List<SgaAlmacen> sgaAlmacenList;
    @OneToMany(mappedBy = "idCategoria")
    private List<SgaMarca> sgaMarcaList;

    public SgaCategoria() {
    }

    public SgaCategoria(BigDecimal idCategoria) {
        this.idCategoria = idCategoria;
    }

    public BigDecimal getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(BigDecimal idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    @XmlTransient
    public List<SgaAlmacen> getSgaAlmacenList() {
        return sgaAlmacenList;
    }

    public void setSgaAlmacenList(List<SgaAlmacen> sgaAlmacenList) {
        this.sgaAlmacenList = sgaAlmacenList;
    }

    @XmlTransient
    public List<SgaMarca> getSgaMarcaList() {
        return sgaMarcaList;
    }

    public void setSgaMarcaList(List<SgaMarca> sgaMarcaList) {
        this.sgaMarcaList = sgaMarcaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCategoria != null ? idCategoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SgaCategoria)) {
            return false;
        }
        SgaCategoria other = (SgaCategoria) object;
        if ((this.idCategoria == null && other.idCategoria != null) || (this.idCategoria != null && !this.idCategoria.equals(other.idCategoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.duoc.threesoft.entities.SgaCategoria[ idCategoria=" + idCategoria + " ]";
    }
    
}
