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

import com.testing16thmarch_10vm.cascadedb.ChildLocking;
import com.testing16thmarch_10vm.cascadedb.ParentLockinig;
import com.testing16thmarch_10vm.cascadedb.service.ParentLockinigService;


/**
 * Controller object for domain model class ParentLockinig.
 * @see ParentLockinig
 */
@RestController("cascadedb.ParentLockinigController")
@Api(value = "ParentLockinigController", description = "Exposes APIs to work with ParentLockinig resource.")
@RequestMapping("/cascadedb/ParentLockinig")
public class ParentLockinigController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ParentLockinigController.class);

    @Autowired
	@Qualifier("cascadedb.ParentLockinigService")
	private ParentLockinigService parentLockinigService;

	@Autowired
	private ExportedFileManager exportedFileManager;

	@ApiOperation(value = "Creates a new ParentLockinig instance.")
    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public ParentLockinig createParentLockinig(@RequestBody ParentLockinig parentLockinig) {
		LOGGER.debug("Create ParentLockinig with information: {}" , parentLockinig);

		parentLockinig = parentLockinigService.create(parentLockinig);
		LOGGER.debug("Created ParentLockinig with information: {}" , parentLockinig);

	    return parentLockinig;
	}

    @ApiOperation(value = "Returns the ParentLockinig instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public ParentLockinig getParentLockinig(@PathVariable("id") Integer id) {
        LOGGER.debug("Getting ParentLockinig with id: {}" , id);

        ParentLockinig foundParentLockinig = parentLockinigService.getById(id);
        LOGGER.debug("ParentLockinig details with id: {}" , foundParentLockinig);

        return foundParentLockinig;
    }

    @ApiOperation(value = "Updates the ParentLockinig instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public ParentLockinig editParentLockinig(@PathVariable("id") Integer id, @RequestBody ParentLockinig parentLockinig) {
        LOGGER.debug("Editing ParentLockinig with id: {}" , parentLockinig.getId());

        parentLockinig.setId(id);
        parentLockinig = parentLockinigService.update(parentLockinig);
        LOGGER.debug("ParentLockinig details with id: {}" , parentLockinig);

        return parentLockinig;
    }

    @ApiOperation(value = "Deletes the ParentLockinig instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteParentLockinig(@PathVariable("id") Integer id) {
        LOGGER.debug("Deleting ParentLockinig with id: {}" , id);

        ParentLockinig deletedParentLockinig = parentLockinigService.delete(id);

        return deletedParentLockinig != null;
    }

    /**
     * @deprecated Use {@link #findParentLockinigs(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of ParentLockinig instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @XssDisable
    public Page<ParentLockinig> searchParentLockinigsByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering ParentLockinigs list by query filter:{}", (Object) queryFilters);
        return parentLockinigService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of ParentLockinig instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<ParentLockinig> findParentLockinigs(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering ParentLockinigs list by filter:", query);
        return parentLockinigService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of ParentLockinig instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @XssDisable
    public Page<ParentLockinig> filterParentLockinigs(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering ParentLockinigs list by filter", query);
        return parentLockinigService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @XssDisable
    public Downloadable exportParentLockinigs(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return parentLockinigService.export(exportType, query, pageable);
    }

    @ApiOperation(value = "Returns a URL to download a file for the data matching the optional query (q) request param and the required fields provided in the Export Options.") 
    @RequestMapping(value = "/export", method = {RequestMethod.POST}, consumes = "application/json")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @XssDisable
    public StringWrapper exportParentLockinigsAndGetURL(@RequestBody DataExportOptions exportOptions, Pageable pageable) {
        String exportedFileName = exportOptions.getFileName();
        if(exportedFileName == null || exportedFileName.isEmpty()) {
            exportedFileName = ParentLockinig.class.getSimpleName();
        }
        exportedFileName += exportOptions.getExportType().getExtension();
        String exportedUrl = exportedFileManager.registerAndGetURL(exportedFileName, outputStream -> parentLockinigService.export(exportOptions, pageable, outputStream));
        return new StringWrapper(exportedUrl);
    }

	@ApiOperation(value = "Returns the total count of ParentLockinig instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	@XssDisable
	public Long countParentLockinigs( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting ParentLockinigs");
		return parentLockinigService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	@XssDisable
	public Page<Map<String, Object>> getParentLockinigAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return parentLockinigService.getAggregatedValues(aggregationInfo, pageable);
    }

    @RequestMapping(value="/{id:.+}/childLockings", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the childLockings instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<ChildLocking> findAssociatedChildLockings(@PathVariable("id") Integer id, Pageable pageable) {

        LOGGER.debug("Fetching all associated childLockings");
        return parentLockinigService.findAssociatedChildLockings(id, pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service ParentLockinigService instance
	 */
	protected void setParentLockinigService(ParentLockinigService service) {
		this.parentLockinigService = service;
	}

}