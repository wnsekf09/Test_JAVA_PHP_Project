<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8" />
    <title>board_detail.php</title>
    <link rel="stylesheet" href="//unpkg.com/bootstrap@4/dist/css/bootstrap.min.css">
    <script src='//unpkg.com/jquery@3/dist/jquery.min.js'></script>
    <script src='//unpkg.com/popper.js@1/dist/umd/popper.min.js'></script>
    <script src='//unpkg.com/bootstrap@4/dist/js/bootstrap.min.js'></script>
    <style>
        table {
            table-layout: fixed;
            word-wrap: break-word;
        }
    </style>
    <title></title>
  </head>
  <body>
    <h1 class="display-4">board_detail.php</h1>
    <?php
      $conn = mysqli_connect("localhost","wnsekf09","1234","wnsekf09");
      if ($conn) {
        echo "연결성공<BR>";
        // code...
      }else {
        die("연결 실패:".mysqli_error());
      }
     $board_no = $_GET["board_no"];
     echo $board_no."번째 글 내용<BR>";

     $sql = "SELECT board_no, board_title, board_content, board_user, board_date FROM board WHERE board_no = '".$board_no."'";
     $result = mysqli_query($conn,$sql);

     if ($result) {
       echo "조회 성공";
       // code...
     }else {
       echo "결과 없음:".mysqli_error($conn);
     }
     ?>
     <table class="table table-bordered" style="width:50%">
       <?php if ($row = mysqli_fetch_array($result)) { ?>
         <tr>
           <td style="width:15%">작성자</td>
           <td style="width:35%">
              <?php echo $row["board_user"]; ?>
           </td>
         </tr>

          <tr>

           <td style="width:10%">글 제목</td>
           <td style="width:15%">
           <?php echo $row["board_title"]; ?></td>

           <td style="width:5%">글번호</td>
           <td style="width:3%">
           <?php echo $row["board_no"]; ?></td>

           <td style="width:5%">작성 일자</td>
           <td style="width:3%">
           <?php echo $row["board_date"]; ?></td>
         </tr>
         <tr>
           <td colspan="6">
             <?php echo $row["board_content"]; ?>
           </td>
         </tr>
       <?php } ?>
     </table>
     <br>
     &nbsp;&nbsp;&nbsp;
     <a class="btn btn-primary" href="/board_list.php">리스트로 돌아가기</a>
     <script type="text/javascript" src="js/bootstrap.js"></script>
  </body>
</html>
