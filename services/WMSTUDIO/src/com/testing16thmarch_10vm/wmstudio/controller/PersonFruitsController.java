/*Copyright (c) 2019-2020 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.testing16thmarch_10vm.wmstudio.controller;

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

import com.testing16thmarch_10vm.wmstudio.PersonFruits;
import com.testing16thmarch_10vm.wmstudio.PersonFruitsId;
import com.testing16thmarch_10vm.wmstudio.service.PersonFruitsService;


/**
 * Controller object for domain model class PersonFruits.
 * @see PersonFruits
 */
@RestController("WMSTUDIO.PersonFruitsController")
@Api(value = "PersonFruitsController", description = "Exposes APIs to work with PersonFruits resource.")
@RequestMapping("/WMSTUDIO/PersonFruits")
public class PersonFruitsController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonFruitsController.class);

    @Autowired
	@Qualifier("WMSTUDIO.PersonFruitsService")
	private PersonFruitsService personFruitsService;

	@Autowired
	private ExportedFileManager exportedFileManager;

	@ApiOperation(value = "Creates a new PersonFruits instance.")
    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public PersonFruits createPersonFruits(@RequestBody PersonFruits personFruits) {
		LOGGER.debug("Create PersonFruits with information: {}" , personFruits);

		personFruits = personFruitsService.create(personFruits);
		LOGGER.debug("Created PersonFruits with information: {}" , personFruits);

	    return personFruits;
	}

    @ApiOperation(value = "Returns the PersonFruits instance associated with the given composite-id.")
    @RequestMapping(value = "/composite-id", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public PersonFruits getPersonFruits(@RequestParam("fid") Integer fid, @RequestParam("pid") Integer pid) {

        PersonFruitsId personfruitsId = new PersonFruitsId();
        personfruitsId.setFid(fid);
        personfruitsId.setPid(pid);

        LOGGER.debug("Getting PersonFruits with id: {}" , personfruitsId);
        PersonFruits personFruits = personFruitsService.getById(personfruitsId);
        LOGGER.debug("PersonFruits details with id: {}" , personFruits);

        return personFruits;
    }



    @ApiOperation(value = "Updates the PersonFruits instance associated with the given composite-id.")
    @RequestMapping(value = "/composite-id", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public PersonFruits editPersonFruits(@RequestParam("fid") Integer fid, @RequestParam("pid") Integer pid, @RequestBody PersonFruits personFruits) {

        personFruits.setFid(fid);
        personFruits.setPid(pid);

        LOGGER.debug("PersonFruits details with id is updated with: {}" , personFruits);

        return personFruitsService.update(personFruits);
    }


    @ApiOperation(value = "Deletes the PersonFruits instance associated with the given composite-id.")
    @RequestMapping(value = "/composite-id", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deletePersonFruits(@RequestParam("fid") Integer fid, @RequestParam("pid") Integer pid) {

        PersonFruitsId personfruitsId = new PersonFruitsId();
        personfruitsId.setFid(fid);
        personfruitsId.setPid(pid);

        LOGGER.debug("Deleting PersonFruits with id: {}" , personfruitsId);
        PersonFruits personFruits = personFruitsService.delete(personfruitsId);

        return personFruits != null;
    }


    /**
     * @deprecated Use {@link #findPersonFruits(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of PersonFruits instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @XssDisable
    public Page<PersonFruits> searchPersonFruitsByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering PersonFruits list by query filter:{}", (Object) queryFilters);
        return personFruitsService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of PersonFruits instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<PersonFruits> findPersonFruits(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering PersonFruits list by filter:", query);
        return personFruitsService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of PersonFruits instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @XssDisable
    public Page<PersonFruits> filterPersonFruits(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering PersonFruits list by filter", query);
        return personFruitsService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @XssDisable
    public Downloadable exportPersonFruits(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return personFruitsService.export(exportType, query, pageable);
    }

    @ApiOperation(value = "Returns a URL to download a file for the data matching the optional query (q) request param and the required fields provided in the Export Options.") 
    @RequestMapping(value = "/export", method = {RequestMethod.POST}, consumes = "application/json")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @XssDisable
    public StringWrapper exportPersonFruitsAndGetURL(@RequestBody DataExportOptions exportOptions, Pageable pageable) {
        String exportedFileName = exportOptions.getFileName();
        if(exportedFileName == null || exportedFileName.isEmpty()) {
            exportedFileName = PersonFruits.class.getSimpleName();
        }
        exportedFileName += exportOptions.getExportType().getExtension();
        String exportedUrl = exportedFileManager.registerAndGetURL(exportedFileName, outputStream -> personFruitsService.export(exportOptions, pageable, outputStream));
        return new StringWrapper(exportedUrl);
    }

	@ApiOperation(value = "Returns the total count of PersonFruits instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	@XssDisable
	public Long countPersonFruits( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting PersonFruits");
		return personFruitsService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	@XssDisable
	public Page<Map<String, Object>> getPersonFruitsAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return personFruitsService.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service PersonFruitsService instance
	 */
	protected void setPersonFruitsService(PersonFruitsService service) {
		this.personFruitsService = service;
	}

}