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

import com.testing16thmarch_10vm.cascadedb.CompositeLocking;
import com.testing16thmarch_10vm.cascadedb.CompositeLockingId;
import com.testing16thmarch_10vm.cascadedb.service.CompositeLockingService;


/**
 * Controller object for domain model class CompositeLocking.
 * @see CompositeLocking
 */
@RestController("cascadedb.CompositeLockingController")
@Api(value = "CompositeLockingController", description = "Exposes APIs to work with CompositeLocking resource.")
@RequestMapping("/cascadedb/CompositeLocking")
public class CompositeLockingController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CompositeLockingController.class);

    @Autowired
	@Qualifier("cascadedb.CompositeLockingService")
	private CompositeLockingService compositeLockingService;

	@Autowired
	private ExportedFileManager exportedFileManager;

	@ApiOperation(value = "Creates a new CompositeLocking instance.")
    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public CompositeLocking createCompositeLocking(@RequestBody CompositeLocking compositeLocking) {
		LOGGER.debug("Create CompositeLocking with information: {}" , compositeLocking);

		compositeLocking = compositeLockingService.create(compositeLocking);
		LOGGER.debug("Created CompositeLocking with information: {}" , compositeLocking);

	    return compositeLocking;
	}

    @ApiOperation(value = "Returns the CompositeLocking instance associated with the given composite-id.")
    @RequestMapping(value = "/composite-id", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public CompositeLocking getCompositeLocking(@RequestParam("version") Integer version, @RequestParam("id") Integer id) {

        CompositeLockingId compositelockingId = new CompositeLockingId();
        compositelockingId.setVersion(version);
        compositelockingId.setId(id);

        LOGGER.debug("Getting CompositeLocking with id: {}" , compositelockingId);
        CompositeLocking compositeLocking = compositeLockingService.getById(compositelockingId);
        LOGGER.debug("CompositeLocking details with id: {}" , compositeLocking);

        return compositeLocking;
    }



    @ApiOperation(value = "Updates the CompositeLocking instance associated with the given composite-id.")
    @RequestMapping(value = "/composite-id", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public CompositeLocking editCompositeLocking(@RequestParam("version") Integer version, @RequestParam("id") Integer id, @RequestBody CompositeLocking compositeLocking) {

        compositeLocking.setVersion(version);
        compositeLocking.setId(id);

        LOGGER.debug("CompositeLocking details with id is updated with: {}" , compositeLocking);

        return compositeLockingService.update(compositeLocking);
    }


    @ApiOperation(value = "Deletes the CompositeLocking instance associated with the given composite-id.")
    @RequestMapping(value = "/composite-id", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteCompositeLocking(@RequestParam("version") Integer version, @RequestParam("id") Integer id) {

        CompositeLockingId compositelockingId = new CompositeLockingId();
        compositelockingId.setVersion(version);
        compositelockingId.setId(id);

        LOGGER.debug("Deleting CompositeLocking with id: {}" , compositelockingId);
        CompositeLocking compositeLocking = compositeLockingService.delete(compositelockingId);

        return compositeLocking != null;
    }


    /**
     * @deprecated Use {@link #findCompositeLockings(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of CompositeLocking instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @XssDisable
    public Page<CompositeLocking> searchCompositeLockingsByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering CompositeLockings list by query filter:{}", (Object) queryFilters);
        return compositeLockingService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of CompositeLocking instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<CompositeLocking> findCompositeLockings(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering CompositeLockings list by filter:", query);
        return compositeLockingService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of CompositeLocking instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @XssDisable
    public Page<CompositeLocking> filterCompositeLockings(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering CompositeLockings list by filter", query);
        return compositeLockingService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @XssDisable
    public Downloadable exportCompositeLockings(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return compositeLockingService.export(exportType, query, pageable);
    }

    @ApiOperation(value = "Returns a URL to download a file for the data matching the optional query (q) request param and the required fields provided in the Export Options.") 
    @RequestMapping(value = "/export", method = {RequestMethod.POST}, consumes = "application/json")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @XssDisable
    public StringWrapper exportCompositeLockingsAndGetURL(@RequestBody DataExportOptions exportOptions, Pageable pageable) {
        String exportedFileName = exportOptions.getFileName();
        if(exportedFileName == null || exportedFileName.isEmpty()) {
            exportedFileName = CompositeLocking.class.getSimpleName();
        }
        exportedFileName += exportOptions.getExportType().getExtension();
        String exportedUrl = exportedFileManager.registerAndGetURL(exportedFileName, outputStream -> compositeLockingService.export(exportOptions, pageable, outputStream));
        return new StringWrapper(exportedUrl);
    }

	@ApiOperation(value = "Returns the total count of CompositeLocking instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	@XssDisable
	public Long countCompositeLockings( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting CompositeLockings");
		return compositeLockingService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	@XssDisable
	public Page<Map<String, Object>> getCompositeLockingAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return compositeLockingService.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service CompositeLockingService instance
	 */
	protected void setCompositeLockingService(CompositeLockingService service) {
		this.compositeLockingService = service;
	}

}