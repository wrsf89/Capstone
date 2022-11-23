<?php 
    $con = mysqli_connect("localhost", "favor531", "qwerty123!", "favor531");

    //userID, userName, userPassword, userMail, userBirthday, userBirthday2, userBirthday3, userGender, userServiceID, userPhoneNB, userAddress

    $userID = $_POST["userID"];
    $userPassword = $_POST["userPassword"];
    $userName = $_POST["userName"];
    $userMail = $_POST["userMail"];
    $userBirthday = $_POST["userBirthday"];
    $userBirthday2 = $_POST["userBirthday2"];
    $userBirthday3 = $_POST["userBirthday3"];
    $userGender = $_POST["userGender"];
    $userServiceID = $_POST["userServiceID"];
    $userPhoneNB = $_POST["userPhoneNB"];
    $userAddress = $_POST["userAddress"];
    $img = $_POST['img'];

   
    

    $statement = mysqli_prepare($con, "INSERT INTO USER(userID, userPassword, userName, userMail, userBirthday, userBirthday2, userBirthday3, userGender, userServiceID, userPhoneNB, userAddress, img) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
    mysqli_stmt_bind_param($statement, "ssssiiississ", $userID, $userPassword, $userName, $userMail, $userBirthday, $userBirthday2, $userBirthday3, $userGender, $userServiceID, $userPhoneNB, $userAddress, $img);
    mysqli_stmt_execute($statement);


    $response = array();
    $response["success"] = true;
 
   
    echo json_encode($response);



?>