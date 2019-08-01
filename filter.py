from pydub import AudioSegment
from pydub.playback import play
import subprocess

sound_stereo = AudioSegment.from_file("Eminem-Not-Afraid.wav", format="wav")


retrieve_times_process = subprocess.Popen(['python', 'time.py', 'output_not_afraid.txt'], 
            stdout=subprocess.PIPE, 
            stderr=subprocess.STDOUT)
explicit_times,stderr = retrieve_times_process.communicate()

# remove white spaces and last element (/n)
explicit_times = explicit_times.split(' ')[:-1]

for time in explicit_times:
    start = float(time.split('-')[0])
    end = float(time.split('-')[1])
    
    # modify so it can be manipulated by phase cancellation
    start =  int((start - 0.1) * 1000)
    end = int((end + 0.1) * 1000)
    
    #phase cancellation
    explicit_word_sample = sound_stereo[start: end]
    sound_monoL = explicit_word_sample.split_to_mono()[0]
    sound_monoR = explicit_word_sample.split_to_mono()[1]

    sound_monoR_inv = sound_monoR.invert_phase()

    sound_CentersOut = sound_monoL.overlay(sound_monoR_inv)

    sound_stereo = sound_stereo[:start]+sound_CentersOut+sound_stereo[end:]


withoutVocals = sound_stereo.export("filtertest.wav", format="wav")