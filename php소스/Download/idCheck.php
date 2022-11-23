<?php 
    $con = mysqli_connect("localhost", "favor531", "qwerty123!", "favor531");
    mysqli_query($con,'SET NAMES utf8');

//유저 아이디 중복 확인

    $userID = $_POST["userID"];
    


    $statement = mysqli_prepare($con, "SELECT * FROM USER WHERE userID =  ?");
    mysqli_stmt_bind_param($statement, "s", $userID);
    mysqli_stmt_execute($statement);
    mysqli_stmt_store_result($statement);
    mysqli_stmt_bind_result($statement, $userID);



    $response = array();
    $response["success"] = true;

    while(mysqli_stmt_fetch($statement)){
        $response["success"] = false;
        $response["userID"] = $userID;

    }
 
   
    echo json_encode($response);



?>