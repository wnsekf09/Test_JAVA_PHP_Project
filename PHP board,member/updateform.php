<?php
session_start();
 ?>
 <!DOCTYPE html>
 <html lang="en" dir="ltr">
   <head>
     <meta charset="utf-8">
     <title></title>
   </head>
   <body>
     <hr size='1' noshade>
     수정 화면
     <hr size='1' noshade>
     [<a href="list.php">돌아가기</a>]
     <br>
     <?php
     require_once("MYDB.php");
     $pdo = db_connect();
     if (isset($_GET['id']) && $_GET['id'] > 0) {
       $id = $_GET['id'];
       $_SESSION['id'] = $id;
       // code...
     }else {
       exit('잘못된 파라미터입니다.');
     }
     try {
       $sql = "SELECT * FROM member WHERE id = :id";
       $stmh = $pdo->prepare($sql);
       $stmh->bindValue(':id',$id,PDO::PARAM_INT);
       $stmh->execute();
       $count= $stmh->rowCount();
     } catch (PDOException $Excepion) {
       print "오류:".$Excepion->getMessage();
     }
     if ($count <1) {
       print "수정할 데이터가 없습니다.";
     }else{
       $row = $stmh->fetch(PDO::FETCH_ASSOC);
       ?>
       <form class="form1" action="list.php" method="post">
         번호:<?=htmlspecialchars($row['id'])?><br>
         성:<input type="text" name="last_name" value="<?=htmlspecialchars($row['last_name'])?>">
         이름:<input type="text" name="first_name" value="<?=htmlspecialchars($row['first_name'])?>">
         연령:<input type="text" name="age" value="<?=htmlspecialchars($row['age'])?>">
         <input type="hidden" name="action" value="update">
         <input type="submit" value="수정">
       </form>
     <?php } ?>


   </body>
 </html>
