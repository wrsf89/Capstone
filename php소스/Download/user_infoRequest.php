<?php 
    $con = mysqli_connect("localhost", "favor531", "qwerty123!", "favor531");
    mysqli_query($con,'SET NAMES utf8');

    //signID , time , diseaseName , location_check , dementia_check , info_rateing , note


    $userID = $_POST["userID"];
    $diseaseName = $_POST["diseaseName"];
    $location_check = $_POST["location_check"];
    $dementia_check = $_POST["dementia_check"];
    $info_ration = $_POST["info_ration"];
    $note = $_POST["note"];
    $time = $_POST["time"];
    



    $statement = mysqli_prepare($con, "INSERT INTO PATIENT(userID,diseaseName,location_check,dementia_check,info_ration,note,time) VALUES (?,?,?,?,?,?,?)");
    mysqli_stmt_bind_param($statement, "sssssss", $userID, $diseaseName, $location_check, $dementia_check, $info_ration, $note, $time );
    mysqli_stmt_execute($statement);


    $response = array();
    $response["success"] = true;
 
   
    echo json_encode($response);



?>