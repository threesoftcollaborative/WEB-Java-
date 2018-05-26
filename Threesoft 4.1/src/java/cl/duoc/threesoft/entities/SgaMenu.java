/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.threesoft.entities;

import java.io.Serializable;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Max
 */
@Entity
@Table(name = "SGA_MENU")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SgaMenu.findAll", query = "SELECT s FROM SgaMenu s")
    , @NamedQuery(name = "SgaMenu.findByIdMenu", query = "SELECT s FROM SgaMenu s WHERE s.idMenu = :idMenu")
    , @NamedQuery(name = "SgaMenu.findByDescripcion", query = "SELECT s FROM SgaMenu s WHERE s.descripcion = :descripcion")
    , @NamedQuery(name = "SgaMenu.findByPadreMenu", query = "SELECT s FROM SgaMenu s WHERE s.padreMenu = :padreMenu")
    , @NamedQuery(name = "SgaMenu.findByDestino", query = "SELECT s FROM SgaMenu s WHERE s.destino = :destino")
    , @NamedQuery(name = "SgaMenu.findByEstado", query = "SELECT s FROM SgaMenu s WHERE s.estado = :estado")})
public class SgaMenu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_MENU")
    private Long idMenu;
    @Size(max = 1000)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Column(name = "PADRE_MENU")
    private Long padreMenu;
    @Size(max = 1000)
    @Column(name = "DESTINO")
    private String destino;
    @Column(name = "ESTADO")
    private Character estado;
    @JoinColumn(name = "ID_PERFIL", referencedColumnName = "ID_PERFIL")
    @ManyToOne(optional = false)
    private SgaPerfil idPerfil;

    public SgaMenu() {
    }

    public SgaMenu(Long idMenu) {
        this.idMenu = idMenu;
    }

    public Long getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(Long idMenu) {
        this.idMenu = idMenu;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getPadreMenu() {
        return padreMenu;
    }

    public void setPadreMenu(Long padreMenu) {
        this.padreMenu = padreMenu;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    public SgaPerfil getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(SgaPerfil idPerfil) {
        this.idPerfil = idPerfil;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMenu != null ? idMenu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SgaMenu)) {
            return false;
        }
        SgaMenu other = (SgaMenu) object;
        if ((this.idMenu == null && other.idMenu != null) || (this.idMenu != null && !this.idMenu.equals(other.idMenu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.duoc.threesoft.entities.SgaMenu[ idMenu=" + idMenu + " ]";
    }
    
}
