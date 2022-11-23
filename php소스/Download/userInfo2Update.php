<?php 
    $con = mysqli_connect("localhost", "favor531", "qwerty123!", "favor531");
    mysqli_query($con,'SET NAMES utf8');


    $userID = $_POST["userID"];
    $Ucareer = $_POST["Ucareer_db"];
    $info_ration = $_POST["info_ration_db"];
    $Ulicense = $_POST["Ulicense_db"];
    $lovation_work = $_POST["lovation_work_db"];
    $uworkTime = $_POST["uworkTime_db"];
    

    $statement = mysqli_prepare($con, "UPDATE CAREGIVER SET Ucareer = ?,info_ration = ? , Ulicense = ? ,lovation_work = ? , uworkTime = ? WHERE userID = ?");
    mysqli_stmt_bind_param($statement, "ssssss",  $Ucareer, $info_ration, $Ulicense, $lovation_work, $uworkTime,$userID);
    mysqli_stmt_execute($statement);


    $response = array();
    $response["success"] = true;
 
   
    echo json_encode($response);



?>