import React from 'react';
import './App.css';

import Player from './components/Player';

function App() {
  return (
    <div className="App">
      <audio controls src="./../public/why.mp3">
        Your browser does not support the
        <code>audio</code> element.
      </audio>
    </div>
  );
}

export default App;
