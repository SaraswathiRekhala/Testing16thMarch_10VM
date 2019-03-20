/*Copyright (c) 2019-2020 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.testing16thmarch_10vm.allscenariosdb;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * Many2oneC generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`MANY2ONE_C`")
public class Many2oneC implements Serializable {

    private Integer childId;
    private Short shortId;
    private Date dateCol;
    private One2manyP one2manyP;

    @Id
    @SequenceGenerator(name = "generator", sequenceName = "`BYTESEQ`" , allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    @Column(name = "`CHILD_ID`", nullable = false, scale = 0, precision = 10)
    public Integer getChildId() {
        return this.childId;
    }

    public void setChildId(Integer childId) {
        this.childId = childId;
    }

    @Column(name = "`SHORT_ID`", nullable = true, scale = 0, precision = 5)
    public Short getShortId() {
        return this.shortId;
    }

    public void setShortId(Short shortId) {
        this.shortId = shortId;
    }

    @Column(name = "`DATE_COL`", nullable = true)
    public Date getDateCol() {
        return this.dateCol;
    }

    public void setDateCol(Date dateCol) {
        this.dateCol = dateCol;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`SHORT_ID`", referencedColumnName = "`SHORT_ID`", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "`FK_MANY2ONE_C_TO_ONE2MAN5y0ID`"))
    @Fetch(FetchMode.JOIN)
    public One2manyP getOne2manyP() {
        return this.one2manyP;
    }

    public void setOne2manyP(One2manyP one2manyP) {
        if(one2manyP != null) {
            this.shortId = one2manyP.getShortId();
        }

        this.one2manyP = one2manyP;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Many2oneC)) return false;
        final Many2oneC many2oneC = (Many2oneC) o;
        return Objects.equals(getChildId(), many2oneC.getChildId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getChildId());
    }
}