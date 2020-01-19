import React, { useState } from 'react';
import ChatPage from './ChatPage'
import { makeStyles } from '@material-ui/core/styles';

const useStyles = makeStyles(theme => ({
  word: {
    '&:hover': {
      cursor: 'pointer',
      backgroundColor: 'black',
      borderRadius: '3px',
      color: 'white'
    }
  },
  commentedWord: {
    backgroundColor: 'green',
    borderRadius: '3px',
    color: 'white',
    '&:hover': {
      cursor: 'pointer',
      backgroundColor: 'blue'
    }
  }
}));

const WordLink = ({ word, wordIndex, comments, hasComments, openComments, audioId }) => {
  const classes = useStyles();

  let messages = comments.comments !== undefined ? comments.comments[wordIndex] : [];

  const [open, setOpen] = React.useState(false);

  const trigger = () => {
    openComments(wordIndex)
    setOpen(true);
  }

  const handleClose = () => {
    setOpen(false);
  };

  return (
    <>
      <span
        className={hasComments ? classes.commentedWord : classes.word}
        onClick={trigger}
      >
        {`${word} `}
      </span> 
      { comments != undefined &&
        <ChatPage open={open} handleClose={handleClose.bind(this)} messages={messages} audioId={audioId} wordIndex={wordIndex}></ChatPage>
      }
    </>
  );
};

export default WordLink;
