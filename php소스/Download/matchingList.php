<?php 
    $con = mysqli_connect("localhost", "favor531", "qwerty123!", "favor531");
    mysqli_query($con,'SET NAMES utf8');

       
    $userGender = $_POST["userGender"];
    $userAddress = $_POST["userAddress"];
    $lovation_work = $_POST["lovation_work"];
    $userServiceID = $_POST["userServiceID"];

    $query = "SELECT u.userID,u.userName,u.userGender,c.lovation_work,c.Ucareer,c.Ulicense , c.uWorkTime ,u.img FROM USER AS u INNER JOIN CAREGIVER AS c ON u.userID = c.userID LEFT OUTER JOIN MATCHING AS m ON c.userID = m.receiveID WHERE u.userGender = '$userGender' AND u.userAddress = '$userAddress' AND c.lovation_work = '$lovation_work' AND u.userServiceID = '$userServiceID' AND m.receiveID IS NULL";
    $res = mysqli_query($con,$query);
    
    $result = array();  
   
    while($row = mysqli_fetch_array($res)){
        array_push($result,array('userID' => $row[0] , 'userName' =>$row[1], 'userGender' =>$row[2] ,'lovation_work' =>$row[3],'Ucareer'=>$row[4],'Ulicense'=>$row[5] , 'uWorkTime'=>$row[6],'img'=> base64_encode($row[7]) ));
    }
     
   
    echo json_encode(array("result"=>$result),JSON_UNESCAPED_UNICODE);


?>