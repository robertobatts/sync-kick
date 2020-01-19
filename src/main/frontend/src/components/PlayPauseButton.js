import React from 'react';
import { makeStyles, useTheme } from '@material-ui/core/styles';
import PlayArrowIcon from '@material-ui/icons/PlayArrow';
import PauseCircleOutline from '@material-ui/icons/PauseCircleOutline';
import IconButton from '@material-ui/core/IconButton';

const useStyles = makeStyles(theme => ({
  playIcon: {
    height: 38,
    width: 38,
  },
}));

const PlayPauseButton = ({ isPlaying, play, pause }) => {
  const classes = useStyles();
  const theme = useTheme();

  return (
    <IconButton aria-label="play/pause">
      {(!isPlaying &&
        <PlayArrowIcon className={classes.playIcon} onClick={play} />) ||
        <PauseCircleOutline className={classes.playIcon} onClick={pause} />
      }
    </IconButton>
  )
}

export default PlayPauseButton;