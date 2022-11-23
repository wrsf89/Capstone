<?php 
    $con = mysqli_connect("localhost", "favor531", "qwerty123!", "favor531");

    

    $userID = $_POST["userID"];
    $userServiceID = $_POST["userServiceID"];
   

    $statement = mysqli_prepare($con, "SELECT * FROM USER WHERE userID = ? AND userServiceID = ?");
    mysqli_stmt_bind_param($statement, "ss", $userID, $userServiceID);
    mysqli_stmt_execute($statement);

    mysqli_stmt_store_result($statement);
    mysqli_stmt_bind_result($statement, $userID, $userPassword, $userName, $userMail, $userBirthday, $userBirthday2, $userBirthday3, $userGender, $userServiceID, $userPhoneNB, $userAddress ,$img);    


    $response = array();
    $response["success"] = false;

    while(mysqli_stmt_fetch($statement)) {
        $response["success"] = true;
        $response["userID"] = $userID;
        $response["userPassword"] = $userPassword;
        $response["userName"] = $userName;
        $response["userMail"] = $userMail;
        $response["userBirthday"] = $userBirthday;
        $response["userBirthday2"] = $userBirthday2;
        $response["userBirthday3"] = $userBirthday3;
        $response["userGender"] = $userGender;
        $response["userServiceID"] = $userServiceID;
        $response["userPhoneNB"] = $userPhoneNB;
        $response["userAddress"] = $userAddress;
        $img["img"] = $img;
    
             
    }
 
   
    echo json_encode($response);



?>