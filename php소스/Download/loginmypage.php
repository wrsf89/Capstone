<?php 
    $con = mysqli_connect("localhost", "favor531", "qwerty123!", "favor531");
    mysqli_query($con,'SET NAMES utf8');

    //userID, userName, userPassword, userMail, userBirthday, userBirthday2, userBirthday3, userServiceID, userPhoneNB, userAddress


    $userID = $_POST["userID"];
    $userPassword = $_POST["userPassword"];
    $userName = $_POST["userName"];
    $userMail = $_POST["userMail"];
    $userBirthday = $_POST["userBirthday"];
    $userBirthday2 = $_POST["userBirthday2"];
    $userBirthday3 = $_POST["userBirthday3"];
    $userServiceID = $_POST["userServiceID"];
    $userPhoneNB = $_POST["userPhoneNB"];
    $userAddress = $_POST["userAddress"];
    



    $sql = "UPDATE data SET userPassword = '$userPassword', userName = '$userName', userMail = '$userMail', userBirthday = '$userBirthday', userBirthday2 = '$userBirthday2', userBirthday3 = '$userBirthday3', userServiceID = '$userServiceID', userPhoneNB = '$userPhoneNB', userAddress = '$userAddress' WHERE userID = '$userID' ";
   
    $result = mysqli_puery($connection,$sql);


    if($result){
        echo "Data Updated";
    }

    else{
        echo"Failed";
    }


?>