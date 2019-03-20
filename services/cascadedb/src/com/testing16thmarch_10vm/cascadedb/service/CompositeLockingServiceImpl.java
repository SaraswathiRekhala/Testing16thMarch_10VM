/*Copyright (c) 2019-2020 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.testing16thmarch_10vm.cascadedb.service;

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

import com.testing16thmarch_10vm.cascadedb.CompositeLocking;
import com.testing16thmarch_10vm.cascadedb.CompositeLockingId;


/**
 * ServiceImpl object for domain model class CompositeLocking.
 *
 * @see CompositeLocking
 */
@Service("cascadedb.CompositeLockingService")
@Validated
public class CompositeLockingServiceImpl implements CompositeLockingService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CompositeLockingServiceImpl.class);


    @Autowired
    @Qualifier("cascadedb.CompositeLockingDao")
    private WMGenericDao<CompositeLocking, CompositeLockingId> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<CompositeLocking, CompositeLockingId> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "cascadedbTransactionManager")
    @Override
    public CompositeLocking create(CompositeLocking compositeLocking) {
        LOGGER.debug("Creating a new CompositeLocking with information: {}", compositeLocking);

        CompositeLocking compositeLockingCreated = this.wmGenericDao.create(compositeLocking);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(compositeLockingCreated);
    }

    @Transactional(readOnly = true, value = "cascadedbTransactionManager")
    @Override
    public CompositeLocking getById(CompositeLockingId compositelockingId) {
        LOGGER.debug("Finding CompositeLocking by id: {}", compositelockingId);
        return this.wmGenericDao.findById(compositelockingId);
    }

    @Transactional(readOnly = true, value = "cascadedbTransactionManager")
    @Override
    public CompositeLocking findById(CompositeLockingId compositelockingId) {
        LOGGER.debug("Finding CompositeLocking by id: {}", compositelockingId);
        try {
            return this.wmGenericDao.findById(compositelockingId);
        } catch (EntityNotFoundException ex) {
            LOGGER.debug("No CompositeLocking found with id: {}", compositelockingId, ex);
            return null;
        }
    }

    @Transactional(readOnly = true, value = "cascadedbTransactionManager")
    @Override
    public List<CompositeLocking> findByMultipleIds(List<CompositeLockingId> compositelockingIds, boolean orderedReturn) {
        LOGGER.debug("Finding CompositeLockings by ids: {}", compositelockingIds);

        return this.wmGenericDao.findByMultipleIds(compositelockingIds, orderedReturn);
    }


    @Transactional(rollbackFor = EntityNotFoundException.class, value = "cascadedbTransactionManager")
    @Override
    public CompositeLocking update(CompositeLocking compositeLocking) {
        LOGGER.debug("Updating CompositeLocking with information: {}", compositeLocking);

        this.wmGenericDao.update(compositeLocking);
        this.wmGenericDao.refresh(compositeLocking);

        return compositeLocking;
    }

    @Transactional(value = "cascadedbTransactionManager")
    @Override
    public CompositeLocking delete(CompositeLockingId compositelockingId) {
        LOGGER.debug("Deleting CompositeLocking with id: {}", compositelockingId);
        CompositeLocking deleted = this.wmGenericDao.findById(compositelockingId);
        if (deleted == null) {
            LOGGER.debug("No CompositeLocking found with id: {}", compositelockingId);
            throw new EntityNotFoundException(MessageResource.create("com.wavemaker.runtime.entity.not.found"), CompositeLocking.class.getSimpleName(), compositelockingId);
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "cascadedbTransactionManager")
    @Override
    public void delete(CompositeLocking compositeLocking) {
        LOGGER.debug("Deleting CompositeLocking with {}", compositeLocking);
        this.wmGenericDao.delete(compositeLocking);
    }

    @Transactional(readOnly = true, value = "cascadedbTransactionManager")
    @Override
    public Page<CompositeLocking> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all CompositeLockings");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "cascadedbTransactionManager")
    @Override
    public Page<CompositeLocking> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all CompositeLockings");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "cascadedbTransactionManager", timeout = 300)
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service cascadedb for table CompositeLocking to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

    @Transactional(readOnly = true, value = "cascadedbTransactionManager", timeout = 300)
    @Override
    public void export(DataExportOptions options, Pageable pageable, OutputStream outputStream) {
        LOGGER.debug("exporting data in the service cascadedb for table CompositeLocking to {} format", options.getExportType());
        this.wmGenericDao.export(options, pageable, outputStream);
    }

    @Transactional(readOnly = true, value = "cascadedbTransactionManager")
    @Override
    public long count(String query) {
        return this.wmGenericDao.count(query);
    }

    @Transactional(readOnly = true, value = "cascadedbTransactionManager")
    @Override
    public Page<Map<String, Object>> getAggregatedValues(AggregationInfo aggregationInfo, Pageable pageable) {
        return this.wmGenericDao.getAggregatedValues(aggregationInfo, pageable);
    }



}