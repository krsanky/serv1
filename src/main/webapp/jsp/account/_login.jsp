<form method="post" action="/xyz/account-login.0">
  <section class="section">
    <div class="container">
      <div class="columns">

        <div class="column">
          <div class="field">
            <label class="label">username|email</label>
            <div class="control">
              <input class="input" name="username" type="text" placeholder="username">
            </div>
          </div>
          <div class="field">
            <label class="label">password</label>
            <div class="control">
              <input class="input" type="password" placeholder="password">
            </div>
          </div>
          <div class="control">
            <button class="button is-link">Submit</button>
          </div>
        </div>

        <div class="column">
          &nbsp; &nbsp; &nbsp;
        </div>
        
      </div><!-- columns -->
    </div>
  </section>
</form>

<script>
//alert('hey');
for (i=1; i<6; i++) {
  if (i===2) {
    console.log("<li>"+(i*2)+" x "+i+" = "+(i*2));
  } else {
    console.log("<li>"+(i*2)+" x "+i+" = "+(i*i*2));
  }
}
</script>
<%--
Javascript/JQuery
Javascript
Create a loop in Javascript code that will output the following:
<li>2 x 1 = 2
<li>4 x 2 = 4
<li>6 x 3 = 18
<li>8 x 4 = 32
<li>10 x 5 = 50

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
field_in would be the name of a form element of type intut, textarea, or select. 
(eg. name="first_name")
The ajaxy fields have a style of class="liveUpdate".
The code makes a ajax call and gets a result, and smooshes that into the element with id:pContent.
The code looks up the index of the "field_in" field, and checks that it was found, and is valid.
                                 (why thisIdx + 1???)
It then focuses that element and triggers a select event.
(so it behaves like a person clicked in it?)                                
MISSING: error clause.
--%>

