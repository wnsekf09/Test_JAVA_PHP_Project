
<html >
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>board_update.php</title>
  </head>
  <body>
    <h1>board_update_action.php</h1>
    <?php
      $board_no = $_POST["board_no"];
      $board_title = $_POST["board_title"];
      $board_content = $_POST["board_content"];
      echo "board_no : ". $board_no . "<BR>";
      echo "board_title : ". $board_title . "<BR>";
      echo "board_content : ". $board_content . "<BR>";
      $conn = mysqli_connect("localhost","wnsekf09","1234","wnsekf09");
      if ($conn) {
        echo "연결 성공<BR>";
        // code...
      }else {
        die("연결 실패 : " .mysqli_error());
      }

      $sql = "UPDATE board SET board_title='".$board_title."',board_content = '".$board_content."',board_date=now() WHERE board_no=".$board_no."";
      $result = mysqli_query($conn,$sql);
      if ($result) {
        echo "수정 성공:".$result;
        // code...
      }else {
        echo "수정 실패:".mysqli_error($conn);
      }

      mysqli_close($conn);

      header("Location: http://wnsekf09.ohseon.com/board_list.php");

     ?>
  </body>
</html>
