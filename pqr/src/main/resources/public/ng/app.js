var app = angular.module('PqrApp',['ui.router']);

app.config(function($stateProvider, $urlRouterProvider, $locationProvider) {
    $urlRouterProvider.otherwise('/');
    $stateProvider
    
    .state("landing", {
        url: '/',
        templateUrl: '/PQR/partials/landing.html',     
        controller: 'LandingPageController',
    })
    .state("home", {
        url: '/home',
        templateUrl: '/PQR/partials/home.html', 
        controller: 'DashboardController',
    })
    .state("login", {
        url: '/login',
        templateUrl: '/PQR/partials/login.html', 
        controller: 'LoginController',
    })
    
    .state("departments", {
        url: '/departments',
        templateUrl: '/PQR/partials/departments.html', 
        controller: 'DepartmentController',
    }) 
    .state("members", {
        url: '/members',
        templateUrl: '/PQR/partials/members.html', 
        controller: 'MemberController',
    })
    .state("positions", {
        url: '/positions',
        templateUrl: '/PQR/partials/positions.html', 
        controller: 'PositionController',
    })
     .state("projects", {
        url: '/projects',
        templateUrl: '/PQR/partials/projects.html', 
        controller: 'ProjectsController',
    }) 
        
    .state("users", {
        url: '/users',
        templateUrl: '/PQR/partials/users.html', 
        controller: 'UserController',
    })
    
    .state("department-projects", {
        url: '/department-projects',
        templateUrl: '/PQR/partials/dept_projects.html', 
        controller: 'DeptProjController',
    })
});