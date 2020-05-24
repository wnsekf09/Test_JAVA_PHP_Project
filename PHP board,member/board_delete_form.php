<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="//unpkg.com/bootstrap@4/dist/css/bootstrap.min.css">
    <script src='//unpkg.com/jquery@3/dist/jquery.min.js'></script>
    <script src='//unpkg.com/popper.js@1/dist/umd/popper.min.js'></script>
    <script src='//unpkg.com/bootstrap@4/dist/js/bootstrap.min.js'></script>
  </head>
  <body>
    <h1 class="display-4">board_delete_form.php</h1>
    <?php
    $board_no = $_GET["board_no"];
    echo $board_no."번쨰 글 삭제 페이지<BR>";
     ?>
     <form action="/board_delete_action.php" method="post">
       <table class="table table_bordered" style="width:10%">
         <tr>
           <td>글 비밀 번호를 입력하세요.</td>
         </tr>
         <tr>
           <td>
             <input type="text" name="board_pw">
             <input type="hidden" name="board_no" value="<?php echo $board_no ?>">
           </td>
         </tr>
         <tr>
           <td><button class="btn btn_primary" type="submit">글 삭제 버튼</td>
         </tr>
       </table>
     </form>
     <script type="text/javascript" src="js/bootstrap.js">

     </script>
  </body>
</html>
