import React from 'react';

import AudioCard from './AudioCard';

const Screen = ({ files }) => {
  if (files.length === 0) {
    return <p>"No data"</p>;
  } else {
    return (
      <>
      {
        files.map((file, i) => <> 
          <AudioCard track={file} key={file.id} />
        </>)
      }
      </>
    );
  }
};

export default Screen;