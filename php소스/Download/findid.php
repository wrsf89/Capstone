<?php 
    $con = mysqli_connect("localhost", "favor531", "qwerty123!", "favor531");

    

    //userID, userName, userPassword, userMail, userBirthday, userBirthday2, userBirthday3, userGender, userServiceID, userPhoneNB, userAddress

    $usermail = $_POST["usermail"];
    $username = $_POST["username"];

   


    $statement = mysqli_prepare($con, "SELECT userID FROM USER WHERE userMail = ? AND userName = ?");
    mysqli_stmt_bind_param($statement, "ss", $usermail,$username);
    mysqli_stmt_execute($statement);

    mysqli_stmt_store_result($statement);
    mysqli_stmt_bind_result($statement, $userID);    


    $response = array();
    $response["success"] = false;

    while(mysqli_stmt_fetch($statement)) {
        $response["success"] = true;
       
        $response["userID"] = $userID;

        
             
    }
 
   
    echo json_encode($response);
   
   ?>
