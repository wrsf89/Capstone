<?php 
    $con = mysqli_connect("localhost", "favor531", "qwerty123!", "favor531");
    mysqli_query($con,'SET NAMES utf8');

    $userID = $_POST["userID"];

    $query = "SELECT m.receiveID , u.uesrName , p.time, p.location_check, p.info_ration FROM USER AS u INNER JOIN PATIENT AS p ON u.userID = p.userID INNER JOIN MATCHING AS m ON p.userID = m.receiveID WHERE m.match_check = 'YES' AND m.sendID  = "$userID"";
    $res = mysqli_query($con,$query);

    $result = array();  
   
    while($row = mysqli_fetch_array($res)){
        array_push($result,array('receiveID' => $row[0] , 'userName' =>$row[1], 'time' =>$row[2] ,'location_check' =>$row[3],'info_ration'=>$row[4]));
    }
     
   
    echo json_encode(array("result"=>$result),JSON_UNESCAPED_UNICODE);


?>