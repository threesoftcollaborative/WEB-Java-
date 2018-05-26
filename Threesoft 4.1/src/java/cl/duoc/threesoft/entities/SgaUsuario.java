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
@Table(name = "SGA_USUARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SgaUsuario.findAll", query = "SELECT s FROM SgaUsuario s")
    , @NamedQuery(name = "SgaUsuario.findByIdUsuario", query = "SELECT s FROM SgaUsuario s WHERE s.idUsuario = :idUsuario")
    , @NamedQuery(name = "SgaUsuario.findByUsuario", query = "SELECT s FROM SgaUsuario s WHERE s.usuario = :usuario")
    , @NamedQuery(name = "SgaUsuario.findByPass", query = "SELECT s FROM SgaUsuario s WHERE s.pass = :pass")
    , @NamedQuery(name = "SgaUsuario.findByEmail", query = "SELECT s FROM SgaUsuario s WHERE s.email = :email")
    , @NamedQuery(name = "SgaUsuario.findByEstado", query = "SELECT s FROM SgaUsuario s WHERE s.estado = :estado")})
public class SgaUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_USUARIO")
    private BigDecimal idUsuario;
    @Size(max = 50)
    @Column(name = "USUARIO")
    private String usuario;
    @Size(max = 1000)
    @Column(name = "PASS")
    private String pass;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "ESTADO")
    private Character estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    private List<SgaBoleta> sgaBoletaList;
    @JoinColumn(name = "ID_ALMACEN", referencedColumnName = "ID_ALMACEN")
    @ManyToOne(optional = false)
    private SgaAlmacen idAlmacen;
    @JoinColumn(name = "ID_PERFIL", referencedColumnName = "ID_PERFIL")
    @ManyToOne(optional = false)
    private SgaPerfil idPerfil;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    private List<SgaOrdenCompra> sgaOrdenCompraList;

    public SgaUsuario() {
    }

    public SgaUsuario(BigDecimal idUsuario) {
        this.idUsuario = idUsuario;
    }

    public BigDecimal getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(BigDecimal idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    @XmlTransient
    public List<SgaBoleta> getSgaBoletaList() {
        return sgaBoletaList;
    }

    public void setSgaBoletaList(List<SgaBoleta> sgaBoletaList) {
        this.sgaBoletaList = sgaBoletaList;
    }

    public SgaAlmacen getIdAlmacen() {
        return idAlmacen;
    }

    public void setIdAlmacen(SgaAlmacen idAlmacen) {
        this.idAlmacen = idAlmacen;
    }

    public SgaPerfil getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(SgaPerfil idPerfil) {
        this.idPerfil = idPerfil;
    }

    @XmlTransient
    public List<SgaOrdenCompra> getSgaOrdenCompraList() {
        return sgaOrdenCompraList;
    }

    public void setSgaOrdenCompraList(List<SgaOrdenCompra> sgaOrdenCompraList) {
        this.sgaOrdenCompraList = sgaOrdenCompraList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SgaUsuario)) {
            return false;
        }
        SgaUsuario other = (SgaUsuario) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.duoc.threesoft.entities.SgaUsuario[ idUsuario=" + idUsuario + " ]";
    }
    
}
