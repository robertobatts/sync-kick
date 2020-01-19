import React, { useState } from 'react';
import { makeStyles, useTheme } from '@material-ui/core/styles';
import Typography from '@material-ui/core/Typography';
import CardContent from '@material-ui/core/CardContent';
import WordLink from './WordLink';
import handlers from '../utils/handlers';

const TranscriptedAudio = ({ track }) => {
  const [comments, setComments] = React.useState([]);
  const [hasComments, setHasComments] = React.useState([]);
  const [words, setWords] = useState(track.transcription.split(" "));

  setTimeout( function() {
    handlers.getCommentsByAudioId(track.id).then(comments => {
      setComments(comments);
      fillHasComments(comments);
    })}, 5000
  )

  const openComments = (wordIndex) => {
  }

  const fillHasComments = (comments) => {
    let hasCommentsArr = {};
    for (let i=0; i < words.length; ++i) {
      let commentsArr = comments != undefined ? comments.comments["" + i] : undefined;
      hasCommentsArr[i] = commentsArr !== undefined && commentsArr.length >= 1;
    }
    setHasComments(hasCommentsArr);
  }

  return (
    <CardContent>
      <Typography paragraph>
        { words.map((word, i) => <> 
          <WordLink word={word} key={i} comments={comments} hasComments={hasComments[i]} wordIndex={i} audioId={track.id} openComments={openComments.bind(this)} />
        </>)
        }
      </Typography>
    </CardContent>
  );
}

function hasComments(comments) {

}

export default TranscriptedAudio;