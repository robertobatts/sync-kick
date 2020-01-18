import React from 'react';

const TrackDetails = ({ track }) => {
  return (
    <>
      <p>{track.description}</p>
      <p>{track.category}</p>
      <img src={track.pictureUrl} alt="artwork"></img>
    </>
  );
};

export default TrackDetails;
