/*Copyright (c) 2019-2020 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.testing16thmarch_10vm.wmstudio.service;

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

import com.testing16thmarch_10vm.wmstudio.TimestampVersioning;


/**
 * ServiceImpl object for domain model class TimestampVersioning.
 *
 * @see TimestampVersioning
 */
@Service("WMSTUDIO.TimestampVersioningService")
@Validated
public class TimestampVersioningServiceImpl implements TimestampVersioningService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TimestampVersioningServiceImpl.class);


    @Autowired
    @Qualifier("WMSTUDIO.TimestampVersioningDao")
    private WMGenericDao<TimestampVersioning, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<TimestampVersioning, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "WMSTUDIOTransactionManager")
    @Override
    public TimestampVersioning create(TimestampVersioning timestampVersioning) {
        LOGGER.debug("Creating a new TimestampVersioning with information: {}", timestampVersioning);

        TimestampVersioning timestampVersioningCreated = this.wmGenericDao.create(timestampVersioning);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(timestampVersioningCreated);
    }

    @Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
    @Override
    public TimestampVersioning getById(Integer timestampversioningId) {
        LOGGER.debug("Finding TimestampVersioning by id: {}", timestampversioningId);
        return this.wmGenericDao.findById(timestampversioningId);
    }

    @Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
    @Override
    public TimestampVersioning findById(Integer timestampversioningId) {
        LOGGER.debug("Finding TimestampVersioning by id: {}", timestampversioningId);
        try {
            return this.wmGenericDao.findById(timestampversioningId);
        } catch (EntityNotFoundException ex) {
            LOGGER.debug("No TimestampVersioning found with id: {}", timestampversioningId, ex);
            return null;
        }
    }

    @Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
    @Override
    public List<TimestampVersioning> findByMultipleIds(List<Integer> timestampversioningIds, boolean orderedReturn) {
        LOGGER.debug("Finding TimestampVersionings by ids: {}", timestampversioningIds);

        return this.wmGenericDao.findByMultipleIds(timestampversioningIds, orderedReturn);
    }


    @Transactional(rollbackFor = EntityNotFoundException.class, value = "WMSTUDIOTransactionManager")
    @Override
    public TimestampVersioning update(TimestampVersioning timestampVersioning) {
        LOGGER.debug("Updating TimestampVersioning with information: {}", timestampVersioning);

        this.wmGenericDao.update(timestampVersioning);
        this.wmGenericDao.refresh(timestampVersioning);

        return timestampVersioning;
    }

    @Transactional(value = "WMSTUDIOTransactionManager")
    @Override
    public TimestampVersioning delete(Integer timestampversioningId) {
        LOGGER.debug("Deleting TimestampVersioning with id: {}", timestampversioningId);
        TimestampVersioning deleted = this.wmGenericDao.findById(timestampversioningId);
        if (deleted == null) {
            LOGGER.debug("No TimestampVersioning found with id: {}", timestampversioningId);
            throw new EntityNotFoundException(MessageResource.create("com.wavemaker.runtime.entity.not.found"), TimestampVersioning.class.getSimpleName(), timestampversioningId);
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "WMSTUDIOTransactionManager")
    @Override
    public void delete(TimestampVersioning timestampVersioning) {
        LOGGER.debug("Deleting TimestampVersioning with {}", timestampVersioning);
        this.wmGenericDao.delete(timestampVersioning);
    }

    @Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
    @Override
    public Page<TimestampVersioning> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all TimestampVersionings");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
    @Override
    public Page<TimestampVersioning> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all TimestampVersionings");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "WMSTUDIOTransactionManager", timeout = 300)
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service WMSTUDIO for table TimestampVersioning to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

    @Transactional(readOnly = true, value = "WMSTUDIOTransactionManager", timeout = 300)
    @Override
    public void export(DataExportOptions options, Pageable pageable, OutputStream outputStream) {
        LOGGER.debug("exporting data in the service WMSTUDIO for table TimestampVersioning to {} format", options.getExportType());
        this.wmGenericDao.export(options, pageable, outputStream);
    }

    @Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
    @Override
    public long count(String query) {
        return this.wmGenericDao.count(query);
    }

    @Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
    @Override
    public Page<Map<String, Object>> getAggregatedValues(AggregationInfo aggregationInfo, Pageable pageable) {
        return this.wmGenericDao.getAggregatedValues(aggregationInfo, pageable);
    }



}