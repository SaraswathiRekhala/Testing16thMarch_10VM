/*
 * Use App.getDependency for Dependency Injection
 * eg: var DialogService = App.getDependency('DialogService');
 */

/* perform any action on widgets/variables within this block */
Partial.onReady = function() {
    /*
     * variables can be accessed through 'Partial.Variables' property here
     * e.g. to get dataSet in a staticVariable named 'loggedInUser' use following script
     * Partial.Variables.loggedInUser.getData()
     *
     * widgets can be accessed through 'Partial.Widgets' property here
     * e.g. to get value of text widget named 'username' use following script
     * 'Partial.Widgets.username.datavalue'
     */
};

Partial.EmployeeList1Click = function($event, widget) {
    debugger
};

// Partial.EmployeeList1Mouseenter = function($event, widget) {
//     debugger
// };

Partial.EmployeeList1Select = function(widget, $data) {
    debugger
};

Partial.EmployeeList1Reorder = function($event, $data, $changedItem) {
    debugger
};

Partial.EmployeeList1Selectionlimitexceed = function($event, widget) {
    debugger
};

Partial.EmployeeList1Beforedatarender = function(widget, $data) {
    debugger
};

Partial.EmployeeList1Paginationchange = function($event, widget, $index) {
    debugger
};

Partial.EmployeeList1Setrecord = function($event, widget, $index, $data) {
    debugger
};