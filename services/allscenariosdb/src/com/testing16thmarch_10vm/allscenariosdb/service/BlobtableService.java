/*Copyright (c) 2019-2020 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.testing16thmarch_10vm.allscenariosdb.service;

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

import com.testing16thmarch_10vm.allscenariosdb.Blobtable;

/**
 * Service object for domain model class {@link Blobtable}.
 */
public interface BlobtableService {

    /**
     * Creates a new Blobtable. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on Blobtable if any.
     *
     * @param blobtable Details of the Blobtable to be created; value cannot be null.
     * @return The newly created Blobtable.
     */
    Blobtable create(@Valid Blobtable blobtable);


	/**
     * Returns Blobtable by given id if exists.
     *
     * @param blobtableId The id of the Blobtable to get; value cannot be null.
     * @return Blobtable associated with the given blobtableId.
	 * @throws EntityNotFoundException If no Blobtable is found.
     */
    Blobtable getById(Integer blobtableId);

    /**
     * Find and return the Blobtable by given id if exists, returns null otherwise.
     *
     * @param blobtableId The id of the Blobtable to get; value cannot be null.
     * @return Blobtable associated with the given blobtableId.
     */
    Blobtable findById(Integer blobtableId);

	/**
     * Find and return the list of Blobtables by given id's.
     *
     * If orderedReturn true, the return List is ordered and positional relative to the incoming ids.
     *
     * In case of unknown entities:
     *
     * If enabled, A null is inserted into the List at the proper position(s).
     * If disabled, the nulls are not put into the return List.
     *
     * @param blobtableIds The id's of the Blobtable to get; value cannot be null.
     * @param orderedReturn Should the return List be ordered and positional in relation to the incoming ids?
     * @return Blobtables associated with the given blobtableIds.
     */
    List<Blobtable> findByMultipleIds(List<Integer> blobtableIds, boolean orderedReturn);


    /**
     * Updates the details of an existing Blobtable. It replaces all fields of the existing Blobtable with the given blobtable.
     *
     * This method overrides the input field values using Server side or database managed properties defined on Blobtable if any.
     *
     * @param blobtable The details of the Blobtable to be updated; value cannot be null.
     * @return The updated Blobtable.
     * @throws EntityNotFoundException if no Blobtable is found with given input.
     */
    Blobtable update(@Valid Blobtable blobtable);

    /**
     * Deletes an existing Blobtable with the given id.
     *
     * @param blobtableId The id of the Blobtable to be deleted; value cannot be null.
     * @return The deleted Blobtable.
     * @throws EntityNotFoundException if no Blobtable found with the given id.
     */
    Blobtable delete(Integer blobtableId);

    /**
     * Deletes an existing Blobtable with the given object.
     *
     * @param blobtable The instance of the Blobtable to be deleted; value cannot be null.
     */
    void delete(Blobtable blobtable);

    /**
     * Find all Blobtables matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
     *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
     *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Blobtables.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
     */
    @Deprecated
    Page<Blobtable> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
     * Find all Blobtables matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Blobtables.
     *
     * @see Pageable
     * @see Page
     */
    Page<Blobtable> findAll(String query, Pageable pageable);

    /**
     * Exports all Blobtables matching the given input query to the given exportType format.
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
     * Exports all Blobtables matching the given input query to the given exportType format.
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
     * Retrieve the count of the Blobtables in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
     * @return The count of the Blobtable.
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