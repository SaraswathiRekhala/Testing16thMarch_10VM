/*Copyright (c) 2019-2020 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.testing16thmarch_10vm.datalockingdb.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wavemaker.commons.wrapper.IntegerWrapper;
import com.wavemaker.runtime.file.manager.ExportedFileManager;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

import com.testing16thmarch_10vm.datalockingdb.models.query.SvUpdateVersionRequest;
import com.testing16thmarch_10vm.datalockingdb.service.DataLockingdbQueryExecutorService;

@RestController(value = "DataLockingdb.QueryExecutionController")
@RequestMapping("/DataLockingdb/queryExecutor")
@Api(value = "QueryExecutionController", description = "controller class for query execution")
public class QueryExecutionController {

    private static final Logger LOGGER = LoggerFactory.getLogger(QueryExecutionController.class);

    @Autowired
    private DataLockingdbQueryExecutorService queryService;

    @Autowired
	private ExportedFileManager exportedFileManager;

    @RequestMapping(value = "/queries/SV_UpdateVersion", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "SV_UpdateVersion")
    public IntegerWrapper executeSV_UpdateVersion(@Valid @RequestBody SvUpdateVersionRequest svUpdateVersionRequest, HttpServletRequest _request) {
        LOGGER.debug("Executing named query: SV_UpdateVersion");
        Integer _result = queryService.executeSV_UpdateVersion(svUpdateVersionRequest);
        LOGGER.debug("got the result for named query: SV_UpdateVersion, result:{}", _result);
        return new IntegerWrapper(_result);
    }

}