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

import com.testing16thmarch_10vm.allscenariosdb.SeqShortTable;


/**
 * ServiceImpl object for domain model class SeqShortTable.
 *
 * @see SeqShortTable
 */
@Service("allscenariosdb.SeqShortTableService")
@Validated
public class SeqShortTableServiceImpl implements SeqShortTableService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SeqShortTableServiceImpl.class);


    @Autowired
    @Qualifier("allscenariosdb.SeqShortTableDao")
    private WMGenericDao<SeqShortTable, Short> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<SeqShortTable, Short> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "allscenariosdbTransactionManager")
    @Override
    public SeqShortTable create(SeqShortTable seqShortTable) {
        LOGGER.debug("Creating a new SeqShortTable with information: {}", seqShortTable);

        SeqShortTable seqShortTableCreated = this.wmGenericDao.create(seqShortTable);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(seqShortTableCreated);
    }

    @Transactional(readOnly = true, value = "allscenariosdbTransactionManager")
    @Override
    public SeqShortTable getById(Short seqshorttableId) {
        LOGGER.debug("Finding SeqShortTable by id: {}", seqshorttableId);
        return this.wmGenericDao.findById(seqshorttableId);
    }

    @Transactional(readOnly = true, value = "allscenariosdbTransactionManager")
    @Override
    public SeqShortTable findById(Short seqshorttableId) {
        LOGGER.debug("Finding SeqShortTable by id: {}", seqshorttableId);
        try {
            return this.wmGenericDao.findById(seqshorttableId);
        } catch (EntityNotFoundException ex) {
            LOGGER.debug("No SeqShortTable found with id: {}", seqshorttableId, ex);
            return null;
        }
    }

    @Transactional(readOnly = true, value = "allscenariosdbTransactionManager")
    @Override
    public List<SeqShortTable> findByMultipleIds(List<Short> seqshorttableIds, boolean orderedReturn) {
        LOGGER.debug("Finding SeqShortTables by ids: {}", seqshorttableIds);

        return this.wmGenericDao.findByMultipleIds(seqshorttableIds, orderedReturn);
    }


    @Transactional(rollbackFor = EntityNotFoundException.class, value = "allscenariosdbTransactionManager")
    @Override
    public SeqShortTable update(SeqShortTable seqShortTable) {
        LOGGER.debug("Updating SeqShortTable with information: {}", seqShortTable);

        this.wmGenericDao.update(seqShortTable);
        this.wmGenericDao.refresh(seqShortTable);

        return seqShortTable;
    }

    @Transactional(value = "allscenariosdbTransactionManager")
    @Override
    public SeqShortTable delete(Short seqshorttableId) {
        LOGGER.debug("Deleting SeqShortTable with id: {}", seqshorttableId);
        SeqShortTable deleted = this.wmGenericDao.findById(seqshorttableId);
        if (deleted == null) {
            LOGGER.debug("No SeqShortTable found with id: {}", seqshorttableId);
            throw new EntityNotFoundException(MessageResource.create("com.wavemaker.runtime.entity.not.found"), SeqShortTable.class.getSimpleName(), seqshorttableId);
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "allscenariosdbTransactionManager")
    @Override
    public void delete(SeqShortTable seqShortTable) {
        LOGGER.debug("Deleting SeqShortTable with {}", seqShortTable);
        this.wmGenericDao.delete(seqShortTable);
    }

    @Transactional(readOnly = true, value = "allscenariosdbTransactionManager")
    @Override
    public Page<SeqShortTable> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all SeqShortTables");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "allscenariosdbTransactionManager")
    @Override
    public Page<SeqShortTable> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all SeqShortTables");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "allscenariosdbTransactionManager", timeout = 300)
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service allscenariosdb for table SeqShortTable to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

    @Transactional(readOnly = true, value = "allscenariosdbTransactionManager", timeout = 300)
    @Override
    public void export(DataExportOptions options, Pageable pageable, OutputStream outputStream) {
        LOGGER.debug("exporting data in the service allscenariosdb for table SeqShortTable to {} format", options.getExportType());
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