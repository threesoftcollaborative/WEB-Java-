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
@Table(name = "SGA_PERFIL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SgaPerfil.findAll", query = "SELECT s FROM SgaPerfil s")
    , @NamedQuery(name = "SgaPerfil.findByIdPerfil", query = "SELECT s FROM SgaPerfil s WHERE s.idPerfil = :idPerfil")
    , @NamedQuery(name = "SgaPerfil.findByDescripcion", query = "SELECT s FROM SgaPerfil s WHERE s.descripcion = :descripcion")
    , @NamedQuery(name = "SgaPerfil.findByEstado", query = "SELECT s FROM SgaPerfil s WHERE s.estado = :estado")})
public class SgaPerfil implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PERFIL")
    private BigDecimal idPerfil;
    @Size(max = 50)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Column(name = "ESTADO")
    private Character estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPerfil")
    private List<SgaUsuario> sgaUsuarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPerfil")
    private List<SgaMenu> sgaMenuList;

    public SgaPerfil() {
    }

    public SgaPerfil(BigDecimal idPerfil) {
        this.idPerfil = idPerfil;
    }

    public BigDecimal getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(BigDecimal idPerfil) {
        this.idPerfil = idPerfil;
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
    public List<SgaUsuario> getSgaUsuarioList() {
        return sgaUsuarioList;
    }

    public void setSgaUsuarioList(List<SgaUsuario> sgaUsuarioList) {
        this.sgaUsuarioList = sgaUsuarioList;
    }

    @XmlTransient
    public List<SgaMenu> getSgaMenuList() {
        return sgaMenuList;
    }

    public void setSgaMenuList(List<SgaMenu> sgaMenuList) {
        this.sgaMenuList = sgaMenuList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPerfil != null ? idPerfil.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SgaPerfil)) {
            return false;
        }
        SgaPerfil other = (SgaPerfil) object;
        if ((this.idPerfil == null && other.idPerfil != null) || (this.idPerfil != null && !this.idPerfil.equals(other.idPerfil))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.duoc.threesoft.entities.SgaPerfil[ idPerfil=" + idPerfil + " ]";
    }
    
}
