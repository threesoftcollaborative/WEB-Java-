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
@Table(name = "SGA_MARCA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SgaMarca.findAll", query = "SELECT s FROM SgaMarca s")
    , @NamedQuery(name = "SgaMarca.findByIdMarca", query = "SELECT s FROM SgaMarca s WHERE s.idMarca = :idMarca")
    , @NamedQuery(name = "SgaMarca.findByMarca", query = "SELECT s FROM SgaMarca s WHERE s.marca = :marca")
    , @NamedQuery(name = "SgaMarca.findByEstado", query = "SELECT s FROM SgaMarca s WHERE s.estado = :estado")})
public class SgaMarca implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_MARCA")
    private BigDecimal idMarca;
    @Size(max = 50)
    @Column(name = "MARCA")
    private String marca;
    @Column(name = "ESTADO")
    private Character estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMarca")
    private List<SgaProducto> sgaProductoList;
    @JoinColumn(name = "ID_CATEGORIA", referencedColumnName = "ID_CATEGORIA")
    @ManyToOne
    private SgaCategoria idCategoria;
    @JoinColumn(name = "ID_PROVEEDOR", referencedColumnName = "ID_PROVEEDOR")
    @ManyToOne
    private SgaProveedor idProveedor;

    public SgaMarca() {
    }

    public SgaMarca(BigDecimal idMarca) {
        this.idMarca = idMarca;
    }

    public BigDecimal getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(BigDecimal idMarca) {
        this.idMarca = idMarca;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    @XmlTransient
    public List<SgaProducto> getSgaProductoList() {
        return sgaProductoList;
    }

    public void setSgaProductoList(List<SgaProducto> sgaProductoList) {
        this.sgaProductoList = sgaProductoList;
    }

    public SgaCategoria getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(SgaCategoria idCategoria) {
        this.idCategoria = idCategoria;
    }

    public SgaProveedor getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(SgaProveedor idProveedor) {
        this.idProveedor = idProveedor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMarca != null ? idMarca.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SgaMarca)) {
            return false;
        }
        SgaMarca other = (SgaMarca) object;
        if ((this.idMarca == null && other.idMarca != null) || (this.idMarca != null && !this.idMarca.equals(other.idMarca))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.duoc.threesoft.entities.SgaMarca[ idMarca=" + idMarca + " ]";
    }
    
}
