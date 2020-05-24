<?php
  function db_connect(){

      $db_user= "wnsekf09";
      $db_pass= "1234";
      $db_host= "localhost";
      $db_name= "wnsekf09";
      $db_type= "mysql";
      $dsn = "$db_type:host=$db_host;dbname=$db_name;charset=utf8";
      try {
        $pdo = new PDO($dsn,$db_user,$db_pass);
        $pdo->setAttribute(PDO::ATTR_ERRMODE,PDO::ERRMODE_EXCEPTION);
        $pdo->setAttribute(PDO::ATTR_EMULATE_PREPARES,false);
        print "접속이 되었습니다.<br>";
      } catch (PDOException $e) {
        die('오류:'.$e->getMessage());
      }
      return $pdo;
  }
 ?>
