<?php 
    $con = mysqli_connect("localhost", "favor531", "qwerty123!", "favor531");
    mysqli_query($con,'SET NAMES utf8');

       
    $userGender = $_POST["userGender"];
    $userAddress = $_POST["userAddress"];
    $location_check = $_POST["location_work"];
    $userServiceID = $_POST["userServiceID"];

    $query = "SELECT u.userID,u.userName,u.userGender,p.diseaseName, p.location_check, p.note,p.time FROM USER AS u INNER JOIN PATIENT AS p ON u.userID = p.userID LEFT OUTER JOIN MATCHING AS m ON p.userID = m.receiveID WHERE u.userGender = '$userGender' AND u.userAddress = '$userAddress' AND u.userServiceID = '$userServiceID' AND p.location_check = '$location_check' AND m.receiveID IS NULL";
    $res = mysqli_query($con,$query);

    $result = array();  
   
    while($row = mysqli_fetch_array($res)){
        array_push($result,array('userID' => $row[0] , 'userName' =>$row[1], 'userGender' =>$row[2] ,'diseaseName' =>$row[3],'location_check'=>$row[4],'note'=>$row[5] , 'time'=>$row[6]));
    }
     
   
    echo json_encode(array("result"=>$result),JSON_UNESCAPED_UNICODE);


?>