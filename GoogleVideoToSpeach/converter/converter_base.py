from abc import ABC


class BaseAudioToTextConverter(ABC):
    def convert(self, filepath: str) -> dict:
        pass

