import io
import os

from google.cloud.speech_v1 import types, SpeechClient
from .converter_base import BaseAudioToTextConverter
from configuration import PATH_TO_GOOGLE_API_KEY

# Put your key to use google application credentials
# The info how to setup it can be found here:
# https://cloud.google.com/docs/authentication/production
os.environ["GOOGLE_APPLICATION_CREDENTIALS"] = PATH_TO_GOOGLE_API_KEY


from google.cloud.speech import enums


class LLCAudioToTextConverter(BaseAudioToTextConverter):
    """ 1 minute .llc 1-chanel audio to text converter
    This converter only works with channel llc audio shorter than 1 minutes.
    In the future it would be upgraded
    """
    client: SpeechClient = None

    def __init__(self, client):
        self.client = client

    def convert(self, dir_path) -> dict:
        """
        This method convert all llc audio files from the folder to string.

        :param dir_path: Directory path to audio files
        :return: Dictionaty of strings with result for each audio
        """
        transcripted_data = {}
        for subdir, dirs, files in os.walk(dir_path):
            for file in files:
                # The name of the audio file to transcribe
                file_name = os.path.join(
                    dir_path,
                    file)

                with io.open(file_name, 'rb') as audio_file:
                    # Loads the audio into memory
                    content = audio_file.read()
                    audio = types.RecognitionAudio(content=content)

                    config = types.RecognitionConfig(
                        encoding=enums.RecognitionConfig.AudioEncoding.FLAC,
                        language_code='en-US')

                    # Detects speech in the audio file
                    response = self.client.recognize(config, audio)

                    full_text: str = ''
                    for result in response.results:
                        full_text += result.alternatives[0].transcript
                    transcripted_data[file_name] = full_text
                return transcripted_data
