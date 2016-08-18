angular.module('todoController', [])

	// inject the Todo service factory into our controller
	.controller('appController', ['$scope','$http','Todos', function($scope, $http, Todos) {
		$scope.formData = {};
		$scope.loading = true;
		$scope.updatingTodo = false;

		// GET =====================================================================
		// when landing on the page, get all todos and show them
		// use the service to get all the todos
		Todos.get().then(function(data) {
				$scope.todos = data;
				$scope.loading = false;
			});

		// CREATE ==================================================================
		// when submitting the add form, send the text to the node API
		$scope.createTodo = function() {

			// validate the formData to make sure that something is there
			// if form is empty, nothing will happen
			if ($scope.formData.text != undefined) {
				$scope.loading = true;
				if ($scope.updatingTodo) {
					// call the update function from our service (returns a promise object)
				    Todos.update($scope.formData)

					// if successful creation, call our get function to get all the new todos
					.then(function(data) {
						$scope.loading = false;
						$scope.formData = {}; // clear the form so our user is ready to enter another
						var indexof = $scope.todos.map(function(e) { return e.id; }).indexOf(data.id);
					    if(indexof == -1) return;
					    $scope.todos[indexof] = data;
						$scope.updatingTodo = false;
					});

				} else {
					// call the create function from our service (returns a promise object)
				   Todos.create($scope.formData)

					// if successful creation, call our get function to get all the new todos
					.then(function(data) {
						$scope.loading = false;
						$scope.formData = {}; // clear the form so our user is ready to enter another
						$scope.todos.push(data);

					});
				}
			}
		};

		// DELETE ==================================================================
		// delete a todo after checking it
		$scope.deleteTodo = function(id) {
			$scope.loading = true;

			Todos.delete(id)
				.then(function(data) {
					$scope.loading = false;
					var indexof = $scope.todos.map(function(e) { return e.id; }).indexOf(id);
					if(indexof == -1) return;
					$scope.todos.splice(indexof);
				});
		};
		$scope.beginUpdate = function(todo) {
			$scope.formData = todo;
			$scope.updatingTodo = true;
		};
	}]);