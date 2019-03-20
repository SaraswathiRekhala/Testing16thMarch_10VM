/*Copyright (c) 2019-2020 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.testing16thmarch_10vm.wmstudio.service;

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

import com.testing16thmarch_10vm.wmstudio.TimestampVersioning;

/**
 * Service object for domain model class {@link TimestampVersioning}.
 */
public interface TimestampVersioningService {

    /**
     * Creates a new TimestampVersioning. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on TimestampVersioning if any.
     *
     * @param timestampVersioning Details of the TimestampVersioning to be created; value cannot be null.
     * @return The newly created TimestampVersioning.
     */
    TimestampVersioning create(@Valid TimestampVersioning timestampVersioning);


	/**
     * Returns TimestampVersioning by given id if exists.
     *
     * @param timestampversioningId The id of the TimestampVersioning to get; value cannot be null.
     * @return TimestampVersioning associated with the given timestampversioningId.
	 * @throws EntityNotFoundException If no TimestampVersioning is found.
     */
    TimestampVersioning getById(Integer timestampversioningId);

    /**
     * Find and return the TimestampVersioning by given id if exists, returns null otherwise.
     *
     * @param timestampversioningId The id of the TimestampVersioning to get; value cannot be null.
     * @return TimestampVersioning associated with the given timestampversioningId.
     */
    TimestampVersioning findById(Integer timestampversioningId);

	/**
     * Find and return the list of TimestampVersionings by given id's.
     *
     * If orderedReturn true, the return List is ordered and positional relative to the incoming ids.
     *
     * In case of unknown entities:
     *
     * If enabled, A null is inserted into the List at the proper position(s).
     * If disabled, the nulls are not put into the return List.
     *
     * @param timestampversioningIds The id's of the TimestampVersioning to get; value cannot be null.
     * @param orderedReturn Should the return List be ordered and positional in relation to the incoming ids?
     * @return TimestampVersionings associated with the given timestampversioningIds.
     */
    List<TimestampVersioning> findByMultipleIds(List<Integer> timestampversioningIds, boolean orderedReturn);


    /**
     * Updates the details of an existing TimestampVersioning. It replaces all fields of the existing TimestampVersioning with the given timestampVersioning.
     *
     * This method overrides the input field values using Server side or database managed properties defined on TimestampVersioning if any.
     *
     * @param timestampVersioning The details of the TimestampVersioning to be updated; value cannot be null.
     * @return The updated TimestampVersioning.
     * @throws EntityNotFoundException if no TimestampVersioning is found with given input.
     */
    TimestampVersioning update(@Valid TimestampVersioning timestampVersioning);

    /**
     * Deletes an existing TimestampVersioning with the given id.
     *
     * @param timestampversioningId The id of the TimestampVersioning to be deleted; value cannot be null.
     * @return The deleted TimestampVersioning.
     * @throws EntityNotFoundException if no TimestampVersioning found with the given id.
     */
    TimestampVersioning delete(Integer timestampversioningId);

    /**
     * Deletes an existing TimestampVersioning with the given object.
     *
     * @param timestampVersioning The instance of the TimestampVersioning to be deleted; value cannot be null.
     */
    void delete(TimestampVersioning timestampVersioning);

    /**
     * Find all TimestampVersionings matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
     *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
     *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching TimestampVersionings.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
     */
    @Deprecated
    Page<TimestampVersioning> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
     * Find all TimestampVersionings matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching TimestampVersionings.
     *
     * @see Pageable
     * @see Page
     */
    Page<TimestampVersioning> findAll(String query, Pageable pageable);

    /**
     * Exports all TimestampVersionings matching the given input query to the given exportType format.
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
     * Exports all TimestampVersionings matching the given input query to the given exportType format.
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
     * Retrieve the count of the TimestampVersionings in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
     * @return The count of the TimestampVersioning.
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