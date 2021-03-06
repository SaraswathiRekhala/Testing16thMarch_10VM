/*Copyright (c) 2019-2020 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.testing16thmarch_10vm.cascadedb.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wavemaker.commons.wrapper.StringWrapper;
import com.wavemaker.runtime.data.export.DataExportOptions;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.manager.ExportedFileManager;
import com.wavemaker.runtime.file.model.Downloadable;
import com.wavemaker.runtime.security.xss.XssDisable;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

import com.testing16thmarch_10vm.cascadedb.ByteUniqueLocking;
import com.testing16thmarch_10vm.cascadedb.service.ByteUniqueLockingService;


/**
 * Controller object for domain model class ByteUniqueLocking.
 * @see ByteUniqueLocking
 */
@RestController("cascadedb.ByteUniqueLockingController")
@Api(value = "ByteUniqueLockingController", description = "Exposes APIs to work with ByteUniqueLocking resource.")
@RequestMapping("/cascadedb/ByteUniqueLocking")
public class ByteUniqueLockingController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ByteUniqueLockingController.class);

    @Autowired
	@Qualifier("cascadedb.ByteUniqueLockingService")
	private ByteUniqueLockingService byteUniqueLockingService;

	@Autowired
	private ExportedFileManager exportedFileManager;

	@ApiOperation(value = "Creates a new ByteUniqueLocking instance.")
    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public ByteUniqueLocking createByteUniqueLocking(@RequestBody ByteUniqueLocking byteUniqueLocking) {
		LOGGER.debug("Create ByteUniqueLocking with information: {}" , byteUniqueLocking);

		byteUniqueLocking = byteUniqueLockingService.create(byteUniqueLocking);
		LOGGER.debug("Created ByteUniqueLocking with information: {}" , byteUniqueLocking);

	    return byteUniqueLocking;
	}

    @ApiOperation(value = "Returns the ByteUniqueLocking instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public ByteUniqueLocking getByteUniqueLocking(@PathVariable("id") Integer id) {
        LOGGER.debug("Getting ByteUniqueLocking with id: {}" , id);

        ByteUniqueLocking foundByteUniqueLocking = byteUniqueLockingService.getById(id);
        LOGGER.debug("ByteUniqueLocking details with id: {}" , foundByteUniqueLocking);

        return foundByteUniqueLocking;
    }

    @ApiOperation(value = "Updates the ByteUniqueLocking instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public ByteUniqueLocking editByteUniqueLocking(@PathVariable("id") Integer id, @RequestBody ByteUniqueLocking byteUniqueLocking) {
        LOGGER.debug("Editing ByteUniqueLocking with id: {}" , byteUniqueLocking.getId());

        byteUniqueLocking.setId(id);
        byteUniqueLocking = byteUniqueLockingService.update(byteUniqueLocking);
        LOGGER.debug("ByteUniqueLocking details with id: {}" , byteUniqueLocking);

        return byteUniqueLocking;
    }

    @ApiOperation(value = "Deletes the ByteUniqueLocking instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteByteUniqueLocking(@PathVariable("id") Integer id) {
        LOGGER.debug("Deleting ByteUniqueLocking with id: {}" , id);

        ByteUniqueLocking deletedByteUniqueLocking = byteUniqueLockingService.delete(id);

        return deletedByteUniqueLocking != null;
    }

    @RequestMapping(value = "/version/{version}", method = RequestMethod.GET)
    @ApiOperation(value = "Returns the matching ByteUniqueLocking with given unique key values.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public ByteUniqueLocking getByVersion(@PathVariable("version") Byte version) {
        LOGGER.debug("Getting ByteUniqueLocking with uniques key Version");
        return byteUniqueLockingService.getByVersion(version);
    }

    /**
     * @deprecated Use {@link #findByteUniqueLockings(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of ByteUniqueLocking instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @XssDisable
    public Page<ByteUniqueLocking> searchByteUniqueLockingsByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering ByteUniqueLockings list by query filter:{}", (Object) queryFilters);
        return byteUniqueLockingService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of ByteUniqueLocking instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<ByteUniqueLocking> findByteUniqueLockings(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering ByteUniqueLockings list by filter:", query);
        return byteUniqueLockingService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of ByteUniqueLocking instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @XssDisable
    public Page<ByteUniqueLocking> filterByteUniqueLockings(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering ByteUniqueLockings list by filter", query);
        return byteUniqueLockingService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @XssDisable
    public Downloadable exportByteUniqueLockings(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return byteUniqueLockingService.export(exportType, query, pageable);
    }

    @ApiOperation(value = "Returns a URL to download a file for the data matching the optional query (q) request param and the required fields provided in the Export Options.") 
    @RequestMapping(value = "/export", method = {RequestMethod.POST}, consumes = "application/json")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @XssDisable
    public StringWrapper exportByteUniqueLockingsAndGetURL(@RequestBody DataExportOptions exportOptions, Pageable pageable) {
        String exportedFileName = exportOptions.getFileName();
        if(exportedFileName == null || exportedFileName.isEmpty()) {
            exportedFileName = ByteUniqueLocking.class.getSimpleName();
        }
        exportedFileName += exportOptions.getExportType().getExtension();
        String exportedUrl = exportedFileManager.registerAndGetURL(exportedFileName, outputStream -> byteUniqueLockingService.export(exportOptions, pageable, outputStream));
        return new StringWrapper(exportedUrl);
    }

	@ApiOperation(value = "Returns the total count of ByteUniqueLocking instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	@XssDisable
	public Long countByteUniqueLockings( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting ByteUniqueLockings");
		return byteUniqueLockingService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	@XssDisable
	public Page<Map<String, Object>> getByteUniqueLockingAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return byteUniqueLockingService.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service ByteUniqueLockingService instance
	 */
	protected void setByteUniqueLockingService(ByteUniqueLockingService service) {
		this.byteUniqueLockingService = service;
	}

}