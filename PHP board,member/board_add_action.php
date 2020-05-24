<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title></title>
  </head>
  <body>
    <h1>boardAddAction.php</h1>
    <?php
    $board_pw = $_POST["boardPw"];
    $board_title = $_POST["boardTitle"];
    $board_content = $_POST["boardContent"];
    $board_user = $_POST["boardUser"];
    echo "board_pw:" . $board_pw."<BR>";
    echo "board_title:" . $board_title . "<BR>";
    echo "board_content:" . $board_content . "<BR>";
    echo "board_user:" . $board_user . "<BR>";
    $conn = mysqli_connect("localhost","wnsekf09","1234","wnsekf09");
    if ($conn) {
      echo "연결 성공<BR>";
      // code...
    }else {
      die("연결 실패:".mysqli_error());
    }
    $sql = "INSERT INTO board(board_pw, board_title, board_content, board_user, board_date) VALUES('".$board_pw."','".$board_title."','".$board_content."','".$board_user."',now())";
    $result = mysqli_query($conn,$sql);
    if ($result) {
      echo "입력 성공:".$result;
      // code...
    }else {
      echo "입력 실패:".mysqli_error($conn);
    }
    mysqli_close($conn);

    header("Location: http://wnsekf09.ohseon.com/board_list.php");

     ?>
  </body>
</html>
