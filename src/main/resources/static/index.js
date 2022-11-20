angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/app';

    $scope.loadProducts = function () {
        $http.get(contextPath + '/products')
            .then(function (response) {
                $scope.ProductsList = response.data;
            });
    };

    $scope.deleteProduct = function (productId) {
        $http.get(contextPath + '/products/delete/' + productId)
            .then(function (response) {
                $scope.loadProducts();
            });
    }

    $scope.changePrice = function (productId, delta) {
        $http({
            url: contextPath + '/products/change_price',
            method: 'GET',
            params: {
                productId: productId,
                delta: delta
            }
        }).then(function (response) {
            $scope.loadProducts();
        });
    }


    $scope.filter = function () {
        console.log($scope.filtr);
        $http({
            url: contextPath + '/products/score_between',
            method: 'post',
            params: {
                min: $scope.filtr.min,
                max: $scope.filtr.max
            }
        }).then(function (response) {
            //console.log(response.data)
            $scope.loadProducts();
        });

    }

    $scope.loadProducts();
});