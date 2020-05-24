<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>board_add_form.php</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <link rel="stylesheet" href="//unpkg.com/bootstrap@4/dist/css/bootstrap.min.css">
    <script src='//unpkg.com/jquery@3/dist/jquery.min.js'></script>
    <script src='//unpkg.com/popper.js@1/dist/umd/popper.min.js'></script>
    <script src='//unpkg.com/bootstrap@4/dist/js/bootstrap.min.js'></script>

  </head>
  <body>
    <h1 class="display-4">board_add_form.php</h1>
    <form class="form-horizontal" action="/board_add_action.php" method="post">
      <div class="form-group">
        <label for="exampleInputPassword1" class="col-sm-2 control-label">비밀번호 : </label>
        <div class="col-sm-10">
          <input type="form-control" name="boardPw" id="password" type="password" placeholder="Password" >
        </div>
      </div>
      <div class="form-group">
        <label for="exampleInputTitle1" class="col-sm-2 control-label">글 제목 : </label>
        <div class="col-sm-10">
          <input type="form-control" name="boardTitle" id="Title" type="text" placeholder="Title" >
        </div>
      </div>
      <div class="form-group">
        <label for="exampleInputContent1" class="col-sm-2 control-label">글 내용 : </label>
        <div class="col-sm-10">
        <textarea class="form-control" name="boardContent" id="content" rows="8" cols="50" placeholder="Content"></textarea>
        </div>
      </div>
      <div class="form-group">
        <label for="exampleInputName1" class="col-sm-2 control-label">작성자명 : </label>
        <div class="col-sm-10">
          <input type="form-control" name="boardUser" id="name" type="text" placeholder="Name" >
        </div>
      </div>

      <div>
        &nbsp;&nbsp;&nbsp;
        <button class="btn btn-primary" type="submit" value="글 입력">글 입력</button>
        &nbsp;&nbsp;
        <button class="btn btn-primary" type="reset" value="초기화">초기화</button>
        &nbsp;&nbsp;
        <a class="btn btn-primary" href="/board_list.php">리스트로 돌아가기</a>
      </div>
    </form>
    <script type="text/javascript">
    $("#password").change(function(){
      checkPassword($('#password').val());
    });
    $("#Title").change(function(){
      checkPassword($('#Title').val());
    });
    $("#content").change(function(){
      checkPassword($('#content').val());
    });
    $("#name").change(function(){
      checkPassword($('#name').val());
    });

    function checkPassword(password){
      if (password.length < 2) {
        alert("비밀번호는 4자 이상 입력하여야 합니다.");
        $('#password').val('').focus();
        return false;
      }else {
        return true;
      }
    }

    function checkTitle(Title) {
      if (Tltle.length < 2) {
        alert('제목은 2자 이상 입력해야 합니다.');
        $('#Title').cal('').focus();
          return false;
      }else {
        return true;
      }
    }
    function checkTitle(content) {
      if (content.length < 2) {
        alert('내용은 2자 이상 입력해야 합니다.');
        $('#content').cal('').focus();
          return false;
      }else {
        return true;
      }
    }
    function checkTitle (name) {
      if (name.length < 2) {
        alert('작성자명은 2자 이상 입력해야 합니다.');
        $('#name').cal('').focus();
          return false;
      }else {
        return true;
      }
    }
    </script>
  </body>
</html>
