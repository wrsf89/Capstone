<?php 
    $con = mysqli_connect("localhost", "favor531", "qwerty123!", "favor531");
    mysqli_query($con,'SET NAMES utf8');

    $userID = $_POST["userID"];

    $query = "SELECT m.receiveID, u.userName , c.uworkTime ,c.lovation_work, c.info_ration FROM USER AS u INNER JOIN CAREGIVER AS c ON u.userID = c.userID INNER JOIN MATCHING AS m ON c.userID = m.receiveID WHERE m.match_check = 'YES' AND m.sendID  = '$userID'";
    $res = mysqli_query($con,$query);

    $result = array();  
   
    while($row = mysqli_fetch_array($res)){
        array_push($result,array('receiveID' => $row[0] , 'userName' =>$row[1], 'uworkTime' =>$row[2] ,'lovation_work' =>$row[3],'info_ration'=>$row[4]));
    }
     
   
    echo json_encode(array("result"=>$result),JSON_UNESCAPED_UNICODE);


?>