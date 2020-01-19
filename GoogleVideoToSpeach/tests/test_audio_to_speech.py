from google.cloud import speech_v1
from converter.video_to_speach_converter import LLCAudioToTextConverter


def test_convert_llc_to_text():
    converter = LLCAudioToTextConverter(client=speech_v1.SpeechClient())
    data = converter.convert(dir_path=r'.\resources')
    assert len(data) == 1, 'Assert no data was converted'
