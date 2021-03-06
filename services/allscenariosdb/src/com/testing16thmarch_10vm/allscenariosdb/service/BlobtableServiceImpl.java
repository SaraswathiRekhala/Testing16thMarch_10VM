/*Copyright (c) 2019-2020 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.testing16thmarch_10vm.allscenariosdb.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.wavemaker.commons.MessageResource;
import com.wavemaker.runtime.data.dao.WMGenericDao;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.DataExportOptions;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.model.Downloadable;

import com.testing16thmarch_10vm.allscenariosdb.Blobtable;


/**
 * ServiceImpl object for domain model class Blobtable.
 *
 * @see Blobtable
 */
@Service("allscenariosdb.BlobtableService")
@Validated
public class BlobtableServiceImpl implements BlobtableService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BlobtableServiceImpl.class);


    @Autowired
    @Qualifier("allscenariosdb.BlobtableDao")
    private WMGenericDao<Blobtable, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Blobtable, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "allscenariosdbTransactionManager")
    @Override
    public Blobtable create(Blobtable blobtable) {
        LOGGER.debug("Creating a new Blobtable with information: {}", blobtable);

        Blobtable blobtableCreated = this.wmGenericDao.create(blobtable);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(blobtableCreated);
    }

    @Transactional(readOnly = true, value = "allscenariosdbTransactionManager")
    @Override
    public Blobtable getById(Integer blobtableId) {
        LOGGER.debug("Finding Blobtable by id: {}", blobtableId);
        return this.wmGenericDao.findById(blobtableId);
    }

    @Transactional(readOnly = true, value = "allscenariosdbTransactionManager")
    @Override
    public Blobtable findById(Integer blobtableId) {
        LOGGER.debug("Finding Blobtable by id: {}", blobtableId);
        try {
            return this.wmGenericDao.findById(blobtableId);
        } catch (EntityNotFoundException ex) {
            LOGGER.debug("No Blobtable found with id: {}", blobtableId, ex);
            return null;
        }
    }

    @Transactional(readOnly = true, value = "allscenariosdbTransactionManager")
    @Override
    public List<Blobtable> findByMultipleIds(List<Integer> blobtableIds, boolean orderedReturn) {
        LOGGER.debug("Finding Blobtables by ids: {}", blobtableIds);

        return this.wmGenericDao.findByMultipleIds(blobtableIds, orderedReturn);
    }


    @Transactional(rollbackFor = EntityNotFoundException.class, value = "allscenariosdbTransactionManager")
    @Override
    public Blobtable update(Blobtable blobtable) {
        LOGGER.debug("Updating Blobtable with information: {}", blobtable);

        this.wmGenericDao.update(blobtable);
        this.wmGenericDao.refresh(blobtable);

        return blobtable;
    }

    @Transactional(value = "allscenariosdbTransactionManager")
    @Override
    public Blobtable delete(Integer blobtableId) {
        LOGGER.debug("Deleting Blobtable with id: {}", blobtableId);
        Blobtable deleted = this.wmGenericDao.findById(blobtableId);
        if (deleted == null) {
            LOGGER.debug("No Blobtable found with id: {}", blobtableId);
            throw new EntityNotFoundException(MessageResource.create("com.wavemaker.runtime.entity.not.found"), Blobtable.class.getSimpleName(), blobtableId);
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "allscenariosdbTransactionManager")
    @Override
    public void delete(Blobtable blobtable) {
        LOGGER.debug("Deleting Blobtable with {}", blobtable);
        this.wmGenericDao.delete(blobtable);
    }

    @Transactional(readOnly = true, value = "allscenariosdbTransactionManager")
    @Override
    public Page<Blobtable> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Blobtables");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "allscenariosdbTransactionManager")
    @Override
    public Page<Blobtable> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Blobtables");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "allscenariosdbTransactionManager", timeout = 300)
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service allscenariosdb for table Blobtable to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

    @Transactional(readOnly = true, value = "allscenariosdbTransactionManager", timeout = 300)
    @Override
    public void export(DataExportOptions options, Pageable pageable, OutputStream outputStream) {
        LOGGER.debug("exporting data in the service allscenariosdb for table Blobtable to {} format", options.getExportType());
        this.wmGenericDao.export(options, pageable, outputStream);
    }

    @Transactional(readOnly = true, value = "allscenariosdbTransactionManager")
    @Override
    public long count(String query) {
        return this.wmGenericDao.count(query);
    }

    @Transactional(readOnly = true, value = "allscenariosdbTransactionManager")
    @Override
    public Page<Map<String, Object>> getAggregatedValues(AggregationInfo aggregationInfo, Pageable pageable) {
        return this.wmGenericDao.getAggregatedValues(aggregationInfo, pageable);
    }



}