import React from 'react';
import AudioPlayer from 'react-modular-audio-player';

let rearrangedPlayer = [
  {
    className: 'top',
    style: { marginBottom: '0.4rem' },
    innerComponents: [
      {
        type: 'name',
        style: { width: '58%' }
      },
      {
        type: 'time',
        style: { justifyContent: 'flex-end' }
      }
    ]
  },
  {
    className: 'middle',
    style: { marginBottom: '0.5rem' },
    innerComponents: [
      {
        type: 'seek'
      }
    ]
  },
  {
    className: 'bottom',
    innerComponents: [
      {
        type: 'play',
        style: { width: '12.5%', justifyContent: 'flex-end' }
      },
      {
        type: 'rewind',
        style: { width: '12.5%', justifyContent: 'flex-end' }
      },
      {
        type: 'forward',
        style: { width: '12.5%' }
      },
      {
        type: 'loop',
        style: { width: '12.5%' }
      },
      {
        type: 'volume',
        style: { width: '48%' }
      }
    ]
  }
];

const Player = ({ track }) => {
  let playlist = [
    {
      src: track.downloadUrl,
      title: track.title,
      artist: track.artist
    }
  ];

  return (
    <AudioPlayer
      audioFiles={playlist}
      rearrange={rearrangedPlayer}
      fontFamily="serif"
      fontSize="1.5rem"
      playerWidth="15rem"
    />
  );
};

export default Player;
