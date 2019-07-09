# -*- coding: utf-8 -*-
"""
Created on Fri Jul  5 22:27:09 2019

@author: hpt09
"""

import argparse
import json


parser = argparse.ArgumentParser()
parser.add_argument("word")
args = parser.parse_args()

with open('output_not_afraid.txt') as f:
    data = json.load(f)

wordTimes = ""

for word in data:
    if word['word'] == args.word:
        startTime = word['start']
        endTime = word['end']
        wordTimes = wordTimes + str(startTime) + "-" + str(endTime) + " "

print(wordTimes)
        


