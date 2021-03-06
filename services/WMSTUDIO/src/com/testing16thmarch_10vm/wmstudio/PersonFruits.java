/*Copyright (c) 2019-2020 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.testing16thmarch_10vm.wmstudio;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * PersonFruits generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`PERSON_FRUITS`")
@IdClass(PersonFruitsId.class)
public class PersonFruits implements Serializable {

    private Integer fid;
    private Integer pid;

    @Id
    @Column(name = "`F_ID`", nullable = false, scale = 0, precision = 10)
    public Integer getFid() {
        return this.fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    @Id
    @Column(name = "`P_ID`", nullable = false, scale = 0, precision = 10)
    public Integer getPid() {
        return this.pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersonFruits)) return false;
        final PersonFruits personFruits = (PersonFruits) o;
        return Objects.equals(getFid(), personFruits.getFid()) &&
                Objects.equals(getPid(), personFruits.getPid());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFid(),
                getPid());
    }
}