"""
Created on Fri Jul  5 22:27:09 2019

@author: Shane
"""

from pydub import AudioSegment
from pydub.playback import play

sound_stereo = AudioSegment.from_file("eminem-killshot.wav", format="wav")

start  = int(0.4*1000)
end = int(0.17*1000)

explicit_word_sample = sound_stereo[start: end]
sound_monoL = explicit_word_sample.split_to_mono()[0]
sound_monoR = explicit_word_sample.split_to_mono()[1]

sound_monoR_inv = sound_monoR.invert_phase()

sound_CentersOut = sound_monoL.overlay(sound_monoR_inv)

sound_stereo = sound_stereo[:start]+sound_CentersOut+sound_stereo[end:]

withoutVocals = sound_stereo.export("filtertest", format="wav")