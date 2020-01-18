import React from 'react';

import Player from './Player';
import TrackDetails from './TrackDetails';

const Screen = ({ files }) => {
  if (files.length === 0) {
    return <p>"No data"</p>;
  } else {
    return (
      <>
        <TrackDetails track={files[0]} />
        <Player track={files[0]} />
      </>
    );
  }
};

export default Screen;
