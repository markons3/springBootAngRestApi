angular.module("crudApp").controller("GeneralController", GeneralController);

GeneralController.inject=['$scope', 'Employee'];

function GeneralController($scope, Employee) {
	$scope.employee = Employee.query();
	$scope.employee = {};
	$scope.buttonText = "Submit";
	
	
	$scope.saveEmployee = function() {
		if ($scope.employee.id!==undefined){
			Employee.update($scope,employee,function(){
				$scope.employee = Employee.query();
				$scope.employee = {};
				$scope.buttonText = "Submit";
			});
		} else {
			Employee.save($scope,employee,function(){
				$scope.employee = Employee.query();
				$scope.employee = {};
			});
		}
	}
	
	$scope.updateEmployeeInit = function(employee){
		$scope.buttonText = "Update";
		$scope.employee = employee;
	}
	
	$scope.deleteEmployeeInit = function(employee){
		employee.$delete({id:employee.id},function(){
			$scope.employees = Employee.query();
		});
	}
}