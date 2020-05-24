<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>board_list.php</title>
    <link rel="stylesheet" href="//unpkg.com/bootstrap@4/dist/css/bootstrap.min.css">
    <script src='//unpkg.com/jquery@3/dist/jquery.min.js'></script>
    <script src='//unpkg.com/popper.js@1/dist/umd/popper.min.js'></script>
    <script src='//unpkg.com/bootstrap@4/dist/js/bootstrap.min.js'></script>
    <title></title>
  </head>
  <body>
    <h1 class="display-4">board_list.php</h1>
    <?php
        $currentPage = 1;
        if (isset($_GET["currentPage"])) {
              $currentPage = $_GET["currentPage"];
          // code...
        }
        $conn = mysqli_connect("localhost","wnsekf09","1234","wnsekf09");

        if ($conn) {
          echo "연결 성공<BR>";
          // code...
        }else {
          die("연결 실패 :".mysqli_error());
        }

        // 페이징 작업을 위한 테이블 내 전체 행 갯수 조회 쿼리
      $sqlCount = "SELECT count(*) FROM board";
      $resultCount = mysqli_query($conn,$sqlCount);
      if ($rowCount = mysqli_fetch_array($resultCount)) {
          $totalRowNum = $rowCount["count(*)"];
        // code...
      }
      if ($resultCount) {
        echo "행 갯수 조회 성공 :".$totalRowNum."<BR>";
        // code...
      }else {
        echo "결과 없음:".mysqli_error($conn);
      }
        // 행 갯수 조회 쿼리가 실행 됐는지 여부

        $rowPerPage = 5;
        $begin = ($currentPage -1) * $rowPerPage;
        // board 테이블을 조회해서 board_no, board_title, board_user,board_date 필드 값을 내림차순으로 정렬하여 모드 가져 오는 쿼리
        $sql = "SELECT board_no, board_title , board_user, board_date  FROM board order by board_no desc limit ".$begin.",".$rowPerPage."";
        $result = mysqli_query($conn,$sql);

      if ($result) {
        echo "조회 성공 : ".$totalRowNum."<BR>";
        // code...
      }else {
        echo "결과 없음:".mysqli_error($conn);
      }
     ?>
     <table class="table table-bordered">
       <tr>
         <td>board_no</td>
         <td>board_title</td>
         <td>board_user</td>
         <td>board_date</td>
         <td>수정</td>
         <td>삭제</td>
       </tr>
       <?php
        while ($row = mysqli_fetch_array($result)) {
          // code...

        ?>
        <tr>
          <td>
            <?php
                echo $row["board_no"];
             ?>
          </td>
          <td>
            <?php
                echo "<a href='/board_detail.php?board_no=".
                $row["board_no"]."'>";
                echo $row["board_title"];
                echo "</a>";
             ?>
          </td>
          <td>
            <?php
                echo $row["board_user"];
             ?>
          </td>
          <td>
            <?php
                echo $row["board_date"];
             ?>
          </td>
          <?php
            echo "<td><a href='/board_update_form.php?board_no=".$row["board_no"]."'>수정</a></td>";
            echo "<td><a href='/board_delete_form.php?board_no=".$row["board_no"]."'>삭제</a></td>";
           ?>
        </tr>
      <?php } ?>
     </table>
     &nbsp;&nbsp;&nbsp;&nbsp;
     <?php
      if ($currentPage > 1) {
        echo "<a class='btn btn-primary' href = '/board_list.php?currentPage=".
        ($currentPage-1)."'>이전</a>&nbsp;&nbsp;&nbsp;&nbsp;";
        // code...
      }
      $lastPage = ($totalRowNum-1) / $rowPerPage;

      if (($totalRowNum-1) % $rowPerPage !=0) {
        $lastPage +=1;
        // code...
      }
      if ($currentPage < $lastPage) {
        echo "<a class='btn btn-primary' href='/board_list.php?currentPage=".
        ($currentPage+1)."'>다음</a>";
        // code...
      }
      mysqli_close($conn);
      ?>
      &nbsp;&nbsp;
      <a class="btn btn-primary" href="/board_add_form.php">글 쓰기</a>
      <br><br><br><br>
      <script type="text/javascript" src="js/bootstrap.js"></script>
  </body>
</html>
