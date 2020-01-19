import React from 'react';
import Modal from '@material-ui/core/Modal';
import { makeStyles } from '@material-ui/core/styles';
import Card from '@material-ui/core/Card';
import CardHeader from '@material-ui/core/CardHeader';
import CardMedia from '@material-ui/core/CardMedia';
import CardContent from '@material-ui/core/CardContent';
import CardActions from '@material-ui/core/CardActions';
import TextField from '@material-ui/core/TextField';
import handlers from '../utils/handlers';


const useStyles = makeStyles(theme => ({
  card: {
    maxWidth: 345,
    height: 500
  },
  modal: {
    height: 500,
    margin: 'auto'
  },
  media: {
    height: 0,
    paddingTop: '56.25%', // 16:9
  },
  expand: {
    transform: 'rotate(0deg)',
    marginLeft: 'auto',
    transition: theme.transitions.create('transform', {
      duration: theme.transitions.duration.shortest,
    }),
  },
  expandOpen: {
    transform: 'rotate(180deg)',
  },
  message: {
    background: '#30b3ff',
    display: "inline-block",
    marginTop: 3,
    borderRadius: 5
  },
  input: {
    bottom: 0,
    position: 'absolute'
  }
}));

const ChatPage = ({ open, handleClose, messages, audioId, wordIndex }) => {
  const classes = useStyles();

  const handleOnChange = (event) => {

  }

  const keyPress = (event) =>{
    if(event.keyCode == 13){
       console.log('value', event.target.value);
       handlers.postComment(audioId, wordIndex, "tesst", event.target.value);
       event.target.value="";
    }
 }

  return (
    <Modal open={open} onClose={handleClose} className={classes.modal}>
      <Card className={classes.card}>
        <div>
        { messages != undefined &&
          messages.map((message, i) => <div><div className={classes.message}>{message.comment}</div></div>)
        }
        </div>
      <TextField className={classes.input} id="standard-basic" label="Type here" variant="outlined" 
          onChange={handleOnChange} onKeyDown={keyPress} autoComplete="off" />
      </Card>
    </Modal>
  );

}

export default ChatPage;
