/*Copyright (c) 2019-2020 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.testing16thmarch_10vm.cascadedb.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.DataExportOptions;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.model.Downloadable;

import com.testing16thmarch_10vm.cascadedb.CompositeLocking;
import com.testing16thmarch_10vm.cascadedb.CompositeLockingId;

/**
 * Service object for domain model class {@link CompositeLocking}.
 */
public interface CompositeLockingService {

    /**
     * Creates a new CompositeLocking. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on CompositeLocking if any.
     *
     * @param compositeLocking Details of the CompositeLocking to be created; value cannot be null.
     * @return The newly created CompositeLocking.
     */
    CompositeLocking create(@Valid CompositeLocking compositeLocking);


	/**
     * Returns CompositeLocking by given id if exists.
     *
     * @param compositelockingId The id of the CompositeLocking to get; value cannot be null.
     * @return CompositeLocking associated with the given compositelockingId.
	 * @throws EntityNotFoundException If no CompositeLocking is found.
     */
    CompositeLocking getById(CompositeLockingId compositelockingId);

    /**
     * Find and return the CompositeLocking by given id if exists, returns null otherwise.
     *
     * @param compositelockingId The id of the CompositeLocking to get; value cannot be null.
     * @return CompositeLocking associated with the given compositelockingId.
     */
    CompositeLocking findById(CompositeLockingId compositelockingId);

	/**
     * Find and return the list of CompositeLockings by given id's.
     *
     * If orderedReturn true, the return List is ordered and positional relative to the incoming ids.
     *
     * In case of unknown entities:
     *
     * If enabled, A null is inserted into the List at the proper position(s).
     * If disabled, the nulls are not put into the return List.
     *
     * @param compositelockingIds The id's of the CompositeLocking to get; value cannot be null.
     * @param orderedReturn Should the return List be ordered and positional in relation to the incoming ids?
     * @return CompositeLockings associated with the given compositelockingIds.
     */
    List<CompositeLocking> findByMultipleIds(List<CompositeLockingId> compositelockingIds, boolean orderedReturn);


    /**
     * Updates the details of an existing CompositeLocking. It replaces all fields of the existing CompositeLocking with the given compositeLocking.
     *
     * This method overrides the input field values using Server side or database managed properties defined on CompositeLocking if any.
     *
     * @param compositeLocking The details of the CompositeLocking to be updated; value cannot be null.
     * @return The updated CompositeLocking.
     * @throws EntityNotFoundException if no CompositeLocking is found with given input.
     */
    CompositeLocking update(@Valid CompositeLocking compositeLocking);

    /**
     * Deletes an existing CompositeLocking with the given id.
     *
     * @param compositelockingId The id of the CompositeLocking to be deleted; value cannot be null.
     * @return The deleted CompositeLocking.
     * @throws EntityNotFoundException if no CompositeLocking found with the given id.
     */
    CompositeLocking delete(CompositeLockingId compositelockingId);

    /**
     * Deletes an existing CompositeLocking with the given object.
     *
     * @param compositeLocking The instance of the CompositeLocking to be deleted; value cannot be null.
     */
    void delete(CompositeLocking compositeLocking);

    /**
     * Find all CompositeLockings matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
     *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
     *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching CompositeLockings.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
     */
    @Deprecated
    Page<CompositeLocking> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
     * Find all CompositeLockings matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching CompositeLockings.
     *
     * @see Pageable
     * @see Page
     */
    Page<CompositeLocking> findAll(String query, Pageable pageable);

    /**
     * Exports all CompositeLockings matching the given input query to the given exportType format.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param exportType The format in which to export the data; value cannot be null.
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null exports all matching records.
     * @return The Downloadable file in given export type.
     *
     * @see Pageable
     * @see ExportType
     * @see Downloadable
     */
    Downloadable export(ExportType exportType, String query, Pageable pageable);

    /**
     * Exports all CompositeLockings matching the given input query to the given exportType format.
     *
     * @param options The export options provided by the user; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null exports all matching records.
     * @param outputStream The output stream of the file for the exported data to be written to.
     *
     * @see DataExportOptions
     * @see Pageable
     * @see OutputStream
     */
    void export(DataExportOptions options, Pageable pageable, OutputStream outputStream);

    /**
     * Retrieve the count of the CompositeLockings in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
     * @return The count of the CompositeLocking.
     */
    long count(String query);

    /**
     * Retrieve aggregated values with matching aggregation info.
     *
     * @param aggregationInfo info related to aggregations.
     * @param pageable Details of the pagination information along with the sorting options. If null exports all matching records.
     * @return Paginated data with included fields.
     *
     * @see AggregationInfo
     * @see Pageable
     * @see Page
	 */
    Page<Map<String, Object>> getAggregatedValues(AggregationInfo aggregationInfo, Pageable pageable);


}