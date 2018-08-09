import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';

class App extends Component {

  state = {
    isLoading: true,
    images: []
  };

  async componentDidMount() {
    const response = await fetch('/api/images').catch(err => response.status(400).json('unable to get images'));
    const body = await response.json();
    this.setState({ images: body, isLoading: false });
  }

  render() {
    const {images, isLoading} = this.state;

    if (isLoading) {
      return <p>Loading...</p>;
    }
    console.log(images);
    return (
      <div className="App">
        <header className="App-header">
          <img src={logo} className="App-logo" alt="logo" />
          <h1 className="App-title">Welcome to React</h1>
        </header>
        <div className="App-intro">
          <h2>JUG List</h2>
          {images.map(image =>
            <div key={image.id}>
              {image.name}
            </div>
          )}
        </div>
      </div>
    );
  }
}

export default App;
