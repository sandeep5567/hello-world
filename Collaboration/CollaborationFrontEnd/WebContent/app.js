(function() {
	'use strict';

	angular.module('app', [ 'ngRoute', 'ngCookies' ]).config(config).run(run);

	config.$inject = [ '$routeProvider', '$locationProvider' ];
	function config($routeProvider, $locationProvider) {
		$routeProvider.when('/', {
			controller : 'HomeController',
			templateUrl : 'cs_home/home.view.html',
			controllerAs : 'vm'
		})

		.when('/login', {
			controller : 'LoginController',
			templateUrl : 'cs_login/login.view.html',
			controllerAs : 'vm'
		})

		.when('/register', {
			controller : 'RegisterController',
			templateUrl : 'cs_registration/registration.view.html',
			controllerAs : 'vm'
		})

		.when('/blog', {
			templateUrl : 'c_blog/blog.html',
			controller : 'BlogController'
		})

		.when('/event', {
			templateUrl : 'c_event/event.html',
			controller : 'EventController'
		})

		.otherwise({
			redirectTo : '/login'
		});
	}

	run.$inject = [ '$rootScope', '$location', '$cookieStore', '$http' ];
	function run($rootScope, $location, $cookieStore, $http) {
		// keep user logged in after page refresh
		$rootScope.globals = $cookieStore.get('globals') || {};
		if ($rootScope.globals.currentUser) {
			$http.defaults.headers.common['Authorization'] = 'Basic '
					+ $rootScope.globals.currentUser.authdata;
		}

		$rootScope.$on('$locationChangeStart', function(event, next, current) {
			// redirect to login page if not logged in and trying to access a
			// restricted page
			var restrictedPage = $.inArray($location.path(), [ '/login',
					'/register' ]) === -1;
			var loggedIn = $rootScope.globals.currentUser;
			if (restrictedPage && !loggedIn) {
				$location.path('/login');
			}
		});
	}

})();
