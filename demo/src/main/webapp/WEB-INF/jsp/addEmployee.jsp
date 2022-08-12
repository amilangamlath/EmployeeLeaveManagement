<html>
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</head>
<body style="background-color:#ffb237;background-image: url('img/index.jpeg')">
<div ng-app="myApp" ng-controller="myCtrl">

    <h1 style="color: maroon">Add Employee(This is dummy page)</h1>
    <form>
        <div class="form-group" style="align-items: center;margin: 400px;margin-top: 50px;border: 2px solid maroon">
         <span>First Name</span> <input type="text" name="name" ng-model="cus.name" class="form-control" placeholder="FName" style="width: 300px;margin-left: 25px">
        <br>
         <span>Last Name</span> <input type="text" name="name" ng-model="cus.lname" class="form-control" placeholder="LName" style="width: 300px;margin-left: 25px">
        <br>
        <span>NIC</span> <input type="text" name="name" ng-model="cus.nic" class="form-control" placeholder="NIC" style="width: 300px;margin-left: 25px">
        <br>
        <br>
        <span>Address</span> <input type="text" name="name" ng-model="cus.address" class="form-control" placeholder="Address" style="width: 300px;margin-left: 25px">
        <br>
        <button type="submit" value="Login" ng-click="addCus()" class="btn btn-primary btn-sm" style="margin-left: 25px;">Submit</button>
        </div>
    </form>


</div>

    <script>
        var app = angular.module('myApp', []);
        app.controller('myCtrl', function ($scope, $http) {

            $scope.addCus = function () {
                console.log($scope.cus)
                $http({
                    method: 'post',
                    url: 'api/v1/addEmploee',
                    data: $scope.cus
                }).then(function (response) {
                    $scope.content = response.data;
                    alert("success");

                });
            }
        });
    </script>

</body>
</html>