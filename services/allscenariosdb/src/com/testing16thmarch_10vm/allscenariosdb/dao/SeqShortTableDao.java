/*Copyright (c) 2019-2020 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.testing16thmarch_10vm.allscenariosdb.dao;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.wavemaker.runtime.data.dao.WMGenericDaoImpl;
import com.wavemaker.runtime.data.dao.query.types.wmql.WMQLTypeHelper;

import com.testing16thmarch_10vm.allscenariosdb.SeqShortTable;

/**
 * Specifies methods used to obtain and modify SeqShortTable related information
 * which is stored in the database.
 */
@Repository("allscenariosdb.SeqShortTableDao")
public class SeqShortTableDao extends WMGenericDaoImpl<SeqShortTable, Short> {

    @Autowired
    @Qualifier("allscenariosdbTemplate")
    private HibernateTemplate template;

    @Autowired
    @Qualifier("allscenariosdbWMQLTypeHelper")
    private WMQLTypeHelper wmqlTypeHelper;


    @Override
    public HibernateTemplate getTemplate() {
        return this.template;
    }

    @Override
    public WMQLTypeHelper getWMQLTypeHelper() {
        return this.wmqlTypeHelper;
    }

}