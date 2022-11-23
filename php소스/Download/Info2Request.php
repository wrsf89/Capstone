<?php 
    $con = mysqli_connect("localhost", "favor531", "qwerty123!", "favor531");
    mysqli_query($con,'SET NAMES utf8');

//    public Info2Request(String Ucareer, String info_ration, String Ulicense, String lovation_work, String uworkTime, String userID Response.Listener<String> listener)

    $Ucareer = $_POST["Ucareer"];
    $info_ration = $_POST["info_ration"];
    $Ulicense = $_POST["Ulicense"];
    $lovation_work = $_POST["lovation_work"];
    $uworkTime = $_POST["uworkTime"];
    $userID = $_POST["userID"];

    
    
    



    $statement = mysqli_prepare($con, "INSERT INTO CAREGIVER(Ucareer, info_ration, Ulicense, lovation_work, uworkTime, userID) VALUES (?,?,?,?,?,?)");
    mysqli_stmt_bind_param($statement, "ssssss", $Ucareer, $info_ration, $Ulicense, $lovation_work, $uworkTime, $userID);
    mysqli_stmt_execute($statement);


    $response = array();
    $response["success"] = true;
 
   
    echo json_encode($response);



?>