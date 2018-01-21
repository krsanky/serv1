<%
String password = request.getParameter("password");
if (password == null) {
  password = "";
}
String username = request.getParameter("username");
if (username == null) {
  username = "";
}
%>
<form method="post" action="/xyz/account-admin.2">
  <section class="section">
    <div class="container">
      <div class="columns">

        <div class="column">
          <div class="field">
            <label class="label">username</label>
            <div class="control">
              <input class="input" name="username" type="text"
                     placeholder="username" value='<%= username %>'>
            </div>
          </div>
          <div class="field">
            <label class="label">password</label>
            <div class="control">
              <input class="input" type="text" name="password"
                     placeholder="password" value='<%= password %>'>
            </div>
          </div>
          <div class="control">
            <button class="button is-link">create</button>
          </div>
        </div>

        <div class="column">
          &nbsp; &nbsp; &nbsp;
        </div>
        
      </div><!-- columns -->
    </div>
  </section>
</form>

<!-- all users -->
<div class="container">
  <table class="table">
    <tbody>
      <tr>
        <th>asd</th>
        <th>123</th>
        <th>asdasd</th>
      </tr>

      <tr>
        <td>asd</td>
        <td>123</td>
        <td>asdasd</td>
      </tr>
    </tbody>
  </table>
</div>

