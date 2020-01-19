import React from 'react';
import './App.css';

import handlers from './utils/handlers';
import Screen from './components/Screen';
import ChatPage from './components/ChatPage'

function App() {
  const [files, setFiles] = React.useState([]);

  if (files.length < 1) {
    handlers.getAlldata().then(filesArr => {
      console.log(filesArr);
      setFiles(filesArr);
    });
  }
  return (
    <div className="App">
      <Screen files={files} />
    </div>
  );
}

export default App;
