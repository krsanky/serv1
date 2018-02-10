<form method="post" action="/xyz/account-login.0">
  <section class="section">
    <div class="container">
			<div id="root"></div>
    </div>
  </section>
</form>

<script>
console.log('rtw/index.jsp');
window.onload = function() {
    class Greetings extends React.Component {
      render() {
          return React.createElement('h1', null, 'Greetings, ' + this.props.name + '!');
      }
    }
    ReactDOM.render(
        React.createElement(Greetings, { name : 'Jamma Jam Jamms Jam' }),
        document.getElementById('root')
    );
};
</script>

