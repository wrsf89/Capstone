<?php 
    $con = mysqli_connect("localhost", "favor531", "qwerty123!", "favor531");
    mysqli_query($con,'SET NAMES utf8');

  
    $sendID = $_POST["sendID"];
    $receiveID = $_POST["receiveID"];

    $statement = mysqli_prepare($con, "DELETE FROM MATCHING  WHERE sendID = ? AND receiveID = ?");
    mysqli_stmt_bind_param($statement, "ss",  $sendID, $receiveID);
    mysqli_stmt_execute($statement);


    $response = array();
    $response["success"] = true;
 
   
    echo json_encode($response);



?>