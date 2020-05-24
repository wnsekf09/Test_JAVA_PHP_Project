<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>board_delete.php</title>
  </head>
  <body>
    <h1>board_delete_action.php</h1>
    <?php
    $board_no = $_POST["board_no"];
    $board_pw = $_POST["board_pw"];
    echo "board_no : " . $board_no . "<BR>";
    echo "board_pw : " . $board_pw . "<BR>";

    $conn = mysqli_connect("localhost","wnsekf09","1234","wnsekf09");
    if ($conn) {
      echo "연결 성공<BR>";
      // code...
    }else {
      die("연결 실패 : ".mysqli_connect_error());
    }

    $sql = "DELETE FROM board WHERE board_pw='".$board_pw."'AND board_no=".$board_no."";

    if (mysqli_query($conn,$sql)) {
      echo "삭제 성공 : " . $result;
      // code...
    }else {
      echo "삭제 실패: ".mysqli_error($conn);
    }

    mysqli_close($conn);

    header("Location: http://wnsekf09.ohseon.com/board_list.php");
     ?>
  </body>
</html>
