/*Copyright (c) 2019-2020 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.testing16thmarch_10vm.employeeautowiring.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.testing16thmarch_10vm.employeeautowiring.EmployeeAutowiring;
import com.testing16thmarch_10vm.hrdb.Employee;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;
import com.wordnik.swagger.annotations.Api;

/**
 * Controller object for domain model class {@link EmployeeAutowiring}.
 * @see EmployeeAutowiring
 */
@RestController
@Api(value = "EmployeeAutowiringController", description = "controller class for java service execution")
@RequestMapping("/employeeAutowiring")
public class EmployeeAutowiringController {

    @Autowired
    private EmployeeAutowiring employeeAutowiring;

    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @RequestMapping(value = "/findAllEmployees", method = RequestMethod.GET)
    public Page<Employee> findAllEmployees(@RequestParam(value = "query", required = false) String query,  Pageable pageable) {
        return employeeAutowiring.findAllEmployees(query, pageable);
    }
}