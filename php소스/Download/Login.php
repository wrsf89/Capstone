<?php 
    $con = mysqli_connect("localhost", "favor531", "qwerty123!", "favor531");

    

    //userID, userName, userPassword, userMail, userBirthday, userBirthday2, userBirthday3, userGender, userServiceID, userPhoneNB, userAddress

    $userID = $_POST["userID"];
    $userPassword = $_POST["userPassword"];
   


    $statement = mysqli_prepare($con, "SELECT * FROM USER WHERE userID = ? AND userPassword = ?");
    mysqli_stmt_bind_param($statement, "ss", $userID, $userPassword);
    mysqli_stmt_execute($statement);

    mysqli_stmt_store_result($statement);
    mysqli_stmt_bind_result($statement, $userID, $userPassword, $userName, $userMail, $userBirthday, $userBirthday2, $userBirthday3, $userGender, $userServiceID, $userPhoneNB, $userAddress ,$image);    


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
        $response["image"] = $image;
             
    }
 
   
    echo json_encode($response);



?>