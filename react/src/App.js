import './App.css';
import sample from './sample.jpeg'
function App() {

  return (
      <div className="App">

          <div className="header">
              <p className="title">UB Marketplace</p>
              <p className="login">
                  <a href="http://ubmarketplace.herokuapp.com/login.html">Login/Register</a>
              </p>
          </div>
          <div className="itemList">
              <div className="itemImg">
                  <img src={sample}/>
                  <p>Product Name</p>
                  <p>Product Price</p>
              </div>
              <div className="itemImg">
                  <img src={sample}/>
                  <p>Product Name</p>
                  <p>Product Price</p>
              </div>
              <div className="itemImg">
                  <img src={sample}/>
                  <p>Product Name</p>
                  <p>Product Price</p>
              </div>
              <div className="itemImg">
                  <img src={sample}/>
                  <p>Product Name</p>
                  <p>Product Price</p>
              </div>
              <div className="itemImg">
                  <img src={sample}/>
                  <p>Product Name</p>
                  <p>Product Price</p>
              </div>
          </div>

          <div className="categoryList">
              <h2>Category List</h2>
              <ul>
                  <li>Electronics</li>
                  <li>Textbooks</li>
                  <li>Clothings</li>
                  <li>Furnitures</li>
              </ul>
              <ul>
                  <li>Electronics</li>
                  <li>Textbooks</li>
                  <li>Clothings</li>
                  <li>Furnitures</li>
              </ul>
              <ul>
                  <li>Electronics</li>
                  <li>Textbooks</li>
                  <li>Clothings</li>
                  <li>Furnitures</li>
              </ul>
              <ul>
                  <li>Electronics</li>
                  <li>Textbooks</li>
                  <li>Clothings</li>
                  <li>Furnitures</li>
              </ul>
              <ul>
                  <li>See All Items</li>
                  <li>Sell My Items</li>
              </ul>
          </div>
      </div>
  );
}

export default App;
