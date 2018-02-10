/* react test */
var data = {
    products: [
        { id: 0, title: 'BorBor123' },
        { id: 1, title: 'Consulting' },
        { id: 2, title: 'TMFHR' },
        { id: 3, title: 'ASDasdqwe' },
    ],
};


// then just use `data`
//const HomePage = () => (
//  <div>
//    {data.products.map(product => (
//      <p>{product.title}</p>
//    ))}
//  </div>
//);

// simplest thing?
//class PageA extends Component {
//  render() {
//    return (
//      <div>Do things</div>
//    );
//  }
//}

//ReactDOM.render(<PageA />, document.body);
/*
*/
React.createElement('div', null, 
      React.createElement('h1', null, 'Hello World'),
      React.createElement('a', null, 'Click Me!')
)



