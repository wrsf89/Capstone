<?php 
    $con = mysqli_connect("localhost", "favor531", "qwerty123!", "favor531");
    mysqli_query($con,'SET NAMES utf8');

  


    $sendID = $_POST["sendID"];
    $receiveID = $_POST["receiveID"];
    $matching_check = $_POST["matching_check"];

    



    $statement = mysqli_prepare($con, "INSERT INTO MATCHING(sendID,receiveID,match_check) VALUES (?,?,?)");
    mysqli_stmt_bind_param($statement, "sss",  $sendID, $receiveID,$matching_check);
    mysqli_stmt_execute($statement);


    $response = array();
    $response["success"] = true;
 
   
    echo json_encode($response);



?>