<%@ page import="java.util.*" %>
<%@ page import="static org.oldcode.javaweb.generated.jooq.public_.tables.Account.ACCOUNT" %>
<%@ page import="org.jooq.Record" %>
<%@ page import="org.jooq.Result" %>

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
        <th>id</th>
        <th>username</th>
        <th>email</th>
        <th>password</th>
      </tr>
      <%
      for (Record r: (Result<Record>)request.getAttribute("users")) {
      %>
      <tr>
        <td><%= r.getValue(ACCOUNT.ID) %></td>
        <td><%= r.getValue(ACCOUNT.USERNAME) %></td>
        <td><%= r.getValue(ACCOUNT.EMAIL) %></td>
        <td><%= r.getValue(ACCOUNT.PASSWORD) %></td>
      </tr>
      <%
      }
      %>
    </tbody>
  </table>
</div>

