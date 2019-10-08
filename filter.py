from pydub import AudioSegment
from pydub.playback import play
import subprocess
import sys

# parse args from command line
if len(sys.argv) > 1: 
    audio_file = sys.argv[1]
else:
    print("No audio file provided")
    sys.exit()

if len(sys.argv) > 2: 
    transcript_file = sys.argv[2]
else:
    print("No transcript file provided")
    sys.exit()


sound_stereo = AudioSegment.from_file(audio_file, format="mp3")


retrieve_times_process = subprocess.Popen(['python', 'time.py', transcript_file], 
            stdout=subprocess.PIPE, 
            stderr=subprocess.STDOUT)
explicit_times,stderr = retrieve_times_process.communicate()

# remove white spaces and last element (/n)
explicit_times = explicit_times.split(' ')[:-1]
# print explicit_times
for time in explicit_times:
    start = float(time.split('-')[0])
    end = float(time.split('-')[1])
    #print "start: " + str(start) + " end: " + str(end)

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


withoutVocals = sound_stereo.export("FILTERED-"+audio_file, format="wav")
