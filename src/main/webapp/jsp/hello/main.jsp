<!DOCTYPE html>
<html>
  <head>
    <title>main</title>
  </head>
  <body>
    <h1>main</h1>
    <div id="target">Click here</div>
    <div id="pContent">orig-pContent</div>
   
<form id="form123" action="/action_page.php">
  First name:<br>
  <input type="text" name="name" class="liveUpdate" value="Mickey-qwd-qwdqwd-1231dqwd">
  <br>
  <input type="text" name="name2" class="liveUpdate" value="Mickey-qwd-qwdqwd-1231dqwd">
  <br>
  <%--
  <input type="radio" name="gender" value="male" checked> Male<br>
  <input type="radio" name="gender" value="female"> Female<br>
  <input type="radio" name="gender" value="other"> Other
  <br> 
  <br>
  <select class="liveUpdate" name="cars">
    <option value="volvo">Volvo</option>
    <option value="saab">Saab</option>
    <option value="fiat">Fiat</option>
    <option value="audi">Audi</option>
  </select>
  --%>
  <br><br>
  desc:<br>
  <input class="liveUpdate" type="textarea" name="desc" value="Mouse........qweqwe/////........asdasd">
  <br><br>
  <input type="submit" value="Submit">
</form>  

    <script
			  src="https://code.jquery.com/jquery-3.3.1.js"
			  integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60="
			  crossorigin="anonymous"></script>

<script>
$(".liveUpdate[name='name']").select(function() {
  alert( "Handler for .select() name called." );
});
$( "#target" ).click(function() {
  //alert( "Handler for .click() called." );
  loadBlock(0, 'name');
});
function loadBlock(id, field_in){
  $.ajax({
    type: "POST",
    url: '/xyz/hello-test.' + id,
    success: function(html){
      $("#pContent").html(html);
      if(field_in.length){
        var formFields = $("#form123").find('input,textarea,select').filter(':visible');
        var thisIdx = formFields.index( $(".liveUpdate[name='" + field_in + "']") );
        console.log('thisIdx:',thisIdx);
        console.log('formFields:', formFields);
        
        if ( thisIdx > -1 && ( thisIdx + 1 ) < formFields.length ) { 
          console.log("if thisIdx > -1 ....");
          //formFields.eq( thisIdx  ).focus().select();
          formFields.eq( thisIdx + 1 ).select();
        }
      }
    }
  });
}

//loadBlock(2, 'cars');
//loadBlock(1, 'name');
//loadBlock(0, 'desc');
</script>

  </body>
</html>

<%--
JQuery AJAX
For the function below, what is the purpose of the parameter ‘field_in’?
Also, what do you feel is missing from the AJAX call in this function?
function loadBlock(id, field_in){
  $.ajax({
    type: "POST",
    url: 'block_admin.jsp?id=' + id,
    success: function(html){
      $("#pContent").html(html);
      if(field_in.length){
        var formFields = $("#formName").find('input,textarea,select').filter(':visible');
        var thisIdx = formFields.index( $(".liveUpdate[name='" + field_in + "']") );
        if ( thisIdx > -1 && ( thisIdx + 1 ) < formFields.length ) { 
          formFields.eq( thisIdx + 1 ).focus().select();
        }
      }
    }
  });
}
--%>


