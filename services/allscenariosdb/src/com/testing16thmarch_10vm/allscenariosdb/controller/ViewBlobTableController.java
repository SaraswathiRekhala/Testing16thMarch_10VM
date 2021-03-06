/*Copyright (c) 2019-2020 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.testing16thmarch_10vm.allscenariosdb.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.TypeMismatchException;
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
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.wavemaker.commons.wrapper.StringWrapper;
import com.wavemaker.runtime.data.export.DataExportOptions;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.manager.ExportedFileManager;
import com.wavemaker.runtime.file.model.DownloadResponse;
import com.wavemaker.runtime.file.model.Downloadable;
import com.wavemaker.runtime.security.xss.XssDisable;
import com.wavemaker.runtime.util.WMMultipartUtils;
import com.wavemaker.runtime.util.WMRuntimeUtils;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

import com.testing16thmarch_10vm.allscenariosdb.ViewBlobTable;
import com.testing16thmarch_10vm.allscenariosdb.service.ViewBlobTableService;


/**
 * Controller object for domain model class ViewBlobTable.
 * @see ViewBlobTable
 */
@RestController("allscenariosdb.ViewBlobTableController")
@Api(value = "ViewBlobTableController", description = "Exposes APIs to work with ViewBlobTable resource.")
@RequestMapping("/allscenariosdb/ViewBlobTable")
public class ViewBlobTableController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ViewBlobTableController.class);

    @Autowired
	@Qualifier("allscenariosdb.ViewBlobTableService")
	private ViewBlobTableService viewBlobTableService;

	@Autowired
	private ExportedFileManager exportedFileManager;

	@ApiOperation(value = "Creates a new ViewBlobTable instance.")
    @RequestMapping(method = RequestMethod.POST, consumes = "multipart/form-data")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public ViewBlobTable createViewBlobTable(@RequestPart("wm_data_json") ViewBlobTable viewBlobTable, @RequestPart(value = "blobcol", required = false) MultipartFile _blobcol) {
		LOGGER.debug("Create ViewBlobTable with information: {}" , viewBlobTable);

    viewBlobTable.setBlobcol(WMMultipartUtils.toByteArray(_blobcol));
		viewBlobTable = viewBlobTableService.create(viewBlobTable);
		LOGGER.debug("Created ViewBlobTable with information: {}" , viewBlobTable);

	    return viewBlobTable;
	}

    @ApiOperation(value = "Returns the ViewBlobTable instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public ViewBlobTable getViewBlobTable(@PathVariable("id") Integer id) {
        LOGGER.debug("Getting ViewBlobTable with id: {}" , id);

        ViewBlobTable foundViewBlobTable = viewBlobTableService.getById(id);
        LOGGER.debug("ViewBlobTable details with id: {}" , foundViewBlobTable);

        return foundViewBlobTable;
    }

    @ApiOperation(value = "Retrieves content for the given BLOB field in ViewBlobTable instance" )
    @RequestMapping(value = "/{id}/content/{fieldName}", method = RequestMethod.GET, produces="application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public DownloadResponse getViewBlobTableBLOBContent(@PathVariable("id") Integer id, @PathVariable("fieldName") String fieldName, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestParam(value="download", defaultValue = "false") boolean download) {

        LOGGER.debug("Retrieves content for the given BLOB field {} in ViewBlobTable instance" , fieldName);

        if(!WMRuntimeUtils.isLob(ViewBlobTable.class, fieldName)) {
            throw new TypeMismatchException("Given field " + fieldName + " is not a valid BLOB type");
        }
        ViewBlobTable viewBlobTable = viewBlobTableService.getById(id);

        return WMMultipartUtils.buildDownloadResponseForBlob(viewBlobTable, fieldName, httpServletRequest, download);
    }

    @ApiOperation(value = "Updates the ViewBlobTable instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public ViewBlobTable editViewBlobTable(@PathVariable("id") Integer id, @RequestBody ViewBlobTable viewBlobTable) {
        LOGGER.debug("Editing ViewBlobTable with id: {}" , viewBlobTable.getId());

        viewBlobTable.setId(id);
        viewBlobTable = viewBlobTableService.update(viewBlobTable);
        LOGGER.debug("ViewBlobTable details with id: {}" , viewBlobTable);

        return viewBlobTable;
    }

    @ApiOperation(value = "Updates the ViewBlobTable instance associated with the given id.This API should be used when ViewBlobTable instance fields that require multipart data.") 
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.POST, consumes = {"multipart/form-data"})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public ViewBlobTable editViewBlobTable(@PathVariable("id") Integer id, MultipartHttpServletRequest multipartHttpServletRequest) {
        ViewBlobTable newViewBlobTable = WMMultipartUtils.toObject(multipartHttpServletRequest, ViewBlobTable.class, "allscenariosdb");
        newViewBlobTable.setId(id);

        ViewBlobTable oldViewBlobTable = viewBlobTableService.getById(id);
        WMMultipartUtils.updateLobsContent(oldViewBlobTable, newViewBlobTable);
        LOGGER.debug("Updating ViewBlobTable with information: {}" , newViewBlobTable);

        return viewBlobTableService.update(newViewBlobTable);
    }

    @ApiOperation(value = "Deletes the ViewBlobTable instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteViewBlobTable(@PathVariable("id") Integer id) {
        LOGGER.debug("Deleting ViewBlobTable with id: {}" , id);

        ViewBlobTable deletedViewBlobTable = viewBlobTableService.delete(id);

        return deletedViewBlobTable != null;
    }

    /**
     * @deprecated Use {@link #findViewBlobTables(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of ViewBlobTable instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @XssDisable
    public Page<ViewBlobTable> searchViewBlobTablesByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering ViewBlobTables list by query filter:{}", (Object) queryFilters);
        return viewBlobTableService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of ViewBlobTable instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<ViewBlobTable> findViewBlobTables(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering ViewBlobTables list by filter:", query);
        return viewBlobTableService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of ViewBlobTable instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @XssDisable
    public Page<ViewBlobTable> filterViewBlobTables(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering ViewBlobTables list by filter", query);
        return viewBlobTableService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @XssDisable
    public Downloadable exportViewBlobTables(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return viewBlobTableService.export(exportType, query, pageable);
    }

    @ApiOperation(value = "Returns a URL to download a file for the data matching the optional query (q) request param and the required fields provided in the Export Options.") 
    @RequestMapping(value = "/export", method = {RequestMethod.POST}, consumes = "application/json")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @XssDisable
    public StringWrapper exportViewBlobTablesAndGetURL(@RequestBody DataExportOptions exportOptions, Pageable pageable) {
        String exportedFileName = exportOptions.getFileName();
        if(exportedFileName == null || exportedFileName.isEmpty()) {
            exportedFileName = ViewBlobTable.class.getSimpleName();
        }
        exportedFileName += exportOptions.getExportType().getExtension();
        String exportedUrl = exportedFileManager.registerAndGetURL(exportedFileName, outputStream -> viewBlobTableService.export(exportOptions, pageable, outputStream));
        return new StringWrapper(exportedUrl);
    }

	@ApiOperation(value = "Returns the total count of ViewBlobTable instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	@XssDisable
	public Long countViewBlobTables( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting ViewBlobTables");
		return viewBlobTableService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	@XssDisable
	public Page<Map<String, Object>> getViewBlobTableAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return viewBlobTableService.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service ViewBlobTableService instance
	 */
	protected void setViewBlobTableService(ViewBlobTableService service) {
		this.viewBlobTableService = service;
	}

}