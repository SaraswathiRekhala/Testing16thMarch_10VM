/*Copyright (c) 2019-2020 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.testing16thmarch_10vm.allscenariosdb;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

/**
 * SeqShortTable generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`SEQ_SHORT_TABLE`")
public class SeqShortTable implements Serializable {

    private Short shortid;
    @JsonProperty(access = Access.READ_ONLY)
    private byte[] blobcol;
    private Date dateCol;
    private Time timeCol;

    @Id
    @Column(name = "`SHORTID`", nullable = false, scale = 0, precision = 5)
    public Short getShortid() {
        return this.shortid;
    }

    public void setShortid(Short shortid) {
        this.shortid = shortid;
    }

    @Column(name = "`BLOBCOL`", nullable = true)
    public byte[] getBlobcol() {
        return this.blobcol;
    }

    public void setBlobcol(byte[] blobcol) {
        this.blobcol = blobcol;
    }

    @Column(name = "`DATE_COL`", nullable = true)
    public Date getDateCol() {
        return this.dateCol;
    }

    public void setDateCol(Date dateCol) {
        this.dateCol = dateCol;
    }

    @Column(name = "`TIME_COL`", nullable = true)
    public Time getTimeCol() {
        return this.timeCol;
    }

    public void setTimeCol(Time timeCol) {
        this.timeCol = timeCol;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SeqShortTable)) return false;
        final SeqShortTable seqShortTable = (SeqShortTable) o;
        return Objects.equals(getShortid(), seqShortTable.getShortid());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getShortid());
    }
}