package cn.edu.imut.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by di_dong on 2017/5/22.
 */
@Entity
@Table(name = "T_TYPE")
public class TypeEO implements Serializable{

    private final static long serialVersionUID =1L;

    @Id
    @Column(name="CATALOGNO")
    private Long catalogNo;//类型编号
    @Column(name = "NAME")
    private String name;//类型名称
    @Column(name = "PARENT")
    private Long parentNo;//父类型编号
    @Column(name = "TYPE_LEVEL")
    private Long level;//类型级别

    public Long getCatalogNo() {
        return catalogNo;
    }

    public void setCatalogNo(Long catalogNo) {
        this.catalogNo = catalogNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getParentNo() {
        return parentNo;
    }

    public void setParentNo(Long parentNo) {
        this.parentNo = parentNo;
    }

    public Long getLevel() {
        return level;
    }

    public void setLevel(Long level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Type{" +
                "catalogNo='" + catalogNo + '\'' +
                ", name='" + name + '\'' +
                ", parentNo='" + parentNo + '\'' +
                ", level='" + level + '\'' +
                '}';
    }
}
